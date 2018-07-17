package com.oracle.employee.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oracle.employee.dao.EmployeeDAO;
import com.oracle.employee.dto.EmployeeDTO;
import com.oracle.employee.entities.Employee;
import com.oracle.employee.enums.DBOperation;
import com.oracle.employee.service.EmployeeService;
import com.oracle.employee.utils.DBOperations;
import com.oracle.employee.utils.EmployeeUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	Gson gson = new Gson();
	
	@Override
	public void addEmployee(String emp) throws Exception {
		// TODO Auto-generated method stub
		EmployeeDTO empDto = gson.fromJson(emp, EmployeeDTO.class);
		Employee empE = EmployeeUtils.buildEmployeeEntity(empDto);
		if(empE == null) 
			throw new Exception("Invalid data");
		empE.setState(1);
		employeeDAO.createEmployee(empE);
	}

	@Override
	public void removeEmployee(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Employee emp = employeeDAO.findEmployeeByID(id);
		emp.setState(0);
		employeeDAO.deleteEmployee(emp);
	}

	@Override
	public String findEmployee(String name) throws Exception {
		// TODO Auto-generated method stub
		List<EmployeeDTO> emps = new ArrayList<>();
				employeeDAO.findByName(name).stream().filter(empl->1==empl.getState()).forEach(e->{emps.add(EmployeeUtils.toDto(e));});
		return gson.toJson(emps);
	}

	@Override
	public String findEmployeeById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		EmployeeDTO emp = EmployeeUtils.toDto(employeeDAO.findEmployeeByID(id));
		return gson.toJson(emp.getState() == 1?emp:null);
	}

	@Override
	public void updateEmployee(String emp) throws Exception {
		// TODO Auto-generated method stub
		Employee empAux = EmployeeUtils.buildEmployeeEntity(gson.fromJson(emp, EmployeeDTO.class));
		if(empAux == null)
			throw new Exception("Invalid data");
		Employee empE = employeeDAO.findEmployeeByID(empAux.getId());
		if(empAux.getName() != null && !empAux.getName().equals("")) {
			empE.setName(empAux.getName());
		}
		if(empAux.getMiddleInitial() != null && !empAux.getMiddleInitial().equals("")) {
			empE.setMiddleInitial(empAux.getMiddleInitial());
		}
		if(empAux.getLastName() != null && !empAux.getLastName().equals("")) {
			empE.setLastName(empAux.getLastName());
		}
		if(empAux.getDateOfBirth() != null) {
			empE.setDateOfBirth(empAux.getDateOfBirth());
		}
		if(empAux.getDateOfEMployment() != null) {
			empE.setDateOfEMployment(empAux.getDateOfEMployment());
		}
		employeeDAO.updateEmployee(empE);
	}

	@Override
	public String findActive() throws Exception {
		// TODO Auto-generated method stub
		DBOperations dbOps = new DBOperations();
		List<EmployeeDTO> emps = dbOps.executeDBOperation(DBOperation.READ, null);
		return gson.toJson(emps);
	}

	@Override
	public void processEmployeesCsv(InputStream inputStream) {
		// TODO Auto-generated method stub
		try {
			BufferedReader bfReader = new BufferedReader(new InputStreamReader(inputStream));
			String line = "";
			while((line=bfReader.readLine()) != null) {
				Employee emp = EmployeeUtils.buildEmployeeFromArray(line.split(","));
				if(emp != null) {
					emp.setState(1);
					employeeDAO.createEmployee(emp);
				}
				else {
					System.out.println("Invalid Data");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void processEmployeesJson(String jsonEmps) {
		// TODO Auto-generated method stub
		Type listType = new TypeToken<List<EmployeeDTO>>() {}.getType();
		try {
			List<EmployeeDTO> emps = gson.fromJson(jsonEmps, listType);
			for(EmployeeDTO empDto:emps) {
				Employee emp = EmployeeUtils.buildEmployeeEntity(empDto);
				if(emp != null) {
					emp.setState(1);
					employeeDAO.createEmployee(emp);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
