package crudPerson.service;

import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/person")
public class PersonService {
	
	/*
	 * Enviar via XML
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String teste(){
		return "testando";
	}
	
	/*
	 * Recebe dois parametros e envia um retorno
	 * pela url /Person/Feliz/Rest 
	 * receberá Feliz == Rest
	 */
	@GET
	@Path("/{M1}/{M2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String pathParamTest(@PathParam("M1")String m1, 
			@PathParam("M2") String m2 ){
		return m1+" == "+m2;
	}
	
	
	/*
	 * Esse retorna em JSON 
	 * igual ao de cima porem recebe os parametros assim
	 * service/Person;M1=vai;M2=go
	 * o retorno seria vai == go
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String matrixParamTest(
			@MatrixParam("M1") String m1,
			@MatrixParam("M2") String m2){
		return m1 + " == " + m2;
	}
	
	/*
	 *  query para é assim services/person?M1=moeda&M2=moeda2
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String queryParamTest(
			@QueryParam("M1") String m1,
			@QueryParam("M2") String m2){
		return m1 + " == " + m2;
	}
	
	
	/*
	 *  form é com parametros de formulario html que utiliza o metodo POST
	 *  podemos recuperar com @FormParam
	 *  
	 *  <form action="http://meuprojeto/person" method="POST">
	 *  String1: <input type="text" name="M1" >
	 *  String2: <input type="text" name="M2">
	 *  </form>
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String formParamTest(
			@FormParam("M1") String m1,
			@FormParam("M2") String m2){
		return m1 + " == " + m2;
	}
	
	
	/*
	 *  ficaria assim services/person/3
	 *  retornaria 4 Somamos mais 1
	 */
	
	@GET
	@Path("/{num}")
	@Produces(MediaType.TEXT_PLAIN)
	public String uriMatching(@PathParam("num") String num){
		return ((num + 1) + " Somamos mais 1");
	}
	
}
