package com.stardust.vehicle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stardust.dao.CustomerDAO;


@WebServlet("/DeleteVehicle")
public class DeleteVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteVehicle() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get Vehicle ID
		String vID = request.getParameter("vehicleID");
		
		//Create an Object of CustomerDAO Class
		CustomerDAO dao = new CustomerDAO();
		
		//Execute the "deleteVehicle" method in CustomerDAO Class
		dao.deleteVehicle(vID);
		
		//Redirect to the Customer Profile
		response.sendRedirect("customerProfile.jsp?Request=Vehicle-Deleted");

	}

}
