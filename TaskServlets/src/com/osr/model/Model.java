package com.osr.model;


import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Model
{

	Connection con;
	PreparedStatement ps;
	private String Firstname;
	private String Lastname;
	private String Emailid;
	private String Mobilenumber;
	private String Password;
	private FileInputStream Photo;
	private String newpassword;
	private String path;
	



	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getEmailid() {
		return Emailid;
	}

	public void setEmailid(String emailid) {
		Emailid = emailid;
	}

	public String getMobilenumber() {
		return Mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		Mobilenumber = mobilenumber;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public FileInputStream getPhoto() {
		return Photo;
	}

	public void setPhoto(FileInputStream photo) {
		Photo = photo;
	}

	public Model() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/osr", "root", "root");
		System.out.println("Connection established");
	}
	


	public boolean validateEmail() throws SQLException {
		
		ps = con.prepareStatement("SELECT emailid FROM employe_data WHERE emailid = ?");
		ps.setString(1,Emailid);
		ResultSet res = ps.executeQuery();

		while(res.next() == true)
		{
			return true;
		}	

		return false;
	}





	public boolean resetPassword() {

		try {

			String sql = "UPDATE employe_data SET password= ? WHERE emailid= ? ";

			ps = con.prepareStatement(sql);
			ps.setString(1, Password);
			ps.setString(2, Emailid);

			int x = ps.executeUpdate();

			if (x > 0) {
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}



	
	
	
	public boolean deleteUsers() throws SQLException {
		String sql = "DELETE FROM employe_data WHERE Emailid= ?" ;
		ps= con.prepareStatement(sql);
		ps.setString(1, Emailid);
		int x = ps.executeUpdate();
		if (x > 0) {
				return true;
		}
			return false;
		}
	
	
	
	
	
	public boolean Register() {
		try {
			ps = con.prepareStatement("Insert into employe_data  values(?,?,?,?,?,?,?)");
		
			ps.setString(1, Firstname);
			ps.setString(2, Lastname);
			ps.setString(3, Emailid);
			ps.setString(4, Mobilenumber);
			ps.setString(5, Password);
			ps.setBinaryStream(6, Photo);
			ps.setString(7, path);
			int x = ps.executeUpdate();
			if (x > 0) {
				return true;
			}		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	
	
	
	public boolean login() throws SQLException {
		ps = con.prepareStatement("SELECT emailid FROM employe_data WHERE emailid = ? and password = ? ");
		ps.setString(1, Emailid);
		ps.setString(2, Password);
		ResultSet res = ps.executeQuery();
		
		while(res.next() == true)
		{
			return true;
		}
		return false;
	}
	
	
	

	public boolean Edit() {
			
			try {
				
				String sql = "UPDATE employe_data SET firstname= ?,lastname= ?,mobilenumber= ?,Photo = ?,Path= ? WHERE emailid= ? ";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, Firstname);
				ps.setString(2, Lastname);
				ps.setString(3, Mobilenumber);
				ps.setBinaryStream(4, Photo);
				ps.setString(5, path);
				ps.setString(6, Emailid);
			
					int x = ps.executeUpdate();
					
					if (x > 0) {
						return true;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return false;
	}
}


