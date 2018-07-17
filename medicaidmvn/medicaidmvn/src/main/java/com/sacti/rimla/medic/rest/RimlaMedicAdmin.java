package com.sacti.rimla.medic.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.sacti.rimla.medic.dto.DependenciaDTO;
import com.sacti.rimla.medic.service.DependenciaService;

@Controller
@Path("/admin")
public class RimlaMedicAdmin {

	@Autowired
	DependenciaService dependenciaService;
	
	private static final Logger logger = Logger.getLogger(RimlaMedicAdmin.class);
	
	@GET
	@Path("/dependencias")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultaDependencias() {
		logger.info("Recibido request para consulta de dependencias");
		try{
			List<DependenciaDTO> listaDependencias = dependenciaService.consultaDependencias();
			logger.info(listaDependencias.size()+" Dependencias encontradas");
			Gson gson = new Gson();
			String dependenciasJSON = gson.toJson(listaDependencias);
			logger.info("Enviando response para consulta de dependencias");
			return Response.status(200).entity(dependenciasJSON).build();
		}catch(Exception e){
			logger.info("Error en la consulta de dependencias");
			return Response.status(500).entity("Error interno del servidor, por favor contacta al administrador del sistema").type(MediaType.APPLICATION_JSON).build();
		}
		
	}
	
	@GET
	@Path("/dependencias/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultaDependenciaId(@PathParam("id") int id) {
		logger.info("Recibido request para consulta de dependencia por id");
		try {
			DependenciaDTO dependenciaDTO = dependenciaService.consultaDependenciaId(id);
			logger.info("Dependencia encontrada con id: "+id);
			Gson gson = new Gson();
			String dependenciaDTOJSON = gson.toJson(dependenciaDTO);
			logger.info("Enviando response para consulta de dependencias");
			return Response.status(200).entity(dependenciaDTOJSON).build();
		}catch(Exception e) {
			logger.info("Error en la consulta de dependencia");
			return Response.status(500).entity("Error interno del servidor, por favor contacta al administrador del sistema").type(MediaType.APPLICATION_JSON).build();
		}
	}
	
	@POST
	@Path("/dependencias/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertaDependencia(DependenciaDTO dependenciaDTO){
		try{
			logger.info("Recibido request para alta de dependencias");
			dependenciaService.insertaDependencia(dependenciaDTO);
			logger.info("Dependencia creada exitosamente");
			return Response.status(200).entity("Dependencia creada exitosamente").build();
		}catch(Exception e){
			logger.info("Error en alta de dependencia");
			return Response.status(500).entity("Error interno del servidor, por favor contacta al administrador del sistema").type(MediaType.APPLICATION_JSON).build();
		}
	}
	
}
