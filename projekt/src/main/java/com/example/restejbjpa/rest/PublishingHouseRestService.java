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

import com.example.restejbjpa.domain.PublishingHouse;
import com.example.restejbjpa.service.ComicBookManager;

@Path("pub")
public class PublishingHouseRestService {
	
	@EJB
	ComicBookManager cbm;
	

	@GET
	@Path("/{id}")
	
	@Produces(MediaType.APPLICATION_JSON)
	public PublishingHouse getPublishingHouse(@PathParam("id") Long id){
		PublishingHouse retrieved = cbm.getPublishingHouse(id);
		
		return retrieved;
	}
	
	@DELETE
	public Response deleteAllPublishingHouses() {
		cbm.deleteAllPublishingHouses();
		return Response.status(Response.Status.OK).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PublishingHouse> getPublishingHouses(){
		return cbm.getAllPublishingHouses();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPublishingHouse(PublishingHouse publishingHouse) {
		cbm.addPublishingHouse(publishingHouse);
		
		return Response.status(201).entity("PublishingHouse").build();
	}
}
