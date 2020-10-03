package com.example.salonappnew.models;

public class Appointment {

    String salonId;
    String salonEmail;
    String date;
    String time;
    String customerId;
    String customerEmail;

    public Appointment(String salonId, String salonEmail, String date, String time, String customerId, String customerEmail) {
        this.salonId = salonId;
        this.salonEmail = salonEmail;
        this.date = date;
        this.time = time;
        this.customerId = customerId;
        this.customerEmail = customerEmail;
    }

    public Appointment(){

    }

    public String getSalonId() {
        return salonId;
    }

    public void setSalonId(String salonId) {
        this.salonId = salonId;
    }

    public String getSalonEmail() {
        return salonEmail;
    }

    public void setSalonEmail(String salonEmail) {
        this.salonEmail = salonEmail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
