package com.sacti.rimla.medic.service;

import java.util.List;

import com.sacti.rimla.medic.dto.DependenciaDTO;

public interface DependenciaService {
	
	public void insertaDependencia(DependenciaDTO dependencia) throws Exception;
	
	public List<DependenciaDTO> consultaDependencias();
	
}
