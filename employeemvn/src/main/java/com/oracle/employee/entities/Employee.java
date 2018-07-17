package com.oracle.employee.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Decided to use an orm with medium mapping as it helps avoid sql injection attacks
 * by using named queries or let the entity manager query the db forcing the use of
 * parameterized queries at low level of the orm, as well as there are plenty of
 * DB connectivity algorithms  which i am showcasing in the dataload utility
 * 
 *
 */
@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="select e from Employee e")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="middle_initial")
	private String middleInitial;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="date_of_birth")
	private LocalDateTime dateOfBirth;
	
	@Column(name="date_of_employment")
	private LocalDateTime dateOfEMployment;
	
	@Column(name="state")
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDateTime getDateOfEMployment() {
		return dateOfEMployment;
	}

	public void setDateOfEMployment(LocalDateTime dateOfEMployment) {
		this.dateOfEMployment = dateOfEMployment;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
}
