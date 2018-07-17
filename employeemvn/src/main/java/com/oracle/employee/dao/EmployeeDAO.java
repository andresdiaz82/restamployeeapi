package com.oracle.employee.dao;

import java.util.List;

import com.oracle.employee.entities.Employee;

public interface EmployeeDAO {

	void createEmployee(Employee emp) throws Exception;
	
	void deleteEmployee(Employee emp) throws Exception;
	
	void updateEmployee(Employee emp) throws Exception;
	
	Employee findEmployeeByID(Integer id) throws Exception;
	
	List<Employee> findByName(String name) throws Exception;
	
}
