package com.stardust.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stardust.dao.CustomerDAO;

@WebServlet("/ChangeDetails")
public class ChangeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChangeDetails() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Create an Object in Customer Class
		Customer cus = Customer.getInstance();
		
		//Create the Session
		HttpSession session = request.getSession();
		
		//Get Data from the form and save them in the Customer Class
		cus.fName = request.getParameter("fName");
		cus.lName = request.getParameter("lName");
		cus.phone = Integer.parseInt(request.getParameter("phone"));
		cus.addressLine1 = request.getParameter("address1");
		cus.addressLine2 = request.getParameter("address2");
		cus.addressLine3 = request.getParameter("address3");
		cus.email = (String)session.getAttribute("email");
		
		//Create an Object in CustomerDAO Class
		CustomerDAO dao = new CustomerDAO();
		
		//Execute the "changeDetails" method in CustomerDAo Class to Store the Data in the Database
		dao.changeDetails(cus.fName, cus.lName, cus.phone, cus.addressLine1, cus.addressLine2, cus.addressLine3, cus.email);
		
		//Redirect to the Customer Profile Page
		response.sendRedirect("customerProfile.jsp?Request=ChangeDetails-Success");
		
	}

}
