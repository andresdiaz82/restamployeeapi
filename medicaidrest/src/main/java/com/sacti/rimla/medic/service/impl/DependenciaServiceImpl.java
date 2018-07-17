package com.sacti.rimla.medic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sacti.rimla.medic.dao.DependenciaDAO;
import com.sacti.rimla.medic.dto.DependenciaDTO;
import com.sacti.rimla.medic.dto.MainDTO;
import com.sacti.rimla.medic.entities.Dependencia;
import com.sacti.rimla.medic.service.DependenciaService;

@Service
public class DependenciaServiceImpl implements DependenciaService {

	@Autowired
	private DependenciaDAO dependenciaDAO;

	@Transactional
	public void insertaDependencia(DependenciaDTO dependencia) throws Exception {
		// TODO Auto-generated method stub
		dependenciaDAO.insertaDependencia((Dependencia) dependencia.toEntity());
	}

	public List<DependenciaDTO> consultaDependencias() {
		// TODO Auto-generated method stub
		List<Dependencia> dependencias = dependenciaDAO.consultaDependencias();
		ArrayList<DependenciaDTO> dependenciasResult = new ArrayList<DependenciaDTO>();
		DependenciaDTO auxDTO;
		for(Dependencia dep:dependencias) {
			auxDTO = (DependenciaDTO) dep.toDTO();
			dependenciasResult.add(auxDTO);
		}
		return dependenciasResult; 
	}
	
	
	

}
