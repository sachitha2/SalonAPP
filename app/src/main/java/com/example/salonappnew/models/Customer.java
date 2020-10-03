package com.example.salonappnew.models;

public class Customer {


    String name;
    String phone;
    String email;
    boolean gender;//false for women // true for men

    String password;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }



    public Customer(){

    }

    public Customer(String name, String phone, String email, boolean gender, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }
}
