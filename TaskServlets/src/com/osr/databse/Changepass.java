package com.osr.databse;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.osr.model.Model;

	public class Changepass {
	
		Connection con;
		PreparedStatement ps;
			public int changeb(Model m) {
				int result = 0;
				String url = "***************";
				String uname = "**********";
				String pass = "************";
				String db = "com.mysql.jdbc.Driver";
				
				String sql = "update employe_data set password=? where password =?";
				try {
					Class.forName(db);
					con = DriverManager.getConnection(url, uname, pass);
					 ps = con.prepareStatement(sql);
					ps.setString(1, m.getNewpassword());
					ps.setString(2, m.getPassword());
					System.out.println(ps);
					result = ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return result;

			}

			public boolean validateEmail(Model m) throws SQLException {
				
				
				ps = con.prepareStatement("SELECT emailid FROM employe_data WHERE emailid = ?");
				ps.setString(1, m.getEmailid());
				ResultSet res = ps.executeQuery();
				
				while(res.next() == true)
				{
					return true;
				}	
				
				return false;
			}

	}

