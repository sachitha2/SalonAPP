package com.example.salonappnew.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.example.salonappnew.R;
import com.example.salonappnew.models.Company;
import com.example.salonappnew.models.District;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SelectDistrict extends AppCompatActivity implements TextWatcher {
    ArrayList<District> myList;
    DistrictListAdapter myAdapter;
    EditText searchCustomers;
    ListView customerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_district);


        searchCustomers = findViewById(R.id.txtsearchCustomers);

        customerList = findViewById(R.id.listDistrict);


        searchCustomers.addTextChangedListener(this);


        myList = new ArrayList<>();
        myList.add(new District("galgamuwa"));
        myList.add(new District("galgamuwa"));
        myList.add(new District("galgamuwa"));
        myList.add(new District("galgamuwa"));

        //TODO Add district list



        myAdapter = new DistrictListAdapter(SelectDistrict.this,myList);

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