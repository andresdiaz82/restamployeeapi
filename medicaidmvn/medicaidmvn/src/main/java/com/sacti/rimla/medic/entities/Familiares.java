package com.sacti.rimla.medic.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sacti.rimla.medic.dto.MainDTO;
import com.sacti.rimla.medic.dto.FamiliaresDTO;
import com.sacti.rimla.medic.dto.DomicilioDTO;

@Entity
@Table(name="familiares")
@NamedQuery(name="Familiares.findAll", query="SELECT f FROM Familiares f")
public class Familiares implements Serializable, MainEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_familiar")
	private int idFamiliar;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido_paterno")
	private String apellidoPaterno;
	
	@Column(name="apellido_materno")
	private String appelidoMaterno;
	
	@Column(name="direccion")
	private int direccion;
	
	@Column(name="id_paciente")
	private int idpaciente;
	
	@Column(name="dependencia")
	private int dependencia;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="direccion", referencedColumnName="iddomicilio", insertable=false, updatable=false),
		@JoinColumn(name="dependencia", referencedColumnName="dependencia", insertable=false, updatable=false)
	})
	private Domicilio domicilio;

	public int getIdFamiliar() {
		return idFamiliar;
	}

	public void setIdFamiliar(int idFamiliar) {
		this.idFamiliar = idFamiliar;
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

	public String getAppelidoMaterno() {
		return appelidoMaterno;
	}

	public void setAppelidoMaterno(String appelidoMaterno) {
		this.appelidoMaterno = appelidoMaterno;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public int getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}
	
	public int getDependencia() {
		return dependencia;
	}

	public void setDependencia(int dependencia) {
		this.dependencia = dependencia;
	}
	
	@Override
	public MainDTO toDTO() {
		// TODO Auto-generated method stub
		FamiliaresDTO familiaresDTO = new FamiliaresDTO();
		DomicilioDTO domicilioDTO = null;
		familiaresDTO.setIdfamiliar(this.getIdFamiliar());
		familiaresDTO.setNombre(this.getNombre());
		familiaresDTO.setApellidoPaterno(this.getApellidoPaterno());
		familiaresDTO.setApellidoMaterno(this.getAppelidoMaterno());
		familiaresDTO.setDireccion(this.getDireccion());
		familiaresDTO.setIdpaciente(this.getIdpaciente());
		familiaresDTO.setDependencia(this.getDependencia());
		domicilioDTO = (DomicilioDTO) this.getDomicilio().toDTO();
		familiaresDTO.setDomicilio(domicilioDTO);
		return familiaresDTO;
	}
}
