package com.example.salonappnew.models;

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
