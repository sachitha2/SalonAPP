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

    }
}