package com.osr.controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.osr.model.Model;


@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private ServletContext scontext;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		scontext=getServletContext();

		String email = scontext.getAttribute("email").toString();
		System.out.println("reset pwd page email context : " + email);
		String npwd = request.getParameter("password");
		String cpwd = request.getParameter("cpassword");
		if(npwd.equals(cpwd)) 
		{

			try {

				Model m = new Model();
				m.setEmailid(email);
				m.setPassword(cpwd);
				boolean b = m.resetPassword();

				if (b == true) 
				{
                    response.sendRedirect("Resetpwdsuc.jsp");
				} 
				else 
				{
					response.sendRedirect("Resetpwd_error.jsp");

				}

			} 
			catch (Exception e) {
				e.printStackTrace();
			}


		} 

	}
}