package com.example.salonappnew.models;

import com.example.salonappnew.ui.CustomerAppoinmentAdapter;

public class CustomerAppoinment {
    String salonName;
    String date;
    String time;
    String customerEmail;


    public CustomerAppoinment(){

    }

    public CustomerAppoinment(String salonName, String date, String time) {
        this.salonName = salonName;
        this.date = date;
        this.time = time;
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
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

    public CustomerAppoinment(String salonName, String date, String time, String customerEmail) {
        this.salonName = salonName;
        this.date = date;
        this.time = time;
        this.customerEmail = customerEmail;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
