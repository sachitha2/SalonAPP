package com.example.salonappnew.models;

public class Appointment {

    String salonId;
    String salonEmail;
    String date;
    String time;
    String customerEmail;
    String salonName;

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }

//    public Appointment(String salonId, String salonEmail, String date, String time, String customerEmail) {
//        this.salonId = salonId;
//        this.salonEmail = salonEmail;
//        this.date = date;
//        this.time = time;
//        this.customerEmail = customerEmail;
//    }

//    public Appointment(String salonEmail, String date, String time, String customerEmail) {
//        this.salonEmail = salonEmail;
//        this.date = date;
//        this.time = time;
//        this.customerEmail = customerEmail;
//    }

    public Appointment( String salonEmail, String date, String time, String customerEmail, String salonName) {
        this.salonEmail = salonEmail;
        this.date = date;
        this.time = time;
        this.customerEmail = customerEmail;
        this.salonName = salonName;
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



    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }


}
