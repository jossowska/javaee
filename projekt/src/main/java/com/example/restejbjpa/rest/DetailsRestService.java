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

import com.example.restejbjpa.domain.Details;
import com.example.restejbjpa.service.ComicBookManager;

@Path("det")
public class DetailsRestService {
	
	@EJB
	ComicBookManager cbm;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Details getDetails(@PathParam("id") Long id) {
		Details retrieved = cbm.getDetails(id);

				return retrieved;
	}
	
	@DELETE
	public Response deletAllTails(){
		cbm.deleteAllDetails();
		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Details> getDetails() {
		return cbm.getAllDetails();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDetails(Details details) {
		cbm.addDetails(details);

		return Response.status(201).entity("Details").build();
	}
}
