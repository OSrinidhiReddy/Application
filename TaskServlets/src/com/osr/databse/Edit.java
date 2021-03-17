package com.osr.databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.osr.model.Model;


public class Edit {
		public int edit1(Model r) {
			int result = 0;
			String url = "jdbc:mysql://localhost:3306/osr";
			String username = "root";
			String password = "root";
			String db = "com.mysql.jdbc.Driver";
			
			String sql = "update employe_data set lastname=?,emailid=?,mobilenumber=?,photo=? where firstname =?";
			try {
				Class.forName(db);
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, r.getLastname());
				ps.setString(2, r.getEmailid());
				ps.setString(3, r.getMobilenumber());
				ps.setBlob(4, r.getPhoto());
				ps.setString(5, r.getFirstname());
				
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;

		}
	}
