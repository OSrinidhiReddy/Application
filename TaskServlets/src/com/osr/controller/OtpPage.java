package com.osr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/OtpPage")
public class OtpPage extends HttpServlet
{

		
		private HttpSession session;
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 session = req.getSession();
			
			String E_otp = req.getParameter("otp");
			String A_otp = session.getAttribute("otp").toString();
			System.out.println(E_otp);
			System.out.println(A_otp);
			
			if (A_otp.equals(E_otp)) {
		
				resp.sendRedirect("ChangePassword.jsp");
				
			} else {
				resp.sendRedirect("Otp_error.jsp");
				
			}
			
		}
		}
	