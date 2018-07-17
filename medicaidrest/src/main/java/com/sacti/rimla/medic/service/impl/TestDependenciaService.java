package com.sacti.rimla.medic.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sacti.rimla.medic.dto.DependenciaDTO;
import com.sacti.rimla.medic.service.DependenciaService;

public class TestDependenciaService {
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		DependenciaService service = (DependenciaService) ctx.getBean("dependenciaServiceImpl");
		
		DependenciaDTO depDTO = new DependenciaDTO();
		depDTO.setNombre_dependencia("test");
		depDTO.setResponsable_dependencia("testresp");
		depDTO.setCalle("testcalle");
		depDTO.setCiudad("testciudad");
		depDTO.setColonia("testcolonia");
		depDTO.setCp(45500);
		depDTO.setNumero(15);
		depDTO.setInterior(3);
		depDTO.setEstado("testestado");
		
		service.insertaDependencia(depDTO);
	}
}
