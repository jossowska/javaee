package com.jossowska.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add")
public class AddComics extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Add new comics here!</h2>" +
				"				\"<form action='all-comics +\n" + 
				"				\"Title: <input type='text' name='title'' /> <br />\" +\n" + 
				"				\"Price: <input type='text' name='price' /> <br />\" +\n" + 
				"				\"Date of release: <input type='text' name='dateOfRelease' /> <br />\" +\n" + 
				"				\"Is this a popular comics?: <select name='isPopular'>\" +\n" + 
				"				\"<option value='true'>Yes</option>\" +\n" + 
				"				\"<option value='false'>No</option>\" +\n" +
				"				\"</select><br />\" +\n" + 
				"				\"<input type='submit' value=' Add comics' />\" +\n" + 
				"				\"</form>" + 
				"</body></html>");
		
		out.close();
	}
}
