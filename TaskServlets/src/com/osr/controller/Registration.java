package com.osr.controller;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.osr.model.Model;





@SuppressWarnings("serial")
@WebServlet("/Registration")

public class Registration extends HttpServlet {
	
	String firstname;
	String lastname;
	String emailid;
	String mobilenumber;
	String password;
	String imageupload;
	String path;
	FileInputStream fis;
	
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
					
					 if(fileItem.getFieldName().equals("firstname")) {
						 firstname = fileItem.getString();
						 }
					 else if
					 (fileItem.getFieldName().equals("lastname")) {
						 lastname = fileItem.getString();
						 }
					 else if (fileItem.getFieldName().equals("emailid")) {
						 emailid = fileItem.getString();
						 }
					 else if (fileItem.getFieldName().equals("mobilenumber")) {
						 mobilenumber = fileItem.getString();
						 }
					 else if (fileItem.getFieldName().equals("password")) {
						 password= fileItem.getString();
						 }
					
					
				}
					else {
												
						path = "C:\\Users\\USER\\eclipse-workspace\\TaskServlets\\WebContent\\images\\" + fileItem.getName();
						System.out.println(path);
					
						 if (fileItem.getSize() > 0) {
						 fileItem.write(new File(path));
						 }
				}
				
			}
				try {
					
					fis = new FileInputStream(new File(path));
					
					System.out.println(firstname);
					System.out.println(lastname);
					System.out.println(emailid);
					System.out.println(mobilenumber);
					System.out.println(password);
					System.out.println(path);
					
					Model m = new Model();
					m.setFirstname(firstname);
					m.setLastname(lastname);
					m.setPassword(password);
					m.setEmailid(emailid);
					m.setMobilenumber(mobilenumber);
					m.setPhoto(fis);
					m.setPath(path);
					
					
					
					boolean validateEmail = m.validateEmail();
					if (validateEmail == true) {
						
						response.sendRedirect("AccountExist.jsp");
						
					} else {
					
					
					boolean b = m.Register();
					
					if (b == true) {
						System.out.println("true");
						response.sendRedirect("SuccessReg.jsp");
					} else {
						response.sendRedirect("Error.jsp");
					}
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
