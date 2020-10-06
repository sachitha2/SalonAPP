package com.example.salonappnew.ui;


import com.example.salonappnew.about;
import com.example.salonappnew.editcustomer;
import com.example.salonappnew.editsalondetails;
import com.example.salonappnew.addproduct;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
    DrawerLayout drawerLayout;

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
    GridLayout admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        //nav start
        drawerLayout = findViewById(R.id.drawer_layout);
        //nav end
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
        admin = findViewById(R.id.admin);

        Intent intent = getIntent();

        Log.d("Data",   "Intent "+intent.getStringExtra("type"));
        type = intent.getStringExtra("type");

        if(type.equals("SALON")){
            customer.setVisibility(View.GONE);
            admin.setVisibility(View.GONE);
            salon.setVisibility(View.VISIBLE);
            txtType.setText("Salon");
        }else if(type.equals("ADMIN")){
            customer.setVisibility(View.GONE);
            salon.setVisibility(View.GONE);
            admin.setVisibility(View.VISIBLE);
            txtType.setText("Admin");
        }else{
            customer.setVisibility(View.VISIBLE);
            salon.setVisibility(View.GONE);
            admin.setVisibility(View.GONE);
            txtType.setText("Customer");
        }





        cProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, ShowProductsInCustomer.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Show Products", Toast.LENGTH_SHORT).show();
            }
        });

        sNewAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, SalonAppoinmentShow.class);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Appoinments", Toast.LENGTH_SHORT).show();
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


    //nav start

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);

    }

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void ClickLogout(View view){
        Log.d("Data","Log out clicked");

        logout(this);
    }

    public void ClickHome(View view) {
        recreate();
    }
    public void ClickDashboard(View view){
        recreate();

    }
    public void ClickAboutUs(View view){
        redirectActivity(this, about.class);
    }

    public static void logout(final Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you Sure youb want to logout?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FirebaseAuth.getInstance().signOut();
                activity.finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        Intent intent = new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

    //nav end
}