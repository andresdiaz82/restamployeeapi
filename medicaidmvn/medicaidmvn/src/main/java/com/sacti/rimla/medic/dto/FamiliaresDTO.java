package com.sacti.rimla.medic.dto;

import com.sacti.rimla.medic.entities.MainEntity;
import com.sacti.rimla.medic.entities.Familiares;

import org.apache.commons.lang.StringUtils;

import com.sacti.rimla.medic.entities.Domicilio;

public class FamiliaresDTO implements MainDTO {

	private Integer idfamiliar;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer direccion;
	private Integer idpaciente;
	private Integer dependencia;
	private DomicilioDTO domicilio;
	public Integer getIdfamiliar() {
		return idfamiliar;
	}
	public void setIdfamiliar(Integer idfamiliar) {
		this.idfamiliar = idfamiliar;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public Integer getDireccion() {
		return direccion;
	}
	public void setDireccion(Integer direccion) {
		this.direccion = direccion;
	}
	public Integer getIdpaciente() {
		return idpaciente;
	}
	public void setIdpaciente(Integer idpaciente) {
		this.idpaciente = idpaciente;
	}
	public Integer getDependencia() {
		return dependencia;
	}
	public void setDependencia(Integer dependencia) {
		this.dependencia = dependencia;
	}
	public DomicilioDTO getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}
	@Override
	public MainEntity toEntity() {
		// TODO Auto-generated method stub
		Familiares familiares = new Familiares();
		if(StringUtils.isNotBlank(this.getNombre())) {
			familiares.setNombre(nombre);
		}
		if(StringUtils.isNotBlank(this.getApellidoPaterno())) {
			familiares.setApellidoPaterno(this.getApellidoPaterno());
		}
		if(StringUtils.isNotBlank(this.getApellidoMaterno())) {
			familiares.setAppelidoMaterno(this.getApellidoMaterno());
		}
		if(this.getDependencia() != null) {
			familiares.setDependencia(this.getDependencia());
		}
		if(this.getDomicilio() != null) {
			Domicilio domicilio = (Domicilio) this.getDomicilio().toEntity();
			familiares.setDomicilio(domicilio);
		}
		return familiares;
	}
	
}
