package com.mehak.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mehak.dao.DB;
import com.mehak.model.Patient;


@WebServlet({ "/RegisterServelet", "/register" })
public class RegisterServelet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	service(request, response);
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Patient patient = new Patient();
		patient.name=request.getParameter("txtName");
	    patient.phone=request.getParameter("txtPhone");
	    patient.timings=request.getParameter("timings");
		
		System.out.println(patient);
		
		DB db = new DB();
		
		boolean result = db.registerUser(patient);
		

		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
	
		
		
		String html = "";
		if(result) {
		
		HttpSession session = request.getSession();
		session.setAttribute("keyPatient", patient);
		

		html = "<html><body><center>Registration Successful<br><br>"
				+ "<a href='index.html'>Enter Home</a>"
				+ "</center></body></html>";
		
	}else {
		html = "<html><body><center>Please try Again</center></body></html>";
	}
	
	//writer.println(message);
	writer.println(html);
	}

	}

	
	


