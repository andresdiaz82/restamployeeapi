package com.sacti.rimla.medic.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.sacti.rimla.medic.dto.DependenciaDTO;
import com.sacti.rimla.medic.service.DependenciaService;

@Path("/admin")
public class RimlaMedicAdmin {

	@Autowired
	DependenciaService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultaDependencias() {
		List<DependenciaDTO> listaDependencias = service.consultaDependencias();
		Gson gson = new Gson();
		String dependenciasJSON = gson.toJson(listaDependencias);
		return Response.status(200).entity(dependenciasJSON).build();
	}
	
}
