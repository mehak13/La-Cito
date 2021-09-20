<%@page import="com.mehak.dao.DB"%>
<%@page import="org.bson.types.ObjectId"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>

	<%
	String name = request.getParameter("patient");
	String patientId = request.getParameter("patientid");
	
	 	DB db = new DB();
		db.updatePatient(name,patientId);
	
	%>
	
	<h3>Patient Updated</h3><br>
	<h3><a href='ViewPatients.jsp'>View Patients</a></h3> 
	
	</center>


</body>
</html>