package com.oracle.employee.utils;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.oracle.employee.dto.EmployeeDTO;
import com.oracle.employee.entities.Employee;


public class EmployeeUtils {

	static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	static final String defaultTimeOffset = " 00:00:00";
	//Format of CSV name,middleInitial,lastName,DOB,DOE
	public static Employee buildEmployeeFromArray(String[] properties) {
		Employee employee = new Employee();
		if(properties.length < 5)
			return null;
		try {
			if(properties[0] != null && !properties[0].equals("")) {
				 if(isAlpha(properties[0])) {
					 employee.setName(properties[0]);
				 }
				 else {
					 return null;
				 }
			}else {
				return null;
			}
			if(properties[1] != null && !properties[1].equals("")) {
				if(isAlpha(properties[1]) && properties[1].length() == 1) {
					employee.setMiddleInitial(properties[1]);
				}
				else {
					return null;
				}
			}
			if(properties[2] != null && !properties[2].equals("")) {
				if(isAlpha(properties[2])){
					employee.setLastName(properties[2]);
				}
				else {
					return null;
				}
			}else {
				return null;
			}
			if(properties[3] != null && !properties[3].equals("")) {
				try {
					employee.setDateOfBirth(LocalDateTime.parse(properties[3]+defaultTimeOffset, df));
				}catch(DateTimeParseException p) {
					p.printStackTrace();
					return null;
				}catch(Exception e) {
					e.printStackTrace();
					return null;
				}
			}
			else {
				return null;
			}
			//If dat of employment is not present i considered entering today's date
			if(properties[4] != null) {
				try {
					employee.setDateOfEMployment(LocalDateTime.parse(properties[4]+defaultTimeOffset, df));
				}catch(DateTimeParseException p) {
					p.printStackTrace();
					return null;
				}catch(Exception e) {
					e.printStackTrace();
					return null;
				}
			}
			else {
				employee.setDateOfEMployment(LocalDateTime.now());
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return employee;
	}
	
	public static Employee buildEmployeeEntity(EmployeeDTO empDto) {
		Employee employee = new Employee();
		
		try {
			if(empDto.getName() != null && !employee.getName().equals("")) {
				 if(isAlpha(empDto.getName())) {
					 employee.setName(empDto.getName());
				 }
				 else {
					 return null;
				 }
			}else {
				return null;
			}
			if(empDto.getMiddleInitial() != null && !empDto.getMiddleInitial().equals("")) {
				if(isAlpha(empDto.getMiddleInitial()) && empDto.getMiddleInitial().length() == 1) {
					employee.setMiddleInitial(empDto.getMiddleInitial());
				}
				else {
					return null;
				}
			}
			if(empDto.getLastName() != null && !empDto.getLastName().equals("")) {
				if(isAlpha(empDto.getLastName())){
					employee.setLastName(empDto.getLastName());
				}
				else {
					return null;
				}
			}else {
				return null;
			}
			if(empDto.getDateOfBirth() != null) {
				try {
					employee.setDateOfBirth(LocalDateTime.parse(empDto.getDateOfBirth()+defaultTimeOffset, df));
				}catch(DateTimeParseException p) {
					p.printStackTrace();
					return null;
				}catch(Exception e) {
					e.printStackTrace();
					return null;
				}
			}
			else {
				return null;
			}
			//If dat of employment is not present i considered entering today's date
			if(empDto.getDateOfEMployment() != null) {
				try {
					employee.setDateOfEMployment(LocalDateTime.parse(empDto.getDateOfEMployment()+defaultTimeOffset, df));
				}catch(DateTimeParseException p) {
					p.printStackTrace();
					return null;
				}catch(Exception e) {
					e.printStackTrace();
					return null;
				}
			}
			else {
				employee.setDateOfEMployment(LocalDateTime.now());
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return employee;
	}
	
	public static EmployeeDTO toDto(Employee emp) {
		
		EmployeeDTO empDto = new EmployeeDTO();
		empDto.setId(emp.getId());
		if(emp.getMiddleInitial() != null) {
			empDto.setMiddleInitial(emp.getMiddleInitial());
		}
		empDto.setLastName(emp.getLastName());
		empDto.setDateOfBirth(emp.getDateOfBirth().format(df));
		empDto.setDateOfEMployment(emp.getDateOfEMployment().format(df));
		empDto.setState(emp.getState());
		
		return empDto;
	}
	
	protected static boolean isAlpha(String str) {
		return str.matches("[a-zA-Z]+");
	}
	
}
