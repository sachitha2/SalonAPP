package com.example.salonappnew.models;

import com.example.salonappnew.ui.CustomerAppoinmentAdapter;

public class CustomerAppoinment {
    String salonName;
    String date;
    String time;
    String customerEmail;
    String id;
    String salonEmail;


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

    public CustomerAppoinment(String salonName, String date, String time, String customerEmail,String id,String salonEmail) {
        this.salonName = salonName;
        this.date = date;
        this.time = time;
        this.customerEmail = customerEmail;
        this.id = id;
        this.salonEmail = salonEmail;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalonEmail() {
        return salonEmail;
    }

    public void setSalonEmail(String salonEmail) {
        this.salonEmail = salonEmail;
    }
}
