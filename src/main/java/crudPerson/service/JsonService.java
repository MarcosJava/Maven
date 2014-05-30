package crudPerson.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import crudPerson.dao.PersonDao;
import crudPerson.model.Person;

@Stateless
@Path("/json")
public class JsonService {

	@EJB
	PersonDao personDao;
	
	
	/*
	 * Para transformar o Person em JSON é necessario a anotacao na model
	 * @XmlRootElement
	 * 
	 */
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person personJson(@PathParam("id") Long id){
		
		return this.personDao.findById(id);
		
	}
	
	
}
