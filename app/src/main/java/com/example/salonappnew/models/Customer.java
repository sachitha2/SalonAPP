package com.example.salonappnew.models;

public class Customer {


    String name;
    String phone;
    String email;
    String gender;//false for women // true for men

    String password;
    String imgUrl;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }


    public String getGender() {
        return gender;
    }

//    public String isGender() {
//        return gender;
//    }

    public String getPassword() {
        return password;
    }



    public Customer(){

    }

    public Customer(String name, String phone, String email, String gender, String password,String imgUrl) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.imgUrl = imgUrl;
    }

    public Customer(String name, String phone, String email, String gender, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
