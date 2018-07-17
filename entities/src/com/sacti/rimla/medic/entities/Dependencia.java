package com.sacti.rimla.medic.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dependencia database table.
 * 
 */
@Entity
@NamedQuery(name="Dependencia.findAll", query="SELECT d FROM Dependencia d")
public class Dependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String calle;

	private String ciudad;

	private int codigopostal;

	private String colonia;

	private String estado;

	private String nombre;

	@Column(name="numero_ext")
	private int numeroExt;

	@Column(name="numero_int")
	private int numeroInt;

	private String responsable;

	//bi-directional many-to-one association to Pacientes
	@OneToMany(mappedBy="dependenciaBean")
	private List<Pacientes> pacientes;

	public Dependencia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCodigopostal() {
		return this.codigopostal;
	}

	public void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}

	public String getColonia() {
		return this.colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroExt() {
		return this.numeroExt;
	}

	public void setNumeroExt(int numeroExt) {
		this.numeroExt = numeroExt;
	}

	public int getNumeroInt() {
		return this.numeroInt;
	}

	public void setNumeroInt(int numeroInt) {
		this.numeroInt = numeroInt;
	}

	public String getResponsable() {
		return this.responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public List<Pacientes> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Pacientes> pacientes) {
		this.pacientes = pacientes;
	}

	public Pacientes addPaciente(Pacientes paciente) {
		getPacientes().add(paciente);
		paciente.setDependenciaBean(this);

		return paciente;
	}

	public Pacientes removePaciente(Pacientes paciente) {
		getPacientes().remove(paciente);
		paciente.setDependenciaBean(null);

		return paciente;
	}

}