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
import android.widget.ListView;

import com.example.salonappnew.R;
import com.example.salonappnew.about;
import com.example.salonappnew.models.Company;
import com.example.salonappnew.models.CustomerAppoinment;
import com.example.salonappnew.models.District;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CustomerAppoinments extends AppCompatActivity implements TextWatcher {

    DrawerLayout drawerLayout;
    ArrayList<CustomerAppoinment> myList;
    CustomerAppoinmentAdapter myAdapter;
    EditText searchCustomers;
    ListView customerList;

    FirebaseAuth mFirebaseAuth;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_appoinments);

        //nav start
        drawerLayout = findViewById(R.id.drawer_layout);
        //nav end

        searchCustomers = findViewById(R.id.txtsearchCustomers);

        customerList = findViewById(R.id.listDistrict);


        searchCustomers.addTextChangedListener(this);
        mFirebaseAuth = FirebaseAuth.getInstance();








        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        this.myAdapter.getFilter().filter(charSequence);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    protected void onStart() {
        super.onStart();

        Query data = databaseReference.child("appointment").orderByChild("customerEmail").startAt(mFirebaseAuth.getCurrentUser().getEmail())
                .endAt(mFirebaseAuth.getCurrentUser().getEmail()+"\uf8ff");

        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                myList = new ArrayList<>();

                for (DataSnapshot artistSnapShot : dataSnapshot.getChildren()){
                    CustomerAppoinment cA = artistSnapShot.getValue(CustomerAppoinment.class);
                    myList.add(cA);

                }

                myAdapter = new CustomerAppoinmentAdapter(CustomerAppoinments.this,myList);

                customerList.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
        redirectActivity(this, Dashboard.class);
    }
    public void ClickDashboard(View view){
        redirectActivity(this, Dashboard.class);

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