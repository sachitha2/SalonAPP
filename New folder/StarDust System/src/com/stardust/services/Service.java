package com.stardust.services;

import java.util.HashMap;

public class Service {
	
	//HashMap Set
	HashMap<Integer, String> serviceType = new HashMap<Integer, String>();
	HashMap<Integer, String> bookDate = new HashMap<Integer, String>();
	HashMap<Integer, String> bookTime = new HashMap<Integer, String>();
	HashMap<Integer, String> requestDate = new HashMap<Integer, String>();
	HashMap<Integer, String> amount = new HashMap<Integer, String>();
	HashMap<Integer, String> customerID = new HashMap<Integer, String>();
	HashMap<Integer, Integer> vehicleID = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> branchID = new HashMap<Integer, Integer>();
	
	
	
	//Getters
	public void setServiceType(HashMap<Integer, String> serviceType) {
		this.serviceType = serviceType;
	}
	public void setBookDate(HashMap<Integer, String> bookDate) {
		this.bookDate = bookDate;
	}
	public void setBookTime(HashMap<Integer, String> bookTime) {
		this.bookTime = bookTime;
	}
	public void setRequestDate(HashMap<Integer, String> requestDate) {
		this.requestDate = requestDate;
	}
	public void setAmount(HashMap<Integer, String> amount) {
		this.amount = amount;
	}
	public void setCustomerID(HashMap<Integer, String> customerID) {
		this.customerID = customerID;
	}
	public void setVehicleID(HashMap<Integer, Integer> vehicleID) {
		this.vehicleID = vehicleID;
	}
	public void setBranchID(HashMap<Integer, Integer> branchID) {
		this.branchID = branchID;
	}
	
	
	
	
	//Getters
	public HashMap<Integer, String> getServiceType() {
		return serviceType;
	}
	public HashMap<Integer, String> getBookDate() {
		return bookDate;
	}
	public HashMap<Integer, String> getBookTime() {
		return bookTime;
	}
	public HashMap<Integer, String> getRequestDate() {
		return requestDate;
	}
	public HashMap<Integer, String> getAmount() {
		return amount;
	}
	public HashMap<Integer, String> getCustomerID() {
		return customerID;
	}
	public HashMap<Integer, Integer> getVehicleID() {
		return vehicleID;
	}
	public HashMap<Integer, Integer> getBranchID() {
		return branchID;
	}
	
	
	//Singleton(Allow to create only one object in this class)
	//Static Service Object
	public static Service service;
	
	//Private Constructor
	private Service()
	{
		
	}
	
	//Method to create only one object
	public static Service getInstance()
	{
		if(service == null)
		{
			service = new Service();
		}
		
		return service;
	}

}
