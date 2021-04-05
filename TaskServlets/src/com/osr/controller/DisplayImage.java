package com.osr.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DisplayImage")
public class DisplayImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	byte[] image;
	
	private Connection con;
	private PreparedStatement pstmt;
	
	ServletOutputStream sos;
	private ServletContext scontext;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/*****", "**********", "***********");
			System.out.println("Connection established");
			
			String sql = "SELECT PHOTO FROM employe_data WHERE EMAILID = ? ";
			
			pstmt = con.prepareStatement(sql);
			
			scontext=getServletContext();
			String email = scontext.getAttribute("emailid").toString();
			
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				image = rs.getBytes(1);
			}
			
			sos = response.getOutputStream();
			sos.write(image);
						
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}




