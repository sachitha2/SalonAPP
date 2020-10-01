package com.example.salonappnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class salonHome extends AppCompatActivity {
    TextView textView, textView1, textView2, textView3, textView4, textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView = (TextView) findViewById(R.id.txt_appointment);
        textView1 = (TextView) findViewById(R.id.txt_notification1);
        textView2 = (TextView) findViewById(R.id.txt_offer);
        textView3 = (TextView) findViewById(R.id.txt_news);
        textView4 = (TextView) findViewById(R.id.txt_product);
        textView5 = (TextView) findViewById(R.id.txt_profile);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(salonHome.this, addapoint.class);
                startActivity(intent);

                Toast.makeText(salonHome.this, "Go to Appointment", Toast.LENGTH_SHORT).show();
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(salonHome.this, notification.class);
                startActivity(intent);

                Toast.makeText(salonHome.this, "Go to Notifications", Toast.LENGTH_SHORT).show();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(salonHome.this, offers.class);
                startActivity(intent);

                Toast.makeText(salonHome.this, "Go to Offers", Toast.LENGTH_SHORT).show();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(salonHome.this, news.class);
                startActivity(intent);

                Toast.makeText(salonHome.this, "Go to News feed", Toast.LENGTH_SHORT).show();
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(salonHome.this, serchprod.class);
                startActivity(intent);

                Toast.makeText(salonHome.this, "Go to Products", Toast.LENGTH_SHORT).show();
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(salonHome.this, profile.class);
                startActivity(intent);

                Toast.makeText(salonHome.this, "Go to Profile", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
