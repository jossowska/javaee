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


import com.example.restejbjpa.domain.Creator;
import com.example.restejbjpa.service.ComicBookManager;

@Path("creator")
public class CreatorRestService {

	@EJB
	ComicBookManager cbm;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Creator getCreator(@PathParam("id") Long id) {
		Creator retrieved = cbm.getCreator(id);
		
		return retrieved;
	}
	
	@GET
	@Path("/mostPowerfull")
	@Produces(MediaType.APPLICATION_JSON)
	public Creator getMostPowerull(){
		Creator retrieved = cbm.findMostPowerfullCreator();
		return retrieved;
	}
	
	@GET
	@Path("/manyPublishingHouses")
	@Produces(MediaType.APPLICATION_JSON)
	public Creator getManyToys(){
		Creator retrieved = cbm.findManyPublishingHouses();
		return retrieved;
	}
	
	@GET
	@Path("/manyPublishingHouses/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Creator> getManyToys(@PathParam("id") Long id){
		List<Creator> retrieved = cbm.findManyPublishingHouses(id.intValue());
		return retrieved;
	}

	
	@DELETE
	public Response deleteAllCreators() {
		cbm.deleteAllCreators();
		return Response.status(Response.Status.OK).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Creator> getCreators() {
		return cbm.getAllCreators();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCreator(Creator creator) {
		cbm.addCreator(creator);

		return Response.status(201).entity("Owner").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCreators(List<Creator> list) {
		for(Creator c : list)
			cbm.addCreator(c);

		return Response.status(201).entity("Creator").build();
	}
	
}
