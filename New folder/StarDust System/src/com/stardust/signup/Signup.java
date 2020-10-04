package com.stardust.signup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stardust.dao.SignupDAO;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get Values
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastname");
		int phone = Integer.parseInt(request.getParameter("phone"));		
		String email = request.getParameter("email");
		String nic = request.getParameter("nic");
		String password = request.getParameter("password");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		
		//Create an Object of the SignupDAO Class
		SignupDAO dao = new SignupDAO();
		
		//Email doen't exists. Create an Account
		if(dao.checkEmail(email))
		{
			dao.insertUser(fName, lName, phone, email, nic, password, address1, address2, address3);
			
			//Create the Session
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("password", password);			
			
			response.sendRedirect("customerProfile.jsp?Request=Account-Created");
		}
		
		//Email Existing in the Database
		else
		{
			response.sendRedirect("signup.jsp?Error=Email-Exists");
		}
		
		
	}

}
