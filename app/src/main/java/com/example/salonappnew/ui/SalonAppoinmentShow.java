package com.example.salonappnew.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.example.salonappnew.R;
import com.example.salonappnew.models.CustomerAppoinment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SalonAppoinmentShow extends AppCompatActivity  implements TextWatcher {

    ArrayList<CustomerAppoinment> myList;
    CustomerAppoinmentAdapter myAdapter;
    EditText searchCustomers;
    ListView customerList;

    FirebaseAuth mFirebaseAuth;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_appoinment_show);

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

        Query data = databaseReference.child("appointment").orderByChild("salonEmail").startAt(mFirebaseAuth.getCurrentUser().getEmail())
                .endAt(mFirebaseAuth.getCurrentUser().getEmail()+"\uf8ff");

        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                myList = new ArrayList<>();

                for (DataSnapshot artistSnapShot : dataSnapshot.getChildren()){
                    CustomerAppoinment cA = artistSnapShot.getValue(CustomerAppoinment.class);
                    Log.d("Data",cA.getCustomerEmail());
                    myList.add(cA);

                }

                myAdapter = new CustomerAppoinmentAdapter(SalonAppoinmentShow.this,myList);

                customerList.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}