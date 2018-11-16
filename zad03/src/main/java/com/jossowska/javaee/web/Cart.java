package com.jossowska.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jossowska.javaee.domain.ComicBook;
import com.jossowska.javaee.service.StorageService;

public class Cart extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StorageService s = (StorageService) getServletContext().getAttribute("storage_service");
		
		List<ComicBook> allComics = s.getCart();

		out.append("<html><body>");

		for (ComicBook comic: allComics) {
			out.append("<p>Id: " + comic.getId() + "</p>");
			out.append("<p>Title: " + comic.getTitle() + "</p>");
			out.append("<p>Date of release: " + comic.getDateOfRelease() + "</p>");
			out.append("<p>Price: " + comic.getPrice() + "</p>");
			out.append("<p>Is Popular: " + comic.getIsPopular() + "</p></br>");
		}

		out.append("</br><li><a href='menu'>Menu</a></li>");
		out.append("</body></html>");
		out.close();
	}
	
	@Override
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}
}
