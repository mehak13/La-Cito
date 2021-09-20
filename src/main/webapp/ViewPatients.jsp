<%@page import="com.mehak.model.Patient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mehak.dao.DB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW PATIENTS</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>

      <%
		//Patient patient = (Patient)session.getAttribute("keyPatient");
		DB db = new DB();
	%>

      <div class="container">
      
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Timings</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    
   	   <%
			//ArrayList<Patient> patients = db.fetchPatients(patient._id);
   		ArrayList<Patient> patients = db.fetchPatients();
			for(Patient patient1 : patients){
				
		%>
    
	      <tr>
	        <td><%= patient1.name %></td>
	        <td><%= patient1.phone %></td>
	        <td><%= patient1.timings %></td>
	        <td><a href='action.jsp?action=update&patientid=<%=patient1._id%>&patient=<%=patient1.name%>'>UPDATE</a>  <a href='action.jsp?action=delete&patientId=<%=patient1._id%>'>DELETE</a></td>
	      </tr>
	      
      	<%			
				
			}
		%>
    </tbody>
  </table>
</div>

</body>
</html>