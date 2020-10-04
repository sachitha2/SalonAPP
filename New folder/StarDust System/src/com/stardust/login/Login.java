package com.stardust.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stardust.dao.LoginDAO;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Login() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get User Email and Password from the Form
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//Create the Session
		HttpSession session = request.getSession();
						
		//Create an Object LoginDAO Class
		LoginDAO loginCheck = new LoginDAO();
						
		//Check the Email and Password
		if(loginCheck.check(email, password))
		{			
			
							
			//Assign Values to the session
			session.setAttribute("email", email);
			session.setAttribute("password", password);
					
			//Login Success Message
			System.out.println("Login Success");
			
			//Redirect to the Customer Profile Page
			response.sendRedirect("customerProfile.jsp?Login=Success");
							
		}
		
		else if(loginCheck.checkAdmin(email, password))
		{
			//Login Success Message
			System.out.println("Admin Login Success");
			
			//Redirect to the Customer Profile Page
			response.sendRedirect("Admin.jsp");
			
			session.setAttribute("user", "Admin");
		}
						
		else {
			//Login Failed Message
			System.out.println("Login Failed");
			
			//Redirect to the Customer Profile Page
			response.sendRedirect("login.jsp?Login=Failed");
		}
	}

}
