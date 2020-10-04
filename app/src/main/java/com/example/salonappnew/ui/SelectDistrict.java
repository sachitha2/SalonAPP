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
        myList.add(new District("Jaffna"));
        myList.add(new District("Kilinochchi"));
        myList.add(new District("Mannar"));
        myList.add(new District("Mullaitivu"));
        myList.add(new District("Vavuniya"));
        myList.add(new District("Puttalam"));
        myList.add(new District("Kurunegala"));
        myList.add(new District("Gampaha"));
        myList.add(new District("Colombo"));
        myList.add(new District("Kalutara"));
        myList.add(new District("Anuradhapura"));
        myList.add(new District("Polonnaruwa"));
        myList.add(new District("Matale"));
        myList.add(new District("Kandy"));
        myList.add(new District("Nuwara Eliya"));
        myList.add(new District("Kegalle"));

        myList.add(new District("Trincomalee"));
        myList.add(new District("Batticaloa"));
        myList.add(new District("Ampara"));
        myList.add(new District("Badulla"));
        myList.add(new District("Monaragala"));
        myList.add(new District("Hambantota"));
        myList.add(new District("Matara"));
        myList.add(new District("Galle"));




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