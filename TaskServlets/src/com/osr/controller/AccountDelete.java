package com.osr.controller;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osr.model.Model;

import javax.servlet.ServletContext;

@WebServlet("/AccountDelete")
	public class AccountDelete extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private ServletContext scontext;
		
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			scontext = getServletContext();	
			String email = scontext.getAttribute("emailid").toString();
			System.out.println(email);
			
			try {
				Model m = new Model();
				m.setEmailid(email);
				
				boolean b = m.deleteUsers();
				if (b == true) {
					
						response.sendRedirect("AccDelSucc.jsp");
					
				} else {
					response.sendRedirect("Error.jsp");
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
	}

