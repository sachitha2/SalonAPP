package com.example.salonappnew.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.salonappnew.R;
import com.example.salonappnew.about;
import com.example.salonappnew.common.Common;
import com.example.salonappnew.models.Company;
import com.example.salonappnew.models.Product;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminShowCompany extends AppCompatActivity  implements TextWatcher {

    //Find profile data start
    static ImageView imgPropic;
    static TextView txtProfileName;
    static String type;
    //Find profile data end
    DrawerLayout drawerLayout;

    ArrayList<Company> myList;
    AdminShowCompanyAdapter myAdapter;
    EditText searchCustomers;
    ListView customerList;

    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_show_company);

        //nav start
        drawerLayout = findViewById(R.id.drawer_layout);
        //nav end


        Intent intent = getIntent();

        Log.d("Data",   "Intent "+intent.getStringExtra("type"));
        type = intent.getStringExtra("type");


        searchCustomers = findViewById(R.id.txtsearchCustomers);

        customerList = findViewById(R.id.listProducts);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("users/salon");

        searchCustomers.addTextChangedListener(this);

        //Find profile data start
        imgPropic = findViewById(R.id.imgProfile);
        txtProfileName = findViewById(R.id.txtProfileName);
        //Find profile data end

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

    public void ClickHome(View view) {
        redirectActivity(this, Dashboard.class);
    }
    public void ClickDashboard(View view){
        Common.dashboardOpen(this,Dashboard.class,type);

    }
    public void ClickAboutUs(View view){
        redirectActivity(this, about.class);
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

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        this.myAdapter.getFilter().filter(s);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }


    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                myList = new ArrayList<>();

                for (DataSnapshot artistSnapShot : dataSnapshot.getChildren()){
                    Company company = artistSnapShot.getValue(Company.class);

                    myList.add(company);
                }

                myAdapter = new AdminShowCompanyAdapter(AdminShowCompany.this,myList);

                customerList.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}