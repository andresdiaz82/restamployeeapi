package com.sacti.rimla.medic.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sacti.rimla.medic.dao.PacientesDAO;
import com.sacti.rimla.medic.entities.Pacientes;

@Repository
public class PacientesDAOImpl implements PacientesDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Pacientes insertaPaciente(Pacientes paciente) {
		// TODO Auto-generated method stub
		entityManager.persist(paciente);
		return paciente;
	}
	
	
}
