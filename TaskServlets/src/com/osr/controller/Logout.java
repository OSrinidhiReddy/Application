package com.osr.controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(false);
		ServletContext scontext = getServletContext();
		
		System.out.println("Logout page context" + scontext.getAttribute("emailid").toString());
		
		  if (scontext.getAttribute("emailid") != null) {
			  scontext.removeAttribute("emailid");			
		}
	       
	        response.sendRedirect("Registration.jsp");
	}
}
