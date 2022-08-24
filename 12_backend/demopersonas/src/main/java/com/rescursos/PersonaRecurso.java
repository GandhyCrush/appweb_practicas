package com.rescursos;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Persona;

@Path("/personas")
public class PersonaRecurso {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> getPersonas(){
		return DAOFactory.getFactory().getPersonaDAO().get();
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Persona getById(@PathParam("id") int idPersona) {
		return DAOFactory.getFactory().getPersonaDAO().getById(idPersona);

	}
	
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean guardarPersona(Persona p) {
		DAOFactory.getFactory().getPersonaDAO().create(p);
		return true;
	}
	
	@Path("/update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean actualizarPersona(Persona p) {
		DAOFactory.getFactory().getPersonaDAO().update(p);
		return true;
	}
	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public boolean eliminarPersona(@PathParam("id") int idPersona) {
		DAOFactory.getFactory().getPersonaDAO().deleteByID(idPersona);
		return true;
	}
	
}
