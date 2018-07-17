package com.sacti.rimla.medic.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the domicilio database table.
 * 
 */
@Entity
@NamedQuery(name="Domicilio.findAll", query="SELECT d FROM Domicilio d")
public class Domicilio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int iddomicilio;
	
	@Column(name = "calle")
	private String calle;

	@Column()
	private String celular;

	private String ciudad;

	@Column(name="codigo_postal")
	private int codigoPostal;

	private String colonia;

	private String correo;

	private String estado;

	private int interior;

	@Column(name="metodo_contacto")
	private int metodoContacto;

	private int numero;

	@Column(name="telefono_fijo")
	private String telefonoFijo;

	//bi-directional one-to-one association to Pacientes
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="dependencia", referencedColumnName="dependencia"),
		@JoinColumn(name="iddomicilio", referencedColumnName="direccion")
		})
	private Pacientes paciente;

	//bi-directional one-to-one association to Familiares
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="dependencia", referencedColumnName="dependencia"),
		@JoinColumn(name="iddomicilio", referencedColumnName="direccion")
		})
	private Familiares familiare;

	public Domicilio() {
	}

	public int getIddomicilio() {
		return this.iddomicilio;
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

	public Pacientes getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Pacientes paciente) {
		this.paciente = paciente;
	}

	public Familiares getFamiliare() {
		return this.familiare;
	}

	public void setFamiliare(Familiares familiare) {
		this.familiare = familiare;
	}

}