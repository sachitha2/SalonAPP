package com.example.salonappnew.models;

public class UserType {
    public String email;
    public String type;


    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(String type) {
        this.type = type;
    }



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
