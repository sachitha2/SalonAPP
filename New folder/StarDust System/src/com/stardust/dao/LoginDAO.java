package com.stardust.dao;

import java.sql.*;

public class LoginDAO {
	
	//Database URL
	String url = "jdbc:mysql://localhost:3306/stardust";
	
	//Database User Name
	String user = "root";
	
	//Database Password
	String pass = "12345";
	
	//SQL Query to get info about the customer
	String sql1 = "SELECT * FROM Customer WHERE email = ? AND password = ?";
	String sql2 = "SELECT * FROM Staff WHERE email = ? AND password = ?";
	
	
	//Check the Customer Login Credentials
	public boolean check(String username, String password)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement statement = con.prepareStatement(sql1);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				return true;
			}
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	//Check Admin Login Credentials
		public boolean checkAdmin(String username, String password)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement statement = con.prepareStatement(sql2);
				statement.setString(1, username);
				statement.setString(2, password);
				ResultSet result = statement.executeQuery();
				if(result.next())
				{
					return true;
				}
				
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return false;
		}

}
