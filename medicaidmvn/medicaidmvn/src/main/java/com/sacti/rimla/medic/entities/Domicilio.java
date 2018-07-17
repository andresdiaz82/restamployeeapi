package com.sacti.rimla.medic.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

import com.sacti.rimla.medic.dto.DomicilioDTO;
import com.sacti.rimla.medic.dto.MainDTO;


/**
 * The persistent class for the domicilio database table.
 * 
 */
@Entity
@Table(name="domicilio")
@NamedQuery(name="Domicilio.findAll", query="SELECT d FROM Domicilio d")
public class Domicilio implements Serializable, MainEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "iddomicilio")
	private int iddomicilio;
	
	@Column(name = "calle")
	private String calle;

	@Column(name = "celular")
	private String celular;

	@Column(name = "ciudad")
	private String ciudad;

	@Column(name="codigo_postal")
	private int codigoPostal;

	@Column(name = "colonia")
	private String colonia;

	@Column(name = "correo")
	private String correo;

	@Column(name = "estado")
	private String estado;

	@Column(name = "interior")
	private int interior;

	@Column(name="metodo_contacto")
	private int metodoContacto;

	@Column(name = "numero")
	private int numero;

	@Column(name="telefono_fijo")
	private String telefonoFijo;
	
	@Column(name = "dependencia")
	private int dependencia;
	
	//@OneToOne(mappedBy="domicilio", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	//Pacientes paciente;
	
	public Domicilio() {
	}

	public int getIddomicilio() {
		return this.iddomicilio;
	}

	public int getDependencia() {
		return dependencia;
	}

	public void setDependencia(int dependencia) {
		this.dependencia = dependencia;
	}

	public void setIddomicilio(int iddomicilio) {
		this.iddomicilio = iddomicilio;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getColonia() {
		return this.colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getInterior() {
		return this.interior;
	}

	public void setInterior(int interior) {
		this.interior = interior;
	}

	public int getMetodoContacto() {
		return this.metodoContacto;
	}

	public void setMetodoContacto(int metodoContacto) {
		this.metodoContacto = metodoContacto;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTelefonoFijo() {
		return this.telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	
	/*public Pacientes getPaciente() {
		return this.paciente;
	}
	
	public void setPaciente(Pacientes paciente) {
		this.paciente = paciente;
	}*/

	@Override
	public MainDTO toDTO() {
		// TODO Auto-generated method stub
		DomicilioDTO domicilioDTO = new DomicilioDTO();
		domicilioDTO.setIddomicilio(this.iddomicilio);
		domicilioDTO.setCalle(this.calle);
		if(StringUtils.isNotBlank(this.celular)) {
			domicilioDTO.setCelular(this.celular);
		}
		domicilioDTO.setCiudad(this.ciudad);
		domicilioDTO.setCodigoPostal(this.codigoPostal);
		domicilioDTO.setColonia(this.colonia);
		if(StringUtils.isNotBlank(this.correo)) {
			domicilioDTO.setCorreo(this.correo);
		}
		domicilioDTO.setEstado(this.estado);
		if(this.interior != 0) {
			domicilioDTO.setInterior(this.interior);
		}
		domicilioDTO.setMetodoContacto(this.metodoContacto);
		domicilioDTO.setNumero(this.numero);
		domicilioDTO.setTelefonoFijo(this.telefonoFijo);
		domicilioDTO.setDependencia(this.dependencia);		
		return domicilioDTO;
	}

}