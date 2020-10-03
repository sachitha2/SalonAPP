package com.example.salonappnew.models;

public class UserType {
    String email;
    String type;

    public UserType(String email, String type) {
        this.email = email;
        this.type = type;
    }

    public UserType(){

    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }
}
