package com.sacti.rimla.medic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sacti.rimla.medic.dto.DependenciaDTO;
import com.sacti.rimla.medic.dto.DomicilioDTO;
import com.sacti.rimla.medic.dto.FamiliaresDTO;
import com.sacti.rimla.medic.dto.PacienteDTO;
import com.sacti.rimla.medic.service.DependenciaService;
import com.sacti.rimla.medic.service.PacientesService;

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
		
		//service.insertaDependencia(depDTO);
		
		PacientesService pservice = (PacientesService) ctx.getBean("pacientesService");
		
		PacienteDTO paciente = new PacienteDTO();
		paciente.setNombre("Andres Esteban");
		paciente.setApellidoPaterno("Diaz");
		paciente.setApellidoMaterno("Cortes");
		paciente.setCurp("DICA821128HJCZRN03");
		paciente.setNss("044332299");
		paciente.setDependencia(3);
		DomicilioDTO domicilio = new DomicilioDTO();
		domicilio.setCalle("Elfaro");
		domicilio.setCodigoPostal(45550);
		domicilio.setColonia("El vergel");
		domicilio.setCorreo("andrespiranha@hotmail.com");
		domicilio.setEstado("Jalisco");
		domicilio.setCelular("3313120589");
		domicilio.setNumero(1342);
		domicilio.setTelefonoFijo("31092156");
		domicilio.setNumero(54);
		domicilio.setMetodoContacto(1);
		domicilio.setDependencia(3);
		//paciente.setDomicilio(domicilio);
		paciente.setDireccion(2);
		FamiliaresDTO familiar1 = new FamiliaresDTO();
		familiar1.setNombre("Andrea Camila");
		familiar1.setApellidoPaterno("Diaz");
		familiar1.setApellidoMaterno("Zamora");
		familiar1.setDomicilio(domicilio);
		familiar1.setDependencia(3);
		FamiliaresDTO familiar2 = new FamiliaresDTO();
		familiar2.setNombre("Ximena");
		familiar2.setApellidoPaterno("Diaz");
		familiar2.setApellidoMaterno("Zamora");
		familiar2.setDomicilio(domicilio);
		familiar2.setDependencia(3);
		List<FamiliaresDTO> familiaresList = new ArrayList<FamiliaresDTO>();
		familiaresList.add(familiar1);
		familiaresList.add(familiar2);
		//paciente.setFamiliares(familiaresList);
		
		pservice.insertaPaciente(paciente);
	}
}
