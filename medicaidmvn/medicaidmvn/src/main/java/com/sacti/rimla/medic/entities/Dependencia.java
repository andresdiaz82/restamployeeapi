package com.sacti.rimla.medic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.sacti.rimla.medic.dto.DependenciaDTO;
import com.sacti.rimla.medic.dto.MainDTO;

@Entity
@Table(name="dependencia")
@NamedQuery(name="Dependencia.findAll", query="SELECT d FROM Dependencia d")
public class Dependencia implements MainEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre", nullable=false)
	private String nombre_dependencia;
	
	@Column(name="responsable", nullable=false)
	private String responsable_dependencia;
	
	@Column(name="calle", nullable=false)
	private String calle;
	
	@Column(name="numero_ext", nullable=false)
	private int numero;
	
	@Column(name="numero_int")
	private int interior;
	
	@Column(name="colonia", nullable=false)
	private String colonia;
	
	@Column(name="codigopostal", nullable=false)
	private int cp;
	
	@Column(name="ciudad", nullable=false)
	private String ciudad;
	
	@Column(name="estado", nullable=false)
	private String estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_dependencia() {
		return nombre_dependencia;
	}

	public void setNombre_dependencia(String nombre_dependencia) {
		this.nombre_dependencia = nombre_dependencia;
	}

	public String getResponsable_dependencia() {
		return responsable_dependencia;
	}

	public void setResponsable_dependencia(String responsable_dependencia) {
		this.responsable_dependencia = responsable_dependencia;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getInterior() {
		return interior;
	}

	public void setInterior(int interior) {
		this.interior = interior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public MainDTO toDTO() {
		// TODO Auto-generated method stub
		DependenciaDTO dependenciaDTO = new DependenciaDTO();
		if(this.id != 0) {
			dependenciaDTO.setId(this.id);
		}
		if(this.nombre_dependencia != null && this.nombre_dependencia != "") {
			dependenciaDTO.setNombre_dependencia(this.nombre_dependencia);
		}
		if(this.responsable_dependencia != null && this.responsable_dependencia != "") {
			dependenciaDTO.setResponsable_dependencia(this.responsable_dependencia);
		}
		if(this.calle != null && this.calle != "") {
			dependenciaDTO.setCalle(this.calle);
		}
		if(this.numero != 0) {
			dependenciaDTO.setNumero(this.numero);
		}
		if(this.interior != 0) {
			dependenciaDTO.setInterior(this.interior);
		}
		if(this.colonia != null && this.colonia != "") {
			dependenciaDTO.setColonia(this.colonia);
		}
		if(this.cp != 0) {
			dependenciaDTO.setCp(this.cp);
		}
		if(this.ciudad != null && this.ciudad != "") {
			dependenciaDTO.setCiudad(this.ciudad);
		}
		if(this.estado != null && this.estado != "") {
			dependenciaDTO.setEstado(this.estado);
		}
		return dependenciaDTO;
	}
	
	
}
