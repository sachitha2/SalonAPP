package com.stardust.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stardust.dao.CustomerDAO;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChangePassword() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the New Password from the Form
		String newPass = request.getParameter("passwordNew");
		
		//Create the Session
		HttpSession session = request.getSession();
		
		//Set New Password in session
		session.setAttribute("password", newPass);
		
		//Get email from the Session
		String email = (String)session.getAttribute("email");
		
		//Create an Object of the CustomerDAO Class
		CustomerDAO dao = new CustomerDAO();
		
		//Execute the "changePassword" method in CustomerDAO Class
		dao.changePassword(newPass, email);
		
		//Redirect to the Customer Profile Page
		response.sendRedirect("customerProfile.jsp?Request=UpdatePassword-Success");
	}

}
