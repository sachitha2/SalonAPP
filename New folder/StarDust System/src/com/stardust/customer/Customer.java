package com.stardust.customer;

import java.util.HashMap;

public class Customer {
	
	//Create Variables to Store Customer Data
	int customerID = 0;
	String fName = "";
	String lName = "";
	int phone = 0;
	String email = "";
	String nic = "";
	String password = "";
	String addressLine1 = "";
	String addressLine2 = "";
	String addressLine3 = "";
	
	//HashMap Set
	HashMap<Integer, String> vehicleType = new HashMap<Integer, String>();
	HashMap<Integer, String> vehicleBrand = new HashMap<Integer, String>();
	HashMap<Integer, String> vehicleModel = new HashMap<Integer, String>();
	HashMap<Integer, String> lastService = new HashMap<Integer, String>();
	HashMap<Integer, String> engineNumber = new HashMap<Integer, String>();
	HashMap<Integer, String> engineCapacity = new HashMap<Integer, String>();
	HashMap<Integer, String> wheelSize = new HashMap<Integer, String>();
	HashMap<Integer, Float> fuelCapacity = new HashMap<Integer, Float>();
	
	
	
	//Setters
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public void setVehicleType(HashMap<Integer, String> vehicleType) {
		this.vehicleType = vehicleType;
	}
	public void setVehicleBrand(HashMap<Integer, String> vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	public void setVehicleModel(HashMap<Integer, String> vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public void setLastService(HashMap<Integer, String> lastService) {
		this.lastService = lastService;
	}
	public void setEngineNumber(HashMap<Integer, String> engineNumber) {
		this.engineNumber = engineNumber;
	}
	public void setEngineCapacity(HashMap<Integer, String> engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	public void setWheelSize(HashMap<Integer, String> wheelSize) {
		this.wheelSize = wheelSize;
	}
	public void setFuelCapacity(HashMap<Integer, Float> fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}
	
	
	
	//Getters	
	public int getCustomerID() {
		return customerID;
	}
	public String getfName() {
		return fName;
	}
	public String getlName() {
		return lName;
	}
	public int getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getNic() {
		return nic;
	}
	public String getPassword() {
		return password;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public HashMap<Integer, String> getVehicleType() {
		return vehicleType;
	}
	public HashMap<Integer, String> getVehicleBrand() {
		return vehicleBrand;
	}
	public HashMap<Integer, String> getVehicleModel() {
		return vehicleModel;
	}
	public HashMap<Integer, String> getLastService() {
		return lastService;
	}
	public HashMap<Integer, String> getEngineNumber() {
		return engineNumber;
	}
	public HashMap<Integer, String> getEngineCapacity() {
		return engineCapacity;
	}
	public HashMap<Integer, String> getWheelSize() {
		return wheelSize;
	}
	public HashMap<Integer, Float> getFuelCapacity() {
		return fuelCapacity;
	}
	
	
	//Singleton(Allow to create only one object in this class)
	//Static Customer Object
	public static Customer customer;
	
	//Private Constructor
	private Customer()
	{
		
	}
	
	//Method to create only one object
	public static Customer getInstance()
	{
		if(customer == null)
		{
			customer = new Customer();
		}
		
		return customer;
	}
	
	
}
