package crudPerson.service;

import java.io.File;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Stateless
@Path("/download")
public class DownloadService {

	/*
	 * Fazendo Download de texto
	 * Produces fica como (text/plain)
	 */
	
	@GET
	@Path("/text")
	@Produces("text/plain")
	public Response text(){
		
		File file = new File("texto.txt");
		
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", 
				"attachment; filename=\"texto.txt\" ");
		return response.build();
	}
	
	/*
	 * Enviando uma Imagem do tipo PNG 
	 * Poderiamos colocar o asteristico (*) para ser o coringa 
	 */
	
	@GET
	@Path("/imagem")
	@Produces("imagem/png")
	public Response imagem(){
		
		File file = new File("mrksFelipe.png");
		
		ResponseBuilder response = Response.ok((Object) file );
		response.header("Content-Disposition", 
				" attachment; filename= \"mrksFelipe.png\" ");
		return response.build();
		
	}
}
