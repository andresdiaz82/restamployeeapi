package com.sacti.rimla.medic.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sacti.rimla.medic.dto.MainDTO;


/**
 * The persistent class for the pacientes database table.
 * 
 */
@Entity
@Table(name="pacientes")
@NamedQuery(name="Pacientes.findAll", query="SELECT p FROM Pacientes p")
public class Pacientes implements Serializable, MainEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idpaciente")
	private int idPaciente;

	@Column(name="apellido_materno")
	private String apellidoMaterno;

	@Column(name="apellido_paterno")
	private String apellidoPaterno;

	@Column(name="curp")
	private String curp;

	@Column(name="fotografia")
	private String fotografia;

	@Lob
	@Column(name="huella_digital")
	private byte[] huellaDigital;

	@Column(name="nombre")
	private String nombre;

	@Column(name="nsp")
	private String nsp;

	@Column(name="nss")
	private String nss;

	@Column(name="dependencia")
	private int dependenciaId;
	
	@Column(name="direccion")
	private int direccionId;

	//bi-directional one-to-one association to Domicilio
	//@OneToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="iddomicilio")
	//@JoinColumns({
	//	@JoinColumn(name="direccion", referencedColumnName="iddomicilio")
	//	//@JoinColumn(name="dependencia", referencedColumnName="dependencia", insertable=false, updatable=false)
	//})
	//private Domicilio domicilio;

	//@OneToMany(fetch=FetchType.LAZY)
	//@JoinColumns({
	//	@JoinColumn(name="id_paciente", referencedColumnName="idpaciente", insertable=false, updatable=false),
	//	@JoinColumn(name="dependencia", referencedColumnName="dependencia", insertable=false, updatable=false)
	//})
	//private List<Familiares> familiares;
	
	public Pacientes() {
	}

	public int getIdpaciente() {
		return this.idPaciente;
	}

	public void setIdpaciente(int idpaciente) {
		this.idPaciente = idpaciente;
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

	//public Domicilio getDomicilio() {
	//	return this.domicilio;
	//}

	//public void setDomicilio(Domicilio domicilio) {
	//	this.domicilio = domicilio;
	//}
	
	public int getDependenciaId() {
		return dependenciaId;
	}

	public void setDependenciaId(int dependenciaId) {
		this.dependenciaId = dependenciaId;
	}
	
	public int getDireccionId() {
		return direccionId;
	}

	public void setDireccionId(int direccionId) {
		this.direccionId = direccionId;
	}

	/*public List<Familiares> getFamiliares() {
		return this.familiares;
	}
	
	public void setFamiliares(List<Familiares> familiares) {
		this.familiares = familiares;
	}*/
	
	@Override
	public MainDTO toDTO() {
		// TODO Auto-generated method stub
		return null;
	}

}