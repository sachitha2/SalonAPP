package com.example.salonappnew.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.salonappnew.R;
import com.example.salonappnew.models.Company;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SelectASalon extends AppCompatActivity implements TextWatcher {
    ArrayList<Company> myList;
    CustomerListAdapter myAdapter;
    EditText searchCustomers;
    ListView customerList;
    String district;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_a_salon);

        searchCustomers = findViewById(R.id.txtsearchCustomers);

        customerList = findViewById(R.id.listCustomers);

        //get intent
        Intent intent = getIntent();

        district = intent.getStringExtra("district");

        Log.d("Data",   "Intent "+intent.getStringExtra("district"));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        searchCustomers.addTextChangedListener(this);



    }

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

        Query data = databaseReference.child("salon").orderByChild("district").startAt(district)
                .endAt(district+"\uf8ff");

        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                myList = new ArrayList<>();

                for (DataSnapshot artistSnapShot : dataSnapshot.getChildren()){
                    Company company = artistSnapShot.getValue(Company.class);

                    myList.add(company);
                }

                    myAdapter = new CustomerListAdapter(SelectASalon.this,myList);

                    customerList.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}