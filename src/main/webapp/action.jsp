<%@page import="com.mehak.dao.DB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Action</title>
</head>
<body>

     <center>

	<%
		DB db = new DB();
	
		String action = request.getParameter("action");
		String name = request.getParameter("txtName");
		String patientId = request.getParameter("patient1._id");
		
		if(action.equals("delete")){
			
			db.deletePatient(patientId);
	%>
			<h3>Patient Record Deleted</h3>
	<%			
		}else{
			
	%>	
		<h3>UPDATE PATIENT</h3>	
		<form action="update.jsp" method="post">
			<input type="text" name="txtName" value="<%=name%>">
			<input type="submit" value="UPDATE PATIENT">
		</form>
	<%			
		}
	%>
	</center>

</body>
</html>