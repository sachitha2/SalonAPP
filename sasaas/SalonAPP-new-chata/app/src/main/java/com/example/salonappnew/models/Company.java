package com.example.salonappnew.models;

import com.example.salonappnew.ui.SelectASalon;

import java.util.ArrayList;

public class Company {
    String companyName;
    String address;
    String phone;
    String email;

    public Company(){

    }

    public Company(String companyName, String address, String phone, String email) {
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Company(SelectASalon selectASalon, ArrayList<Company> myList) {
    }


    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }


}
