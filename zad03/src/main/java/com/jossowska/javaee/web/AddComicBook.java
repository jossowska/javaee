package com.jossowska.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jossowska.javaee.service.StorageService;

@WebServlet(urlPatterns = "/add")
public class AddComicBook extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		StorageService s = (StorageService) getServletContext().getAttribute("storage_service");
		
		int size = s.getAllComics().size() +1;
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Add new comic book here!</h2>" +
				"<form action ='data-comicbook'>" +
				"ID: <input type='text' name='id' value="+size+" /> <br />" +
				"Title: <input type='text' name='title' /> <br />" +
				"DateOfRelease: <input type='date' name='dateOfRelease' /> <br />" +
				"Price: <input type='text' name='price' /> <br />" +
				"Is this a popular comic book?: <select name='isPopular'>" +
				"<option value='true'>Yes</option>" +
				"<option value='false'>No</option>" +
				"</select><br />" +
				"<input type='submit' name='add' value=' Add a new comic book! ' /></form>" +
				"</body></html>");
		
		out.close();
	}
}
