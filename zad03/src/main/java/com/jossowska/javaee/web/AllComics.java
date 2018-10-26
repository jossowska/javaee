package com.jossowska.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jossowska.javaee.service.StorageService;
import com.jossowska.javaee.domain.Comics;

@WebServlet(urlPatterns = "/allcomics")
public class AllComics extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");


		String title = request.getParameter("title");
		Date dateOfRelease = null;
		try {
			dateOfRelease = formatter.parse(request.getParameter("dateOfRelease"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double price = Double.parseDouble(request.getParameter("price"));
		boolean isPopular = Boolean.parseBoolean(request.getParameter("isPopular"));

		StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");


		Comics newComics= new Comics(title, dateOfRelease, price, isPopular);

		ss.add(newComics);

		List<Comics> allComics = ss.getAllComics();

		out.append("<html><body><h2>All comics in store:</h2>");

		for (Comics comics: allComics) {
			out.append("<p>Title: " + comics.getTitle() + "</p>");
			out.append("<p>Price: " + comics.getPrice() + "</p>");
			out.append("<p>Date of release: " + comics.getDateOfRelease() + "</p>");
			out.append("<p>Is universal: " + comics.getIsPopular() + "</p><br>");
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
