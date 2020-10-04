package com.example.salonappnew.ui;


import com.example.salonappnew.editcustomer;
import com.example.salonappnew.editsalondetails;
import com.example.salonappnew.addproduct;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salonappnew.R;
import com.example.salonappnew.addapoint;
import com.example.salonappnew.home;
import com.example.salonappnew.login;
import com.example.salonappnew.news;
import com.example.salonappnew.notification;
import com.example.salonappnew.offers;
import com.example.salonappnew.profile;
import com.example.salonappnew.serchprod;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {


    TextView txtType;
    String type;
      //Customer card view
    CardView cAddAppoint;
    CardView cMyAppoint;
    CardView cProduct;
    CardView cProfile;

    //salon card view
    CardView sNewAppoint;
    CardView saddProduct;
    CardView slistProduct;
    CardView sProfile;




    Button logout;

    GridLayout customer;
    GridLayout salon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //Customer part
        cAddAppoint = findViewById(R.id.cAddAppointment);
        cMyAppoint = findViewById(R.id.cAppointments);
        cProduct = findViewById(R.id.cProducts);
        cProfile = findViewById(R.id.cProfile);

        //salon part
        sNewAppoint = findViewById(R.id.sAppointments);
        saddProduct = findViewById(R.id.sAddProduct);
        slistProduct = findViewById(R.id.sListProducts);
        sProfile = findViewById(R.id.sProfile);

        txtType = findViewById(R.id.txtType);


        customer = findViewById(R.id.customer);
        salon = findViewById(R.id.salon);

        Intent intent = getIntent();

        Log.d("Data",   "Intent "+intent.getStringExtra("type"));
        type = intent.getStringExtra("type");

        if(type.equals("SALON")){
            customer.setVisibility(View.GONE);
            salon.setVisibility(View.VISIBLE);
            txtType.setText("Salon");
        }else{
            customer.setVisibility(View.VISIBLE);
            salon.setVisibility(View.GONE);
            txtType.setText("Customer");
        }


        logout = findViewById(R.id.btnLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                openLogin();
            }
        });

        slistProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, ProductShowInSalon.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Show Products", Toast.LENGTH_SHORT).show();

            }
        });

        cAddAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, SelectDistrict.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Go to Appointment", Toast.LENGTH_SHORT).show();

            }
        });

        cMyAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, CustomerAppoinments.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "My Appointment", Toast.LENGTH_SHORT).show();
            }
        });

        cProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, editcustomer.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "My Profile", Toast.LENGTH_SHORT).show();
            }
        });


        sProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, editsalondetails.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "My Profile", Toast.LENGTH_SHORT).show();
            }
        });


        saddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, addproduct.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Add Products", Toast.LENGTH_SHORT).show();
            }
        });
//        notification.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Dashboard.this, com.example.salonappnew.notification.class);
//                startActivity(intent);
//
//                Toast.makeText(Dashboard.this, "Go to Notifications", Toast.LENGTH_SHORT).show();
//            }
//        });

//        offers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Dashboard.this, com.example.salonappnew.offers.class);
//                startActivity(intent);
//
//                Toast.makeText(Dashboard.this, "Go to Offers", Toast.LENGTH_SHORT).show();
//            }
//        });

//        newsFeed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Dashboard.this, news.class);
//                startActivity(intent);
//
//                Toast.makeText(Dashboard.this, "Go to News feed", Toast.LENGTH_SHORT).show();
//            }
//        });

//        products.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Dashboard.this, serchprod.class);
//                startActivity(intent);
//
//                Toast.makeText(Dashboard.this, "Go to Products", Toast.LENGTH_SHORT).show();
//            }
//        });

//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Dashboard.this, com.example.salonappnew.profile.class);
//                startActivity(intent);
//
//                Toast.makeText(Dashboard.this, "Go to Profile", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    public void openLogin(){
        Intent intent = new Intent(Dashboard.this, login.class);
        startActivity(intent);
        kill_activity();
    }

    public void kill_activity()
    {
        finish();
    }
}