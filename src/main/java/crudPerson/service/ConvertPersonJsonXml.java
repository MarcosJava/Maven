package crudPerson.service;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import crudPerson.model.Person;

@Stateless
@Path("/convert")
public class ConvertPersonJsonXml {

	@POST
	@Path("/json/xml")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Person transformToXml(Person p){
		return p;
	}
	
	
	@POST
	@Path("/xml/json")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Person transformToJson(Person p){
		return p;
	}
	
}
