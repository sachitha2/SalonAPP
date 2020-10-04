package com.stardust.contact;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stardust.dao.ContactDAO;

@WebServlet("/ContactUS")
public class ContactUS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get data from the form
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String message = request.getParameter("message");
		
		//Session
		HttpSession session = request.getSession();
		
		//Create an Object of the ContactDAO Class
		ContactDAO dao = new ContactDAO();
		
		//Set Customer ID if Available
		//Registered User
		if(session.getAttribute("customerID") != null)
		{
			//Get Customer ID from the Session
			int customerID = (int)session.getAttribute("customerID");
			
			//Insert Data
			dao.registered(name, email, phone, message, customerID);
		}
		
		//Unregistered User
		else
		{
			//Insert Data
			dao.unRegistered(name, email, phone, message);
		}
			

		
		//Redirect
		response.sendRedirect("index.jsp?Contact=Success");

		
	}

}
