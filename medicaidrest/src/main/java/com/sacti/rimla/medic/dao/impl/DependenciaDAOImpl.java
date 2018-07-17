package com.sacti.rimla.medic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.sacti.rimla.medic.dao.DependenciaDAO;
import com.sacti.rimla.medic.entities.Dependencia;

@Repository
public class DependenciaDAOImpl implements DependenciaDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	public void insertaDependencia(Dependencia dependencia) {
		// TODO Auto-generated method stub
		entityManager.persist(dependencia);
	}

	public List<Dependencia> consultaDependencias() {
		// TODO Auto-generated method stub
		CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Dependencia> cQuery = cBuilder.createQuery(Dependencia.class);
		Root<Dependencia> root = cQuery.from(Dependencia.class);
		cQuery.select(root);
		return entityManager.createQuery(cQuery).getResultList();
	}

	public Dependencia consultaDependenciaId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Dependencia> consultaDependenciaNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
