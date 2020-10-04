package com.example.salonappnew.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.example.salonappnew.R;
import com.example.salonappnew.models.CustomerAppoinment;
import com.example.salonappnew.models.District;

import java.util.ArrayList;

public class CustomerAppoinments extends AppCompatActivity implements TextWatcher {
    ArrayList<CustomerAppoinment> myList;
    CustomerAppoinmentAdapter myAdapter;
    EditText searchCustomers;
    ListView customerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_appoinments);

        searchCustomers = findViewById(R.id.txtsearchCustomers);

        customerList = findViewById(R.id.listDistrict);


        searchCustomers.addTextChangedListener(this);


        myList = new ArrayList<>();
        myList.add(new CustomerAppoinment("Jaffna","time","this is time"));



        myAdapter = new CustomerAppoinmentAdapter(CustomerAppoinments.this,myList);

        customerList.setAdapter(myAdapter);
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
}