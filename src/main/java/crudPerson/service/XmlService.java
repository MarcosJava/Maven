package crudPerson.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import crudPerson.dao.PersonDao;
import crudPerson.model.Person;

@Stateless
@Path("/xml")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class XmlService {
	
	@EJB
	PersonDao personDao;
	
	/*
	 * Para retornar o Person em XML é necessario colocar a anotação no model
	 * @XmlRootElement
	 */
	
	@GET
	@Path("/{id}")
	public Person personXml(@PathParam("id") Long id){
		return this.personDao.findById(id);
	}
	

}
