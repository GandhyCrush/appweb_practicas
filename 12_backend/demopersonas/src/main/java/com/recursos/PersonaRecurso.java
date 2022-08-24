package com.recursos;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Persona;


@Path("/personas")
public class PersonaRecurso {
	/*
	 * Sin parámetros http://localhost:8080/rest_ejercicio2_formato/cambio/personas
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonas() {
		
		List<Persona> personas = DAOFactory.getFactory().getPersonaDAO().get();;
		return Response.ok(personas).build();
	}

	/*
	 * Parámetro enviado en URL y capturado con @PathParam
	 * http://localhost:8080/rest_ejercicio2_formato/cambio/personas/1
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getPersonaByPathParam(@PathParam("id") int id) {
		Persona p = DAOFactory.getFactory().getPersonaDAO().getById(id);
		if (p != null) {
			return Response.ok(p).build();
		}
		return Response.ok(Response.Status.NOT_FOUND).build();
	}

	/*
	 * Parámetro enviado en URL (?param = 1) y capturado con @QueryParam
	 * http://localhost:8080/rest_ejercicio2_formato/cambio/personas?id=1
	 */
	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_XML)
	public Response getPersonaByQueryParam(@QueryParam("id") int id) {
		Persona p = DAOFactory.getFactory().getPersonaDAO().getById(id);
		if (p != null) {
			return Response.ok(p).build();
		}
		return Response.ok(Response.Status.NOT_FOUND).build();
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean guardarUsuario(Persona p) {
		boolean bandera = true;
		try {
			DAOFactory.getFactory().getPersonaDAO().create(p);
			System.out.println("Se ha recibido la persona :" + p);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			bandera = false;
		}

		return bandera;
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean actualizarUsuario(Persona p) {
		try{
			DAOFactory.getFactory().getPersonaDAO().update(p);
			System.out.println("ACTUALIZACION: persona : " + p);
				
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean elimminarUsuario(@PathParam("id")int id) {
		try{
			DAOFactory.getFactory().getPersonaDAO().deleteByID(id);
			System.out.println("ELIMINACION: persona con id: " + id);
				
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
	}
	
	

}
