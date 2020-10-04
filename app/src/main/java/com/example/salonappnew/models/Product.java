package com.example.salonappnew.models;

public class Product {
    String pName;
    String rNo;
    float price;
    String description;
    String email;
    String img;

    public Product(){

    }

    public Product(String pName, String rNo, float price, String description,String email,String img) {
        this.pName = pName;
        this.rNo = rNo;
        this.price = price;
        this.description = description;
        this.email = email;
        this.img = img;
    }

    public String getpName() {
        return pName;
    }

    public String getrNo() {
        return rNo;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
