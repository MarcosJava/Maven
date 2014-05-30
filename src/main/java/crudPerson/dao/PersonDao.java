package crudPerson.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import crudPerson.model.Person;

@Stateless
public class PersonDao {

	@PersistenceContext(unitName="myMaven")
	private EntityManager em;
	
	public void save(Person person){
		this.em.persist(person);
	}
	
	public List<Person> findAll(){

		String q = "select p from Person p";
		TypedQuery<Person> query = em.createQuery(q, Person.class);
		return query.getResultList();
	}
	public Person findById(Long id){

		String q = "select p from Person p where p.id=:id";
		TypedQuery<Person> query = em.createQuery(q, Person.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
}
