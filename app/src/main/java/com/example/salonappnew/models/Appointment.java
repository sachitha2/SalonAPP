package com.example.salonappnew.models;

public class Appointment {

    String salon;
    String date;
    String time;

    public String getSalon() {
        return salon;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }



    public Appointment(){

    }

    public Appointment(String salon, String date, String time) {
        this.salon = salon;
        this.date = date;
        this.time = time;
    }
}
