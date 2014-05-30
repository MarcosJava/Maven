package crudPerson.service;

import java.net.URI;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import crudPerson.dao.PersonDao;
import crudPerson.model.Person;

@Stateless
@Path("/response")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class ResponseService {

	@EJB
	private PersonDao personDao;
	
	/*
	 * Caso não tiver o ID,
	 * ele retorna 404 - Not Found
	 */
	
	@GET
	@Path("/{id}")
	public Response findByID(@PathParam("id") long id){
		Person p = personDao.findById(id);
		
		if(p != null){
			return Response.ok(p).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	
	@POST
	public Response create(@Context UriInfo uriInfo, Person person){
		this.personDao.save(person);
		
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		URI location = uriBuilder.path("/{id}").build(person.getId());
		
		return Response.created(location).build();
	}
	
	@POST
	@Path("/{person}")
	public String createPerson(@PathParam("person")Person person){
		this.personDao.save(person);
		return "sucesso";
	}
	
}
