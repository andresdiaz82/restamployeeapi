package com.oracle.employee.service;

import java.io.InputStream;

public interface EmployeeService {

	void addEmployee(String emp) throws Exception;
	
	void removeEmployee(Integer id) throws Exception;
	
	void updateEmployee(String emp) throws Exception;
	
	String findEmployee(String name) throws Exception;
	
	String findEmployeeById(Integer id) throws Exception;
	
	String findActive() throws Exception;
	
	void processEmployeesCsv(InputStream inputStream);
	
	void processEmployeesJson(String jsonEmps);
	
}
