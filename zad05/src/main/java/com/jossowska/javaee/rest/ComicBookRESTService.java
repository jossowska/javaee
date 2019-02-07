package com.jossowska.javaee.rest;


import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.jossowska.javaee.domain.ComicBook;
import com.jossowska.javaee.service.ComicBookManager;

public class ComicBookRESTService {

	@Inject
	private ComicBookManager cm;
	
	@GET
	@Path("/{comicBookId}")

	public ComicBook getComicBook(@PathParam("comcicBookId") Integer id) {
		ComicBook c = cm.getComicBook(id);
		return c;
	}
	
}
