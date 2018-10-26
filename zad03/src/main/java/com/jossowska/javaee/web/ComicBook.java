package com.jossowska.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jossowska.javaee.domain.Comics;
import com.jossowska.javaee.service.StorageService;

@WebServlet(urlPatterns = "/comics")
public class ComicBook extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");

		List<Comics> allComics = ss.getAllComics();

		out.append("<html><body><h2>All Comics:</h2>");

		for (Comics comics: allComics) {
			out.append("<p>Title: " + comics.getTitle() + "</p>");
			out.append("<p>Price: " + comics.getPrice() + "</p>");
			out.append("<p>Date of release: " + comics.getDateOfRelease() + "</p>");
			out.append("<p>Is this a popular comics?: " + comics.getIsPopular() + "</p><br>");
		}

		out.append("</body></html>");
		out.close();
	}

	@Override
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}
}


