package com.osr.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.osr.model.Model;
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1;
	private Connection con;
	private PreparedStatement ps;
	
	String emailid;
	String firstname;
	String lastname;
	String mobilenumber;
	String path;
	FileInputStream fis;
	
	private HttpSession session;
	private ServletContext scontext;
	
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		doPost(request, response);
//	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			return;
		}
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
				return;
			}
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					
					 if
//					 (fileItem.getFieldName().equals("email")) {
//						 email = fileItem.getString();
//						 }
//					 else if
					 (fileItem.getFieldName().equals("firstname")) {
						 firstname = fileItem.getString();
						 }
					 else if (fileItem.getFieldName().equals("lastname")) {
						 lastname = fileItem.getString();
						 }
					 else if (fileItem.getFieldName().equals("mobilenumber")) {
						 mobilenumber = fileItem.getString();
						 }
					
					
				}
					else {
												
						path = "C:\\Users\\USER\\eclipse-workspace\\TaskServlets\\WebContent\\images\\" + fileItem.getName();
						if (fileItem.getSize() > 0) {
						fileItem.write(new File(path));
						 }
				}
				
			}
				try {
					
					fis = new FileInputStream(new File(path));
					
					scontext = getServletContext();	
					emailid = scontext.getAttribute("emailid").toString();
					
					System.out.println(emailid);
					System.out.println(firstname);
					System.out.println(lastname);
					System.out.println(emailid);
					System.out.println(mobilenumber);
					System.out.println(path);
					
					Model m = new Model();
				
					m.setFirstname(firstname);
					m.setLastname(lastname);
					m.setEmailid(emailid);
					m.setMobilenumber(mobilenumber);
					m.setPath(path);
					m.setPhoto(fis);
					
					boolean b = m.Edit();
					
					if (b == true) {
						System.out.println("true");
						response.sendRedirect("EditSucc.jsp");
					} else {
						response.sendRedirect("Editfail.jsp");
					}
				}
				 catch (Exception e) {
					e.printStackTrace();
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
