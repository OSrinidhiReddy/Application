package com.osr.controller;


import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.osr.model.Model;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext scontext;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		scontext=getServletContext();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email);
		System.out.println(password);
		
		scontext.setAttribute("emailid", email);
		
		try {
			
			Model m = new Model();
			m.setEmailid(email);
			m.setPassword(password);
			boolean b = m.login();
			
			if (b == true) {
				
				response.sendRedirect("Preview.jsp");
				
			} else {
				
				response.sendRedirect("LoginError.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
