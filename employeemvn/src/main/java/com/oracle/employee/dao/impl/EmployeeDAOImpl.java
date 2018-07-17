package com.oracle.employee.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.employee.dao.EmployeeDAO;
import com.oracle.employee.entities.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	@Transactional
	public void createEmployee(Employee emp) throws Exception{
		// TODO Auto-generated method stub
		entityManager.persist(emp);
		entityManager.flush();
	}

	@Override
	@Transactional
	public void deleteEmployee(Employee emp) throws Exception{
		// TODO Auto-generated method stub
		entityManager.merge(emp);
		entityManager.flush();
	}

	@Override
	public Employee findEmployeeByID(Integer id) throws Exception{
		// TODO Auto-generated method stub
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> from = criteria.from(Employee.class);
		criteria.select(from);
		ParameterExpression<Integer> param = builder.parameter(Integer.class);
		criteria.where(builder.equal(from.get("id"), param));
		TypedQuery<Employee> query = entityManager.createQuery(criteria);
		query.setParameter(param, id);
		return query.getSingleResult();
	}

	@Override
	public List<Employee> findByName(String name) throws Exception{
		// TODO Auto-generated method stub
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> from = criteria.from(Employee.class);
		criteria.select(from);
		ParameterExpression<String> param = builder.parameter(String.class);
		criteria.where(builder.equal(from.get("name"), param));
		TypedQuery<Employee> query = entityManager.createQuery(criteria);
		query.setParameter(param, name);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void updateEmployee(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		entityManager.merge(emp);
		entityManager.flush();
	}

}
