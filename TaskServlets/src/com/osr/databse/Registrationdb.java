package com.osr.databse;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.osr.model.Model;

public class Registrationdb 
{
		 String url = "jdbc:mysql://localhost:3306/osr";
		 String username = "root";
		 String password = "root";

		public int registration(Model m) throws ClassNotFoundException
		{
			String sql = "insert into osr.employe_data values(?,?,?,?,?,?,?)";
			int result = 0;
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded sucessfully");

			try
			{
				Connection con = DriverManager.getConnection(url,username,password);
				System.out.println("Connection Established");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, m.getFirstname());
				ps.setString(2, m.getLastname());
				ps.setString(3, m.getEmailid());
				ps.setString(4, m.getMobilenumber());
				ps.setString(5, m.getPassword());
				ps.setBlob(6,m.getPhoto());     
				ps.setString(7, m.getPath());
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
	}

