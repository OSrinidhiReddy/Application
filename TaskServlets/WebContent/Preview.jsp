<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
ServletContext scontext;
try {
Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection con = null;
PreparedStatement pstmt = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
        function preventBack() { window.history.forward(); }
        setTimeout("preventBack()", 0);
        window.onunload = function () { null };
    </script>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

         <%
try{
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/osr", "root", "root");
String sql ="SELECT firstname,lastname,emailid,mobilenumber FROM employe_data WHERE emailid = ? ";
pstmt = con.prepareStatement(sql);
scontext = getServletContext();
String email = scontext.getAttribute("emailid").toString();
pstmt.setString(1, email);
resultSet = pstmt.executeQuery();
while(resultSet.next()){
	
%>
                                                                                                                                     </p>
    <section>
    
    <center>
<div class="row">
  <div class="column left" style="background-color: white;">
      <img src="DisplayImage" width="200" height="200" class="center">
  </div>
  </center>
  <div class="column right" style="background-color: DarkGray;">
      <center>
      <h1><b><u>Your Employee Details</u></b></h1>
       <table class="b" border = "6">
         <tr>
            <td><b><u>First Name</u></b></td>
            <td><b><u>Last Name</u></b></td>
         </tr>
         <tr>
            <td><%=resultSet.getString("firstname") %></td>
            <td><%=resultSet.getString("lastname") %></td>
         </tr>
        <tr>
            <td><b><u>Phone</u></b></td>
            <td><b><u>Email ID</u></b></td>
         </tr>
         <tr>
            <td><%=resultSet.getString("mobilenumber") %></td>
            <td><%=resultSet.getString("emailid") %></td>
         </tr>
                 <tr>
         </tr>
           
      </table>
      <br>
          </center>
</div>
  </div>
</div>
</section>
    <div>
        <p>
           <%
}
con.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
                                                                                                                                     </p>
    </div>
<div class="rows">
  <div class="columns"><center>
    <a href="AccountDelete" style="align-content: center">Delete Account</a></center>
  </div>
  <div class="columns"><center>
    <a href="Edit.jsp" style="align-content: center">Edit Account</a></center>
  </div>
  <div class="columns"><center>
    <a href="Logout" style="align-content: center">Logout</a></center>
  </div>
</div>
      <p>
                                                                                                                                     </p>

</body>
</html>