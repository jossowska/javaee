package com.example.restejbjpa.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restejbjpa.domain.ComicBook;
import com.example.restejbjpa.service.ComicBookManager;

@Path("comicBook")
public class ComicBookRestService {
	
	@EJB
	ComicBookManager cbm;
	
	@GET
	@Path("/{id")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicBook getComicBook(@PathParam("id") Long id) {
		
		ComicBook retrieved = cbm.getComicBook(id);
		
		return retrieved;
	}
	
	@DELETE
	public Response deleteAll() {
		cbm.deleteAllComics();
		return Response.status(Response.Status.OK).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ComicBook> getComics(){
		return cbm.getAllComics();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addComicBook(ComicBook comicBook) {
		cbm.addComicBook(comicBook);
		
		return Response.status(201).entity("ComicBoo").build();	
	}
	
	@DELETE
	@Path("/{comicBookId")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteComicBook(@PathParam("comicBookId") Integer id) {
		return Response.status(200).build();
	}
}
