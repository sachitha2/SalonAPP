package com.example.salonappnew.ui;


import com.example.salonappnew.about;
import com.example.salonappnew.common.Common;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salonappnew.R;
import com.example.salonappnew.login;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {
    DrawerLayout drawerLayout;


    //Find profile data start
    static ImageView imgPropic;
    static TextView txtProfileName;
    static String type;
    //Find profile data end

    TextView txtType;

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

    //admin card view
    CardView adminCustomers;
    CardView adminCompany;





    Button logout;

    GridLayout customer;
    GridLayout salon;
    GridLayout admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        //Find profile data start
        imgPropic = findViewById(R.id.imgProfile);
        txtProfileName = findViewById(R.id.txtProfileName);

        Intent intent = getIntent();

        Log.d("Data",   "Intent "+intent.getStringExtra("type"));
        type = intent.getStringExtra("type");
        //Find profile data end

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

        //admin part
        adminCompany = findViewById(R.id.adminCompany);
        adminCustomers = findViewById(R.id.adminCustomers);





        adminCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, AdminShowCompany.class);
                intent.putExtra("type", type);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Show Products", Toast.LENGTH_SHORT).show();
            }
        });

        adminCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, AdminShowCustomers.class);
                intent.putExtra("type", type);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Show Products", Toast.LENGTH_SHORT).show();
            }
        });

        txtType = findViewById(R.id.txtType);


        customer = findViewById(R.id.customer);
        salon = findViewById(R.id.salon);
        admin = findViewById(R.id.admin);



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
                intent.putExtra("type", type);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Show Products", Toast.LENGTH_SHORT).show();
            }
        });

        sNewAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, SalonAppoinmentShow.class);
                intent.putExtra("type", type);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Appoinments", Toast.LENGTH_SHORT).show();
            }
        });

        slistProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, ProductShowInSalon.class);
                intent.putExtra("type", type);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Show Products", Toast.LENGTH_SHORT).show();

            }
        });

        cAddAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, SelectDistrict.class);
                intent.putExtra("type", type);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Go to Appointment", Toast.LENGTH_SHORT).show();

            }
        });

        cMyAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, CustomerAppoinments.class);
                intent.putExtra("type", type);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "My Appointment", Toast.LENGTH_SHORT).show();
            }
        });

        cProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, editcustomer.class);
                intent.putExtra("type", type);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "My Profile", Toast.LENGTH_SHORT).show();
            }
        });


        sProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, editsalondetails.class);
                intent.putExtra("type", type);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "My Profile", Toast.LENGTH_SHORT).show();
            }
        });


        saddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, addproduct.class);
                intent.putExtra("type", type);
                startActivity(intent);

                Toast.makeText(Dashboard.this, "Add Products", Toast.LENGTH_SHORT).show();
            }
        });


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

        //Find profile data start
        Common.findProfileImg(imgPropic,type,txtProfileName);
        //Find profile data end
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
       Common.logout(this);
    }

    public void ClickDashboard(View view){
        recreate();

    }
    public void ClickAboutUs(View view){
        Common.redirectActivity(this, about.class);
    }





    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }




    //nav end
}