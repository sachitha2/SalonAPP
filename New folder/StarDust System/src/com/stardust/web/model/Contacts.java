package com.stardust.web.model;

public class Contacts {

	private int regContactID;
	private String regName;
	private String regEmail;
	private int regPhone;
	private String regMessage;
	private int regCustomerID;
	private int nonContactID;
	private String nonName;
	private String nonEmail;
	private int nonPhone;
	private String nonMessage;
	
	
	public int getRegContactID() {
		return regContactID;
	}
	
	public void setRegContactID(int regContactID) {
		this.regContactID = regContactID;
	}
	
	public String getRegName() {
		return regName;
	}
	
	public void setRegName(String regName) {
		this.regName = regName;
	}
	
	public String getRegEmail() {
		return regEmail;
	}
	
	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}
	
	public int getRegPhone() {
		return regPhone;
	}
	
	public void setRegPhone(int regPhone) {
		this.regPhone = regPhone;
	}
	
	public String getRegMessage() {
		return regMessage;
	}
	
	public void setRegMessage(String regMessage) {
		this.regMessage = regMessage;
	}
	
	public int getRegCustomerID() {
		return regCustomerID;
	}
	
	public void setRegCustomerID(int regCustomerID) {
		this.regCustomerID = regCustomerID;
	}
	
	public int getNonContactID() {
		return nonContactID;
	}
	
	public void setNonContactID(int nonContactID) {
		this.nonContactID = nonContactID;
	}
	
	public String getNonName() {
		return nonName;
	}
	
	public void setNonName(String nonName) {
		this.nonName = nonName;
	}
	
	public int getNonPhone() {
		return nonPhone;
	}
	
	public void setNonPhone(int nonPhone) {
		this.nonPhone = nonPhone;
	}
	
	public String getNonMessage() {
		return nonMessage;
	}
	
	public void setNonMessage(String nonMessage) {
		this.nonMessage = nonMessage;
	}
	

	public String getNonEmail() {
		return nonEmail;
	}

	public void setNonEmail(String nonEmail) {
		this.nonEmail = nonEmail;
	}

	@Override
	public String toString() {
		return "Contacts [regContactID=" + regContactID + ", regName=" + regName + ", regEmail=" + regEmail
				+ ", regPhone=" + regPhone + ", regMessage=" + regMessage + ", regCustomerID=" + regCustomerID
				+ ", nonContactID=" + nonContactID + ", nonName=" + nonName + ", nonEmail=" + nonEmail + ", nonPhone="
				+ nonPhone + ", nonMessage=" + nonMessage + "]";
	}
	

}
