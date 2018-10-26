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
    out.println("<html><body><h1>Comics rules! </h1> <br>" +
            "Menu: <br>" +
            "<ul>" +
            "<li><a href='add'>Add new Comic Book</a></li>" +
            "<li><a href='allcomics'>View all cscomi</a></li>" +
            "</ul>" +
            "</body></html>");
    out.close();
	
	}
}
