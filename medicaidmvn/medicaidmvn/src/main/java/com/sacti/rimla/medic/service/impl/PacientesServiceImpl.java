package com.sacti.rimla.medic.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sacti.rimla.medic.dao.PacientesDAO;
import com.sacti.rimla.medic.dto.PacienteDTO;
import com.sacti.rimla.medic.entities.Pacientes;
import com.sacti.rimla.medic.service.PacientesService;

public class PacientesServiceImpl implements PacientesService {

	@Autowired
	PacientesDAO pacientesDAO;
	
	private static final Logger logger = Logger.getLogger(PacientesServiceImpl.class);
	
	@Override
	public void insertaPaciente(PacienteDTO paciente) throws Exception {
		// TODO Auto-generated method stub
		pacientesDAO.insertaPaciente((Pacientes) paciente.toEntity());
	}

}
