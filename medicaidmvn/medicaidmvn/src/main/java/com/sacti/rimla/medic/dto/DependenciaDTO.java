package com.sacti.rimla.medic.dto;

import com.sacti.rimla.medic.entities.Dependencia;
import com.sacti.rimla.medic.entities.MainEntity;

public class DependenciaDTO implements MainDTO{

	private Integer id;
	private String nombre_dependencia;
	private String responsable_dependencia;
	private String calle;
	private Integer numero;
	private Integer interior;
	private String colonia;
	private Integer cp;
	private String ciudad;
	private String estado;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	@Override
	public String toString() {
		return "id:"+this.id+", dependencia:"+this.nombre_dependencia+", responsable:"+this.responsable_dependencia
				+", domicilio:"+this.calle+" "+this.numero+" "+this.interior+" "+this.colonia
				+" "+this.cp+" "+this.ciudad+" "+this.estado;
	}

	public MainEntity toEntity() {
		// TODO Auto-generated method stub
		Dependencia dependencia = new Dependencia();
		if(this.id != null && this.id != 0) {
			dependencia.setId(this.id);
		}
		if(this.nombre_dependencia != null && this.nombre_dependencia != "") {
			dependencia.setNombre_dependencia(this.nombre_dependencia);
		}
		if(this.responsable_dependencia != null && this.responsable_dependencia != "") {
			dependencia.setResponsable_dependencia(this.responsable_dependencia);
		}
		if(this.calle != null && this.calle != "") {
			dependencia.setCalle(this.calle);
		}
		if(this.numero != null && this.numero != 0) {
			dependencia.setNumero(this.numero);
		}
		if(this.interior != null && this.interior != 0) {
			dependencia.setInterior(this.interior);
		}
		if(this.colonia != null && this.colonia != "") {
			dependencia.setColonia(this.colonia);
		}
		if(this.cp != null && this.cp != 0) {
			dependencia.setCp(this.cp);
		}
		if(this.ciudad != null && this.ciudad != "") {
			dependencia.setCiudad(this.ciudad);
		}
		if(this.estado != null && this.estado != "") {
			dependencia.setEstado(this.estado);
		}
		return dependencia;
	}
	
}
