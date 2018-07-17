package com.sacti.rimla.medic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sacti.rimla.medic.dao.DependenciaDAO;
import com.sacti.rimla.medic.dto.DependenciaDTO;
import com.sacti.rimla.medic.entities.Dependencia;
import com.sacti.rimla.medic.service.DependenciaService;

@Service
public class DependenciaServiceImpl implements DependenciaService {

	@Autowired
	private DependenciaDAO dependenciaDAO;

	private static final Logger logger = Logger.getLogger(DependenciaServiceImpl.class);
	
	@Transactional
	public void insertaDependencia(DependenciaDTO dependencia) throws Exception {
		// TODO Auto-generated method stub
		if(dependencia.getId() == null) {
			logger.info("Insertando dependencia en la DB");
			dependenciaDAO.insertaDependencia((Dependencia) dependencia.toEntity());
		}
		else {
			logger.info("Actualizando dependencia en la DB");
			dependenciaDAO.actualizaDependencia((Dependencia) dependencia.toEntity()); 
		}
	}

	public List<DependenciaDTO> consultaDependencias() throws Exception {
		// TODO Auto-generated method stub
		logger.info("Consulta de dependencias en la DB");
		List<Dependencia> dependencias = dependenciaDAO.consultaDependencias();
		ArrayList<DependenciaDTO> dependenciasResult = new ArrayList<DependenciaDTO>();
		DependenciaDTO auxDTO;
		for(Dependencia dep:dependencias) {
			auxDTO = (DependenciaDTO) dep.toDTO();
			dependenciasResult.add(auxDTO);
		}
		return dependenciasResult; 
	}

	@Override
	public DependenciaDTO consultaDependenciaId(int id) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Consulta de dependencias en la DB utilizando id: "+id);
		Dependencia dependencia = dependenciaDAO.consultaDependenciaId(id);
		return (DependenciaDTO) dependencia.toDTO();
	}
	
	
	

}
