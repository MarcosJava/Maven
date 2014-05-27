package crudPerson.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import crudPerson.dao.PersonDao;
import crudPerson.model.Person;

@ManagedBean
public class PersonMB {

	private Person person;
	
	@EJB
	private PersonDao personDao;
	
	public PersonMB() {
		person = new Person();
	}
	
	public void save(){
		FacesContext fc = FacesContext.getCurrentInstance();
		personDao.save(person);
		fc.addMessage(null, new FacesMessage("Cadastrado com Sucesso"));
		person = new Person();
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getPersons(){
		return personDao.findAll();
	}
	
}
