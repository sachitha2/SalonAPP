package com.stardust.dao;

import java.sql.*;

public class ContactDAO {
	
	//Database URL
	String url = "jdbc:mysql://localhost:3306/stardust";
			
	//Database User Name
	String user = "root";
			
	//Database Password
	String pass = "12345";
			
	String sql1 = "INSERT INTO Contact_Registered(name, email, phone, message, customerID) VALUES (?, ?, ?, ?, ?)";
	String sql2 = "INSERT INTO Contact_UnRegistered(name, email, phone, message) VALUES (?, ?, ?, ?)"; 
					
	public void registered(String name, String email,int phone, String message, int customerID) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement statement = con.prepareStatement(sql1);
			statement.setString(1,name );
			statement.setString(2, email);
			statement.setInt(3, phone );
			statement.setString(4,message );
			statement.setInt(5,customerID );
					
			int result = statement.executeUpdate();
					
			con.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	public void unRegistered(String name, String email,int phone, String message) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement statement = con.prepareStatement(sql2);
			statement.setString(1,name );
			statement.setString(2, email);
			statement.setInt(3, phone );
			statement.setString(4,message );
					
			int result = statement.executeUpdate();
					
			con.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}


}
