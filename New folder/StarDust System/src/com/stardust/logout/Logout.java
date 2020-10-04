package com.stardust.logout;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Logout() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Session
		HttpSession session = request.getSession();
		
		//Remove Attributes from Session
		session.removeAttribute("email");
		session.removeAttribute("password");
		session.removeAttribute("customerID");
    	session.removeAttribute("name");
    	session.removeAttribute("user");
    	
    	response.sendRedirect("index.jsp?Logout=Successful");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
