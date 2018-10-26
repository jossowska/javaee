package com.jossowska.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class Menu extends HttpServlet {

@Override 
protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
	response.setContentType("text/html");
	
	PrintWriter out = response.getWriter();
	out.println("<html><body><h1></h1></body></html>");
	
	out.close();
	}
}
