package com.stardust.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.stardust.web.dao.CustomerDao;
import com.stardust.web.dao.ServicesDao;
import com.stardust.web.model.Customer;


@WebServlet("/GetUsersController")
public class GetUsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String UserRecord = "/Admin.jsp";
    private CustomerDao dao; 
    private ServicesDao dao1;

    public GetUsersController() {
        super();
        
        dao = new CustomerDao();
        dao1 = new ServicesDao();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String redirect="";
	        String action = request.getParameter("action");
	        
	        redirect = UserRecord;
            request.setAttribute("users", dao.getAllUsers());
	        
	        if (action.equalsIgnoreCase("delete")){
	        	String userId = request.getParameter("userId");
	        	int uid = Integer.parseInt(userId);
	        	dao.removeUser(uid);
	        	redirect = UserRecord;
	        	request.setAttribute("users", dao.getAllUsers());
	          
	        }
	        
	        else if(action.equalsIgnoreCase("edit")) {
	        	String userId = request.getParameter("userId");
	            int uid = Integer.parseInt(userId);
	            Customer user = new Customer();
	        	user.setCustomerID(uid);
	            user.setfName(request.getParameter("firstName"));
	            user.setlName(request.getParameter("lastName"));
	            String pho = request.getParameter("phone");
	            int phon = Integer.parseInt(pho);
	            user.setPhone(phon);
	            user.setEmail(request.getParameter("email"));
	            user.setNIC(request.getParameter("nic"));
	            user.setAddressLine1(request.getParameter("ad1"));
	            user.setAddressLine2(request.getParameter("ad2"));
	            user.setAddressLine3(request.getParameter("ad3"));
	            dao.editUser(user);
	            request.setAttribute("user", user);
	            redirect = UserRecord;

	        }
	        
	        else if(action.equalsIgnoreCase("serdelete")) {
	        	String serId = request.getParameter("userId");
	        	int serid = Integer.parseInt(serId);
	        	dao1.removeService(serid);
	        	redirect = UserRecord;
	        	request.setAttribute("services", dao1.getServices());
	        }
	        else {
	        	redirect = UserRecord;
	        }
	        
	        RequestDispatcher view = request.getRequestDispatcher(redirect);
	        view.forward(request, response);
	}



}
