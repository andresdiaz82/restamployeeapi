package com.oracle.employee.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oracle.employee.service.EmployeeService;

public class TestEmployeeService {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeService service = (EmployeeService) ctx.getBean("employeeServiceImpl");
		try {
			String res = service.findEmployeeById(1);
			System.out.println(res);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
