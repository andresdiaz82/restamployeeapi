package com.sacti.rimla.medic.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sacti.rimla.medic.entities.Domicilio;
import com.sacti.rimla.medic.entities.Familiares;
import com.sacti.rimla.medic.entities.MainEntity;
import com.sacti.rimla.medic.entities.Pacientes;

public class PacienteDTO implements MainDTO {

	private Integer idPaciente;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String curp;
	private String fotografia;
	private byte[] huellaDigital;
	private String nsp;
	private String nss;
	private Integer dependencia;
	private Integer direccion;
	private DomicilioDTO domicilio;
	private List<FamiliaresDTO> familiares;
	
	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
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

	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getFotografia() {
		return fotografia;
	}
	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public byte[] getHuellaDigital() {
		return huellaDigital;
	}
	public void setHuellaDigital(byte[] huellaDigital) {
		this.huellaDigital = huellaDigital;
	}

	public String getNsp() {
		return nsp;
	}
	public void setNsp(String nsp) {
		this.nsp = nsp;
	}

	public String getNss() {
		return nss;
	}
	public void setNss(String nss) {
		this.nss = nss;
	}

	public Integer getDependencia() {
		return dependencia;
	}
	public void setDependencia(Integer dependencia) {
		this.dependencia = dependencia;
	}

	public Integer getDireccion() {
		return direccion;
	}
	public void setDireccion(Integer direccion) {
		this.direccion = direccion;
	}

	public DomicilioDTO getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}

	public List<FamiliaresDTO> getFamiliares() {
		return familiares;
	}
	public void setFamiliares(List<FamiliaresDTO> familiares) {
		this.familiares = familiares;
	}

	@Override
	public MainEntity toEntity() {
		// TODO Auto-generated method stub
		Pacientes paciente = new Pacientes();
		if(this.getIdPaciente() != null) {
			paciente.setIdpaciente(this.getIdPaciente());
		}
		if(StringUtils.isNotBlank(this.getNombre())) {
			paciente.setNombre(this.getNombre());
		}
		if(StringUtils.isNotBlank(this.getApellidoPaterno())) {
			paciente.setApellidoPaterno(this.getApellidoPaterno());
		}
		if(StringUtils.isNotBlank(this.getApellidoMaterno())) {
			paciente.setApellidoMaterno(this.getApellidoMaterno());
		}
		if(StringUtils.isNotBlank(this.getCurp())) {
			paciente.setCurp(this.getCurp());
		}
		if(StringUtils.isNotBlank(this.getFotografia())) {
			paciente.setFotografia(this.getFotografia());
		}
		if(this.getHuellaDigital() != null) {
			paciente.setHuellaDigital(this.getHuellaDigital());
		}
		if(StringUtils.isNotBlank(this.getNsp())) {
			paciente.setNsp(this.getNsp());
		}
		if(StringUtils.isNotBlank(this.getNss())) {
			paciente.setNss(this.getNss());
		}
		if(this.getDependencia() != null) {
			paciente.setDependenciaId(this.getDependencia());
		}
		if(this.getDireccion() != null) {
			paciente.setDireccionId(this.getDireccion());
		}
		if(this.getDomicilio() != null) {
			Domicilio domicilio = (Domicilio) this.getDomicilio().toEntity();
			//paciente.setDomicilio(domicilio);
		}
		if(this.getFamiliares() != null && this.getFamiliares().size() > 0) {
			List<FamiliaresDTO> familiaresDTOList = this.getFamiliares();
			List<Familiares> familiares = new ArrayList<Familiares>();
			for(FamiliaresDTO familiar:familiaresDTOList) {
				familiares.add((Familiares) familiar.toEntity());
			}
			//paciente.setFamiliares(familiares);
		}
		return paciente;
	}

}
