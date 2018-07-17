package com.sacti.rimla.medic.dto;

import org.apache.commons.lang.StringUtils;

import com.sacti.rimla.medic.entities.Domicilio;
import com.sacti.rimla.medic.entities.MainEntity;

public class DomicilioDTO implements MainDTO {

	private Integer iddomicilio;
	
	private String calle;

	private String celular;

	private String ciudad;

	private Integer codigoPostal;

	private String colonia;

	private String correo;

	private String estado;

	private Integer interior;

	private Integer metodoContacto;

	private Integer numero;

	private String telefonoFijo;
	
	private Integer dependencia;

	public Integer getIddomicilio() {
		return iddomicilio;
	}

	public void setIddomicilio(Integer iddomicilio) {
		this.iddomicilio = iddomicilio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getInterior() {
		return interior;
	}

	public void setInterior(Integer interior) {
		this.interior = interior;
	}

	public Integer getMetodoContacto() {
		return metodoContacto;
	}

	public void setMetodoContacto(Integer metodoContacto) {
		this.metodoContacto = metodoContacto;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public Integer getDependencia() {
		return dependencia;
	}

	public void setDependencia(Integer dependencia) {
		this.dependencia = dependencia;
	}

	@Override
	public MainEntity toEntity() {
		Domicilio domicilio = new Domicilio();
		
		if(this.iddomicilio != null) {
			domicilio.setIddomicilio(this.iddomicilio);
		}
		if(StringUtils.isNotBlank(this.calle)) {
			domicilio.setCalle(this.calle);
		}
		if(StringUtils.isNotBlank(this.celular)) {
			domicilio.setCelular(this.celular);
		}
		if(StringUtils.isNotBlank(this.ciudad)) {
			domicilio.setCiudad(this.ciudad);
		}
		if(this.codigoPostal != null) {
			domicilio.setCodigoPostal(this.codigoPostal);
		}
		if(StringUtils.isNotBlank(this.colonia)) {
			domicilio.setColonia(this.colonia);
		}
		if(StringUtils.isNotBlank(this.correo)) {
			domicilio.setCorreo(this.correo);
		}
		if(StringUtils.isNotBlank(this.estado)) {
			domicilio.setEstado(this.estado);
		}
		if(this.interior != null) {
			domicilio.setInterior(this.interior);
		}
		if(this.metodoContacto != null) {
			domicilio.setMetodoContacto(this.metodoContacto);
		}
		if(this.numero != null) {
			domicilio.setNumero(this.numero);
		}
		if(StringUtils.isNotBlank(telefonoFijo)) {
			domicilio.setTelefonoFijo(this.telefonoFijo);
		}
		if(this.dependencia != null) {
			domicilio.setDependencia(this.dependencia);
		}
		return (Domicilio) domicilio;
	}
	
}
