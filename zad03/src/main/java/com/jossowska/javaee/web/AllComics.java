package com.jossowska.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jossowska.javaee.service.StorageService;
import com.jossowska.javaee.domain.ComicBook;

@WebServlet(urlPatterns = "/allcomics")
public class AllComics extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		StorageService s = (StorageService) getServletContext().getAttribute("storage_service");
		
		List<ComicBook> allComics = s.getAllComics();
		
		out.append("<html><body><h2>All comics:</h2>");

		for (ComicBook comic: allComics) {
			out.append("<p>Id: " + comic.getId() + "</p>");
			out.append("<p>Title: " + comic.getTitle() + "</p>");
			out.append("<p>Date of release: " + comic.getDateOfRelease() + "</p>");
			out.append("<p>Price: " + comic.getPrice() + "</p>");
			out.append("<p>This is a popular comic book?: " + comic.getIsPopular() + "</p>");
			out.append("<form action='data-cart'><input type='hidden' name='add' value='" + comic.getId() +"' ><button type=submit>Add to cart</button></form>");
		}

		out.append( "</br><li><a href='menu'>Menu</a></li>");
		out.append("</body></html>");
		out.close();
}
		
	@Override
	public void init() throws ServletException {
		
		getServletContext().setAttribute("storage_service", new StorageService());

	}

}
