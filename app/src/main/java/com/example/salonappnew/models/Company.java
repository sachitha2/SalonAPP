package com.example.salonappnew.models;

import com.example.salonappnew.ui.SelectASalon;

import java.util.ArrayList;

public class Company {
    String companyName;
    String address;
    String phone;
    String email;
    String district;
    String category;
    String img;

    public Company(){

    }

    public Company(String companyName, String address, String phone, String email,String district,String category,String img) {
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.district = district;
        this.category = category;
        this.img = img;
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


    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
