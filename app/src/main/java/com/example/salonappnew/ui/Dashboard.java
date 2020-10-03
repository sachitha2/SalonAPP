package com.example.salonappnew.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.salonappnew.R;
import com.example.salonappnew.addapoint;
import com.example.salonappnew.home;
import com.example.salonappnew.news;
import com.example.salonappnew.notification;
import com.example.salonappnew.offers;
import com.example.salonappnew.profile;
import com.example.salonappnew.serchprod;

public class Dashboard extends AppCompatActivity {
    CardView addAppointment;
    CardView notification;
    CardView offers;
    CardView newsFeed;
    CardView products;
    CardView profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        addAppointment = findViewById(R.id.addAppointment);
        notification = findViewById(R.id.notification);
        offers = findViewById(R.id.offers);
        newsFeed = findViewById(R.id.newsFeed);
        products = findViewById(R.id.products);
        profile = findViewById(R.id.profile);

        addAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, addapoint.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Go to Appointment", Toast.LENGTH_SHORT).show();

            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, com.example.salonappnew.notification.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Go to Notifications", Toast.LENGTH_SHORT).show();
            }
        });

        offers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, com.example.salonappnew.offers.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Go to Offers", Toast.LENGTH_SHORT).show();
            }
        });

        newsFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, news.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Go to News feed", Toast.LENGTH_SHORT).show();
            }
        });

        products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, serchprod.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Go to Products", Toast.LENGTH_SHORT).show();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, com.example.salonappnew.profile.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Go to Profile", Toast.LENGTH_SHORT).show();
            }
        });

    }
}