package com.example.servletjspdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	 res.setContentType("text/html");
	 
	 PrintWriter out = res.getWriter();
     Date date = new Date();
	 out.println("<form method=\"get\" action=\"/servletjspdemo/about\">\r\n" + 
	 		"    <button type=\"submit\">About</button>\r\n" + 
	 		"</form>");
	 out.println("<form method=\"get\" action=\"/servletjspdemo/date\">\r\n" + 
		 		"    <button type=\"submit\">Date</button>\r\n" + 
		 		"</form>");
}
	
}