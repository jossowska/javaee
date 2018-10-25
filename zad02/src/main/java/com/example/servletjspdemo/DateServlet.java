package com.example.servletjspdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/date")
public class DateServlet extends HttpServlet {

 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	 res.setContentType("text/html");
	 
	 PrintWriter out = res.getWriter();
     Date date = new Date();
	 out.println("<html><body><h1>Aktualna Data: "+date+"</h1></body></html>");
}
	
}