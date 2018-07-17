package com.sacti.rimla.medic.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the pacientes database table.
 * 
 */
@Entity
@NamedQuery(name="Pacientes.findAll", query="SELECT p FROM Pacientes p")
public class Pacientes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idpaciente;

	@Column(name="apellido_materno")
	private String apellidoMaterno;

	@Column(name="apellido_paterno")
	private String apellidoPaterno;

	private String curp;

	private String fotografia;

	@Lob
	@Column(name="huella_digital")
	private byte[] huellaDigital;

	private String nombre;

	private String nsp;

	private String nss;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dependencia")
	private Dependencia dependenciaBean;

	//bi-directional one-to-one association to Domicilio
	@OneToOne(mappedBy="paciente", fetch=FetchType.LAZY)
	private Domicilio domicilio;

	public Pacientes() {
	}

	public int getIdpaciente() {
		return this.idpaciente;
	}

	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getFotografia() {
		return this.fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public byte[] getHuellaDigital() {
		return this.huellaDigital;
	}

	public void setHuellaDigital(byte[] huellaDigital) {
		this.huellaDigital = huellaDigital;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNsp() {
		return this.nsp;
	}

	public void setNsp(String nsp) {
		this.nsp = nsp;
	}

	public String getNss() {
		return this.nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public Dependencia getDependenciaBean() {
		return this.dependenciaBean;
	}

	public void setDependenciaBean(Dependencia dependenciaBean) {
		this.dependenciaBean = dependenciaBean;
	}

	public Domicilio getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

}