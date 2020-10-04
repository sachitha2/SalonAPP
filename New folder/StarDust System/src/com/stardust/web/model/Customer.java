package com.stardust.web.model;

public class Customer {
	private int customerID;
	private String fName;
	private String lName;
	private int phone;
	private String email;
	private String NIC;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNIC() {
		return NIC;
	}
	
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public String getAddressLine2() {
		return addressLine2;
	}
	
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public String getAddressLine3() {
		return addressLine3;
	}
	
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", fName=" + fName + ", lName=" + lName + ", phone=" + phone
				+ ", email=" + email + ", NIC=" + NIC + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", addressLine3=" + addressLine3 + "]";
	}
}

