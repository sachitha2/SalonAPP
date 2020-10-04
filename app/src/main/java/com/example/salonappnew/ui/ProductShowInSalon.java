package com.example.salonappnew.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.example.salonappnew.R;
import com.example.salonappnew.models.Company;
import com.example.salonappnew.models.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProductShowInSalon extends AppCompatActivity  implements TextWatcher {
    ArrayList<Product> myList;
    ProductListAdapter myAdapter;
    EditText searchCustomers;
    ListView customerList;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_show_in_salon);

        searchCustomers = findViewById(R.id.txtsearchCustomers);

        customerList = findViewById(R.id.listProducts);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("users/products");

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

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                myList = new ArrayList<>();

                for (DataSnapshot artistSnapShot : dataSnapshot.getChildren()){
                    Product company = artistSnapShot.getValue(Product.class);

                    myList.add(company);
                }

                myAdapter = new ProductListAdapter(ProductShowInSalon.this,myList);

                customerList.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}