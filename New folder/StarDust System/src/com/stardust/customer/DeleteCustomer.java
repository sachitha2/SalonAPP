package com.stardust.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stardust.dao.CustomerDAO;


@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get Session
		HttpSession session = request.getSession();
		
		//Get Customer ID from Session
		int customerID = (int)session.getAttribute("customerID");
		
		//Create an Object of the CustomerDAO Class
		CustomerDAO dao = new CustomerDAO();
		
		//Delete User in the Database
		dao.deleteCustomer(customerID);
		
		//Remove Attributes from Session
		if(session.getAttribute("email") != null)
		{
			session.removeAttribute("email");
		}
				
		if(session.getAttribute("password") != null)
		{
			session.removeAttribute("password");
		}
				
		if(session.getAttribute("customerID") != null)
		{
			session.removeAttribute("customerID");
		}
				
		if(session.getAttribute("name") != null)
		{
			session.removeAttribute("name");
		}
				
		if(session.getAttribute("user") != null)
		{
			session.removeAttribute("user");
		}
		
		//Redirect
		response.sendRedirect("index.jsp?User=Deleted");
	}

}
