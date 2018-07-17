package com.oracle.employee.rest;

import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.oracle.employee.service.EmployeeService;
import com.oracle.employee.utils.HeaderValidator;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;


@Controller
@Path("/emps")
public class EmployeeController {

	
	@Autowired
	EmployeeService employeeService;
	
	@GET
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response queryEmployeeById(@PathParam("id") int id) {
		
		try {
			String employeeString = employeeService.findEmployeeById(id);
			return Response.status(200).entity(employeeString).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Internal server error, please try again later").type(MediaType.APPLICATION_JSON).build();
		}
		
	}
	
	@POST
	@Path("/employee/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(String employeeData) {
		try {
			employeeService.addEmployee(employeeData);
			return Response.status(200).entity("Employee added succesfuly").type(MediaType.APPLICATION_JSON).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Internal server error, please try again later").type(MediaType.APPLICATION_JSON).build();
		}
	}
	
	/*This should be actually a PUT call since it is only an update but for show case all HTTP verbs i used DELETE*/
	@DELETE
	@Path("/employee/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("id") int id, @HeaderParam("authorization") String auth) {
		//Basic header validation with base64 encoding decodin, the string format is:
		//word Basic <encoded string> mind the space between basic and the encoded string
		//credentials to be validated are us3r p4ssw0rd concatenated before encoding as:
		// us3r:p4ssw0rd
		if(!HeaderValidator.isAuthorized(auth)) {
			return Response.status(401).entity("User not authorized").type(MediaType.APPLICATION_JSON).build();
		}
		try {
			employeeService.removeEmployee(id);
			return Response.status(200).entity("Employee succesfuly deactivated").type(MediaType.APPLICATION_JSON).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Internal server error, please try again later").type(MediaType.APPLICATION_JSON).build();
		}
	}
	
	@PUT
	@Path("/employee/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(String employeeData) {
		try {
			employeeService.updateEmployee(employeeData);
			return Response.status(200).entity("Employee succesfuly updated").type(MediaType.APPLICATION_JSON).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Internal server error, please try again later").type(MediaType.APPLICATION_JSON).build();
		}
	}
	
	@GET
	@Path("/employee")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findAllActive() {
		try {
			String employeesString = employeeService.findActive();
			return Response.status(200).entity(employeesString).type(MediaType.APPLICATION_JSON).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Internal server error, please try again later").type(MediaType.APPLICATION_JSON).build();
		}
	}
	
	@POST
	@Path("/employee/batch/csv")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public ResponseEntity<?> processCsv(
			@FormDataParam("file") InputStream uploadInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail){
		Executors.newScheduledThreadPool(1).schedule(
				() -> employeeService.processEmployeesCsv(uploadInputStream),10,TimeUnit.SECONDS);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@POST
	@Path("/employee/batch/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<?> processJson(String uploadData){
		Executors.newScheduledThreadPool(1).schedule(
				() -> employeeService.processEmployeesJson(uploadData),10,TimeUnit.SECONDS);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
