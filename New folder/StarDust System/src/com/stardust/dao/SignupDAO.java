package com.stardust.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignupDAO {
	
	//Database URL
	String url = "jdbc:mysql://localhost:3306/stardust";
		
	//Database User Name
	String user = "root";
		
	//Database Password
	String pass = "12345";
	
	//SQL Queries
	String sql1 = "SELECT * FROM Customer WHERE email = ?;";
	String sql2 = "INSERT INTO Customer(fName, lName, phone, email, NIC, password, addressLine1, addressLine2, addressLine3, registeredDateTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, now());";
	
	//Check Existing of the Email
	public boolean checkEmail(String email)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement statement = con.prepareStatement(sql1);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				return false;
			}
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public void insertUser(String fName, String lName, int phone, String email, String NIC, String password, String addressLine1, String addressLine2, String addressLine3)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement statement = con.prepareStatement(sql2);
			statement.setString(1, fName);
			statement.setString(2, lName);
			statement.setInt(3, phone);
			statement.setString(4, email);
			statement.setString(5, NIC);
			statement.setString(6, password);
			statement.setString(7, addressLine1);
			statement.setString(8, addressLine2);
			statement.setString(9, addressLine3);
			int result = statement.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
