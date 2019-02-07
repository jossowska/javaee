package com.jossowska.javaee.web;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jossowska.javaee.domain.ComicBook;
import com.jossowska.javaee.service.StorageService;

@WebServlet(urlPatterns = "/cart")
public class DataAddToCart extends HttpServlet{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			StorageService s = (StorageService) getServletContext().getAttribute("storage_service");
			
			List<ComicBook> comics = s.getAllComics();
			ComicBook comicToCart = comics.get(Integer.parseInt(request.getParameter("add")) - 1);

			s.addToCart(comicToCart);
			response.sendRedirect("cart");
			out.close();
		}
		
		@Override
		public void init() throws ServletException {

			// application context
			getServletContext().setAttribute("storage_service", new StorageService());
		}
}

