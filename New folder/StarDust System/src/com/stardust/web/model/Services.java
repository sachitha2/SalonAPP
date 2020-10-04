package com.stardust.web.model;

public class Services {
	private int serviceID;
	private String serviceType;
	private String bookDate;
	private String bookTime;
	private String requestDate;
	private float amount;
	private int customerID;
	private int vehicleID;
	private int branchID;
	
	
	public int getServiceID() {
		return serviceID;
	}
	
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	
	public String getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	public String getBookDate() {
		return bookDate;
	}
	
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	
	public String getBookTime() {
		return bookTime;
	}
	
	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}
	
	public String getRequestDate() {
		return requestDate;
	}
	
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public int getVehicleID() {
		return vehicleID;
	}
	
	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}
	
	public int getBranchID() {
		return branchID;
	}
	
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	
	@Override
	public String toString() {
		return "Services [serviceID=" + serviceID + ", serviceType=" + serviceType + ", bookDate=" + bookDate
				+ ", bookTime=" + bookTime + ", requestDate=" + requestDate + ", amount=" + amount + ", customerID="
				+ customerID + ", vehicleID=" + vehicleID + ", branchID=" + branchID + "]";
	}
}
