package com.stardust.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.stardust.customer.Customer;
import com.stardust.services.Service;

public class CustomerDAO {
	
	//Create an Object of the Customer Class
	Customer cus = Customer.getInstance();
	
	//Create an Object of the Service Class
	Service ser = Service.getInstance();
	
	//Create an Integer Variable
	int count;
	
	
	//HashMap Set of Customer Class
	HashMap <Integer, String> vehicleType = new HashMap <Integer, String>();		
	HashMap <Integer, String> vehicleBrand = new HashMap <Integer, String>();		
	HashMap <Integer, String> vehicleModel = new HashMap <Integer, String>();	
	HashMap <Integer, String> lastService = new HashMap <Integer, String>();		
	HashMap <Integer, String> engineNumber = new HashMap <Integer, String>();		
	HashMap <Integer, String> engineCapacity = new HashMap <Integer, String>();	
	HashMap <Integer, String> wheelSize = new HashMap <Integer, String>();		
	HashMap <Integer, Float> fuelCapacity = new HashMap <Integer, Float>();
	
	
	//HashMap Set of Service Class
	HashMap <Integer, String> serviceType = new HashMap <Integer, String>();		
	HashMap <Integer, String> bookDate = new HashMap <Integer, String>();		
	HashMap <Integer, String> bookTime = new HashMap <Integer, String>();	
	HashMap <Integer, String> requestDate = new HashMap <Integer, String>();		
	HashMap <Integer, Integer> vehicleServiceID = new HashMap <Integer, Integer>();		
	HashMap <Integer, Integer> branchServiceID = new HashMap <Integer, Integer>();
	
	//Database URL
	String url = "jdbc:mysql://localhost:3306/stardust";
			
	//Database User Name
	String username = "root";
			
	//Database Password
	String pass = "12345";
			
	//SQL Queries
	String sql1 = "SELECT * FROM Customer WHERE email = ?;";
	String sql2 = "SELECT * FROM Vehicle WHERE customerID = (SELECT customerID FROM Customer WHERE email = ?);";
	String sql3 = "UPDATE Customer SET fName = ?, lName = ?, phone = ?, addressLine1 = ?, addressLine2 = ?, addressLine3 = ? WHERE email = ?;";
	String sql4 = "INSERT INTO Vehicle(vehicleType, vehicleBrand, vehicleModel, engineNumber, engineCapacity, wheelSize, fuelCapacity, customerID) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	String sql5 = "DELETE FROM Vehicle WHERE vehicleID = ?;";
	String sql6 = "UPDATE Customer SET password = ? WHERE email = ?;";
	String sql7 = "SELECT * FROM Service WHERE customerID = ?;";
	String sql8 = "INSERT INTO Service(serviceType, bookDate, bookTime, requestDate, amount, customerID, vehicleID, branchID) VALUES (?, ?, ?, now(), ?, ?, ?, ?);";
	String sql9 = "DELETE FROM Customer WHERE customerID = ?;";
	
	//Set Email
	public void setEmail(String email) {
		cus.setEmail(email);
	}
	
	//Get Customer and Service Data
	public void assignData()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pass);
			PreparedStatement statement1 = con.prepareStatement(sql1);
			statement1.setString(1, cus.getEmail());
			ResultSet result1 = statement1.executeQuery();
			if(result1.next())
			{
				//Get Customer Data
				cus.setCustomerID(result1.getInt("customerID"));
				cus.setfName(result1.getString("fName"));
				cus.setlName(result1.getString("lName"));
				cus.setPhone(result1.getInt("phone"));
				cus.setNic(result1.getString("NIC"));
				cus.setPassword(result1.getString("password"));
				cus.setAddressLine1(result1.getString("addressLine1"));
				cus.setAddressLine2(result1.getString("addressLine2"));
				cus.setAddressLine3(result1.getString("addressLine3"));
				
				//Get Vehicle Data
				PreparedStatement statement2 = con.prepareStatement(sql2);
				statement2.setString(1, cus.getEmail());
				ResultSet result2 = statement2.executeQuery();
				while(result2.next())
				{
					vehicleType.put(result2.getInt("vehicleID"), result2.getString("vehicleType"));
					vehicleBrand.put(result2.getInt("vehicleID"), result2.getString("vehicleBrand"));
					vehicleModel.put(result2.getInt("vehicleID"), result2.getString("vehicleModel"));
					lastService.put(result2.getInt("vehicleID"), result2.getString("lastService"));
					engineNumber.put(result2.getInt("vehicleID"), result2.getString("engineNumber"));
					engineCapacity.put(result2.getInt("vehicleID"), result2.getString("engineCapacity"));
					wheelSize.put(result2.getInt("vehicleID"), result2.getString("wheelSize"));
					fuelCapacity.put(result2.getInt("vehicleID"), result2.getFloat("fuelCapacity"));										
				}
				
				//Send Vehicle Data
				cus.setVehicleType(vehicleType);
				cus.setVehicleBrand(vehicleBrand);
				cus.setVehicleModel(vehicleModel);
				cus.setLastService(lastService);
				cus.setEngineNumber(engineNumber);
				cus.setEngineCapacity(engineCapacity);
				cus.setWheelSize(wheelSize);
				cus.setFuelCapacity(fuelCapacity);
				
				con.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Send data
	public Customer getData()
	{
		return cus;
	}
	
	
	//Change Details
	public void changeDetails(String fName, String lName, int phone, String add1, String add2, String add3, String email)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pass);
			PreparedStatement statement3 = con.prepareStatement(sql3);
			statement3.setString(1, fName);
			statement3.setString(2, lName);
			statement3.setInt(3, phone);
			statement3.setString(4, add1);
			statement3.setString(5, add2);
			statement3.setString(6, add3);
			statement3.setString(7, email);
			count = statement3.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Add Vehicle
	public void addVehicle(String vehicleType, String vehicleBrand, String vehicleModel, String engineNo, String engineCapacity, String wheelSize, String fuelCapacity, int cusID)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pass);
			PreparedStatement statement4 = con.prepareStatement(sql4);
			statement4.setString(1, vehicleType);
			statement4.setString(2, vehicleBrand);
			statement4.setString(3, vehicleModel);
			statement4.setString(4, engineNo);
			statement4.setString(5, engineCapacity);
			statement4.setString(6, wheelSize);
			statement4.setString(7, fuelCapacity);
			statement4.setInt(8, cusID);
			count = statement4.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Delete Vehicle
	public void deleteVehicle(String vID)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pass);
			PreparedStatement statement5 = con.prepareStatement(sql5);
			statement5.setString(1, vID);
			count = statement5.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Change Password
	public void changePassword(String password , String email)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pass);
			PreparedStatement statement6 = con.prepareStatement(sql6);
			statement6.setString(1, password);
			statement6.setString(2, email);
			count = statement6.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Get Service Details
	public void assignServiceDetails()
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pass);
			PreparedStatement statement7 = con.prepareStatement(sql7);
			statement7.setInt(1, cus.getCustomerID());
			ResultSet result7 = statement7.executeQuery();
			while(result7.next())
			{
				serviceType.put(result7.getInt("serviceID"), result7.getString("serviceType"));
				bookDate.put(result7.getInt("serviceID"), result7.getString("bookDate"));
				bookTime.put(result7.getInt("serviceID"), result7.getString("bookTime"));
				requestDate.put(result7.getInt("serviceID"), result7.getString("requestDate"));
				vehicleServiceID.put(result7.getInt("serviceID"), result7.getInt("vehicleID"));
				branchServiceID.put(result7.getInt("serviceID"), result7.getInt("branchID"));
			}
			
			
			ser.setServiceType(serviceType);
			ser.setBookDate(bookDate);
			ser.setBookTime(bookTime);
			ser.setRequestDate(requestDate);
			ser.setVehicleID(vehicleServiceID);
			ser.setBranchID(branchServiceID);
			
			
			
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Send Service Details
	public Service getServiceDetails()
	{
		return ser;
	}
	
	//Register a Service
	public void serviceRegister(String serviceType, String bookDate, String bookTime, int amount, int customerID, int vehicleID, int branchID)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pass);
			PreparedStatement statement8 = con.prepareStatement(sql8);
			statement8.setString(1, serviceType);
			statement8.setString(2, bookDate);
			statement8.setString(3, bookTime);
			statement8.setInt(4, amount);
			statement8.setInt(5, customerID);
			statement8.setInt(6, vehicleID);
			statement8.setInt(7, branchID);
			count = statement8.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Delete User
	public void deleteCustomer(int customerID)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, pass);
			PreparedStatement statement9 = con.prepareStatement(sql9);
			statement9.setInt(1, customerID);
			count = statement9.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
