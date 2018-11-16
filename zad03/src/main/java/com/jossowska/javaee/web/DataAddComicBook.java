package com.jossowska.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jossowska.javaee.domain.ComicBook;
import com.jossowska.javaee.service.StorageService;

@WebServlet(urlPatterns = "/data-comicbook")
public class DataAddComicBook extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StorageService s = (StorageService) getServletContext().getAttribute("storage_service");
		
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		
		long id = Long.parseLong(request.getParameter("id"));
		String title = request.getParameter("title");
		Date dateOfRelease = null;
		try {
			dateOfRelease = formatter.parse(request.getParameter("dateOfRelease"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double price = Double.parseDouble(request.getParameter("price"));
		boolean isPopular = Boolean.parseBoolean(request.getParameter("isPopular"));

		ComicBook newComicBook = new ComicBook(id, title, dateOfRelease, price, isPopular);

		s.addToDatabase(newComicBook);
		response.sendRedirect("all-comics");
		out.close();
	}
	
	@Override
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}
}
