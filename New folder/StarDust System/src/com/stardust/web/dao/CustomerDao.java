package com.stardust.web.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.stardust.web.model.Customer;
import com.stardust.web.connection.ConnectionProvider;

public class CustomerDao {
	
	private static Connection conn;
	
	public CustomerDao() {
    	conn = ConnectionProvider.getConnection();
    }
	
	public static List<Customer> getAllUsers() {
		List<Customer> cus = new ArrayList<Customer>();
			
		try{
				String sql = "SELECT * FROM Customer";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Customer cust = new Customer();
					cust.setCustomerID(rs.getInt("customerID"));
					cust.setfName(rs.getString("fName")); 
					cust.setlName(rs.getString("lName")); 
					cust.setPhone(rs.getInt("phone"));
					cust.setEmail(rs.getString("email"));
					cust.setNIC(rs.getString("NIC"));
					cust.setAddressLine1(rs.getString("addressLine1"));
					cust.setAddressLine2(rs.getString("addressLine2"));
					cust.setAddressLine3(rs.getString("addressLine3"));
					
					cus.add(cust);
				}
					
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		return cus;
	
	}
	
	public void removeUser(int userId) {
        try {
        	String sql = "DELETE FROM Customer WHERE customerID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
      
	}
	
	 public void editUser(Customer customer) {    	
	    	try {
	    		String sql = "UPDATE Customer SET fName=?, lName=?, phone=?, email=?, NIC=?, addressLine1=?, addressLine2=?, addressLine3=? WHERE customerID=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
			    ps.setString(1, customer.getfName());
			    ps.setString(2, customer.getlName()); 
			    ps.setInt(3, customer.getPhone());
			    ps.setString(4, customer.getEmail()); 
			    ps.setString(5, customer.getNIC());
			    ps.setString(6, customer.getAddressLine1()); 
			    ps.setString(7, customer.getAddressLine2()); 
			    ps.setString(8, customer.getAddressLine3());
			    ps.setInt(9, customer.getCustomerID());
			 
	            ps.executeUpdate();            

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	
}
