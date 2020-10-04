package com.stardust.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stardust.web.connection.ConnectionProvider;
import com.stardust.web.model.Services;

public class ServicesDao {
	
	private static Connection conn;
	
	public ServicesDao() {
    	conn = ConnectionProvider.getConnection();

	}
	

	public static List<Services> getServices() {
		List<Services> ser = new ArrayList<Services>();
			
		try{
				String sql = "SELECT * FROM Service";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Services serv = new Services();
					serv.setServiceID(rs.getInt("serviceID"));
					serv.setServiceType(rs.getString("serviceType"));
					serv.setBookDate(rs.getString("bookDate"));
					serv.setBookTime(rs.getString("bookTime"));
					serv.setRequestDate(rs.getString("requestDate"));
					serv.setAmount(rs.getFloat("amount"));
					serv.setCustomerID(rs.getInt("customerID"));
					serv.setVehicleID(rs.getInt("vehicleID"));
					serv.setBranchID(rs.getInt("branchID"));
					ser.add(serv);
				}
					
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		return ser;
	}
	
	public void removeService(int serid) {
        try {
        	String sql = "DELETE FROM Service WHERE serviceID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, serid);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
      
	}
}

