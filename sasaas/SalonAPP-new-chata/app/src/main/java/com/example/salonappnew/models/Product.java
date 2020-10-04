package com.example.salonappnew.models;

public class Product {
    String pName;
    String rNo;
    float price;
    String description;

    public Product(){

    }

    public Product(String pName, String rNo, float price, String description) {
        this.pName = pName;
        this.rNo = rNo;
        this.price = price;
        this.description = description;
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
}
