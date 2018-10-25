package com.example.servletjspdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/about")
public class AboutServlet extends HttpServlet {

 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	 res.setContentType("text/html");
	 
	 PrintWriter out = res.getWriter();

	 out.println("<html><body class='text-center'><h2>Amy Winehouse</h2>" +
				"<p>Angielska piosenkarka soul,jazz i RB. </br>Rowniez kompozytorka i autorka tekstow piosenek.</p>" +
			
				"<ul>" +
				"<li>3 plyty</li>" +
				"<li>22 nagrody</li>" +
				"<li>zmarla 23.10.2011r</li>" +
				"</ul>" +
				"</body></html>");
}
	
}