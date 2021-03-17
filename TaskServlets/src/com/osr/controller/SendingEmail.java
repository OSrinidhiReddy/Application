package com.osr.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.osr.model.Model;



	@SuppressWarnings("serial")
	@WebServlet("/SendingEmail")
	public class SendingEmail extends HttpServlet
	{

		private HttpSession session;
		private ServletContext scontext;
		static String A_otp;
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			session = req.getSession();
			
			String email = req.getParameter("email");
			scontext=getServletContext();
	        scontext.setAttribute("email", email);
			System.out.println(email);
			try {
				Model m = new Model();
				m.setEmailid(email);
				boolean b = m.validateEmail();
				
				if (b == true) {
					
					try {
						User u = new User();
							u.user(email);
						} catch (Exception e) {
							e.printStackTrace();
						}
					session.setAttribute("otp", A_otp);
					resp.sendRedirect("OtpPage.jsp");
									
				}
				
				else {
					resp.sendRedirect("EmailError.jsp");
				}
				
				
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	class User {
		public void user(String a) throws Exception {
			String email = a;
			SendMail.sendMail(email,null);
		}
	}
	class SendMail {
		
		
		public  static String getRandom(int i) {
			Random rnd = new Random();
			int number = rnd.nextInt(999999);
			return String.format("%06d", number);
			}
			@SuppressWarnings("unused")
			public static boolean sendMail(String recepient, User user) throws Exception
			{
			boolean test = false;
			String fromEmail = "srinidhi171098@gmail.com";
			String password = "Srinidhi@1998";
			Properties pr = new Properties();
			pr.setProperty("mail.smtp.host","smtp.gmail.com");
			pr.setProperty("mail.smtp.port", "587");
			pr.setProperty("mail.smtp.auth", "true");
			pr.setProperty("mail.smtp.starttls.enable", "true");
			Session session = Session.getInstance(pr, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
			return new PasswordAuthentication(fromEmail, password);
			}
			});
			Message message = prepareMessage(session,fromEmail,recepient);
			Transport.send(message);
			return test=true;
			}
			private static Message prepareMessage(Session session, String fromEmail, String recepient) {
			try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Request to Reset password");
			
			
			SendingEmail e = new SendingEmail();
			e.A_otp = getRandom(5);
				
			
			
			message.setText("Enter the OTP and reset your Password. Your OTP : " + e.A_otp + ".");
			return message;
			} catch (Exception e) {
			java.util.logging.Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE,null,e);
			}
			return null;
			}
			
	}
	