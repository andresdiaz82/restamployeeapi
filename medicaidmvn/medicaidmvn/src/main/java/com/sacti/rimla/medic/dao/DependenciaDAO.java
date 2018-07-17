package com.sacti.rimla.medic.dao;

import java.util.List;

import com.sacti.rimla.medic.entities.Dependencia;

public interface DependenciaDAO {

	void insertaDependencia(Dependencia dependencia);
	
	List<Dependencia> consultaDependencias();
	
	Dependencia consultaDependenciaId(int id);
	
	List<Dependencia> consultaDependenciaNombre(String nombre);
	
	void actualizaDependencia(Dependencia dependencia);
}
