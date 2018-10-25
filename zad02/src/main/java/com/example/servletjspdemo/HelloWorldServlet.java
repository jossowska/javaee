package com.example.servletjspdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 String hello = "hello";
	 res.setContentType("text/html");
	 
	 PrintWriter out = res.getWriter();
	 out.println("<html><body><h1>My first servlet</h1></body></html>");
	//super.doGet(req, res);
}
	
}