package com.stardust.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stardust.dao.CustomerDAO;


@WebServlet("/ServiceRegister")
public class ServiceRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServiceRegister() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get Data from the Form
		String serviceType = request.getParameter("serviceType");
		String bookD = request.getParameter("bookDate");
		String bookTime = request.getParameter("bookTime");
		int branch = Integer.parseInt(request.getParameter("branch"));
      	int amount = Integer.parseInt(request.getParameter("amount"));
      	int customerID = Integer.parseInt(request.getParameter("customerID"));
      	int vehicleID = Integer.parseInt(request.getParameter("vehicle"));
      	
      	//Get Date from the form and convert it to "Year-Month-Date" Format
      	SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
      	SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
      	Date date;
      	String bookDate = "";
      	 
      	try {
      		 
      		date = originalFormat.parse(bookD);
      		bookDate = targetFormat.format(date);
      		 
      	} catch(ParseException ex) {
      		ex.printStackTrace();
      	}
      	
      	//Create an Object of the CustomerDAO Class
      	CustomerDAO dao = new CustomerDAO();
      	
      	
      	//Execute the "serviceRegister" method in the CustomerDAO Class
      	dao.serviceRegister(serviceType, bookDate, bookTime, amount, customerID, vehicleID, branch);
      	
      	//Redirect to the Customer Profile Class
      	response.sendRedirect("customerProfile.jsp?Request=Service-Added");
	}

}
