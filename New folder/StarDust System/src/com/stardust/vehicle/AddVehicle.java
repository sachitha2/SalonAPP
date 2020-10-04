package com.stardust.vehicle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stardust.dao.CustomerDAO;


@WebServlet("/AddVehicle")
public class AddVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddVehicle() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get data from the form
		String vType = request.getParameter("vehicleType");
		String vBrand = request.getParameter("vehicleBrand");
		String vModel = request.getParameter("vehicleModel");
		String eNo = request.getParameter("engineNumber");
		String eCapacity = request.getParameter("engineCapacity");
		String wSize = request.getParameter("wheelSize");
		String fCapacity = request.getParameter("fuelCapacity");
		
		//Create the session
		HttpSession session = request.getSession();
		
		//Get Customer ID from the session 
		int customerID = (int)session.getAttribute("customerID");
		
		//Create an Object in CustomerDAO Class
		CustomerDAO dao = new CustomerDAO();
		
		//Call the add vehicle method in CustomerDAO Class to add the Vehicle to the DataBase
		dao.addVehicle(vType, vBrand, vModel, eNo, eCapacity, wSize, fCapacity, customerID);
		
		//Redirect to the Customer Profile Page
		response.sendRedirect("customerProfile.jsp?Request=Vehicle-Added");
	}

}
