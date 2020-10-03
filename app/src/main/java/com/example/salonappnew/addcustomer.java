package com.example.salonappnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salonappnew.models.Customer;
import com.example.salonappnew.ui.Dashboard;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addcustomer extends AppCompatActivity {
    private DatabaseReference mFDb;
    private FirebaseDatabase mFirebaseInstant;
    private Button button;
    private  String userId;
    EditText eEmail,ePass,eName,ePhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcustomer);

        eName = findViewById(R.id.editTextTextPersonName);
        ePhone = findViewById(R.id.editTextTextPersonName4);
        eEmail = findViewById(R.id.eTxtEmail);
        ePass = findViewById(R.id.eTxtPass);

        button = (Button) findViewById(R.id.btn_sub1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validate and add data to data base
                if(validateData()){
                    Toast.makeText(addcustomer.this,"data valid",Toast.LENGTH_LONG).show();

                }
            }
        });


        mFirebaseInstant = FirebaseDatabase.getInstance();
        mFDb = mFirebaseInstant.getReference("users");


        userId = mFDb.push().getKey();
        Log.d("Add Customer ","user id is "+userId);

    }
    public void openCus1(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }


    public boolean validateData(){
        String name;
        String phone;
        String email;
        boolean gender;//false for women // true for men

        String password;

        name = eName.getText().toString();
        phone = ePhone.getText().toString();
        email = eEmail.getText().toString();
        password = ePass.getText().toString();
        gender = false;

        if(name.isEmpty()){
            eName.setError("Please enter a Name");
            eName.requestFocus();
            return false;
        }else if(phone.isEmpty()){
            ePhone.setError("Please enter a Phone number");
            ePhone.requestFocus();
            return false;
        }
       else if(email.isEmpty()){
            eEmail.setError("Please provide a email");
            eEmail.requestFocus();
            return false;
        }else if(password.isEmpty()){
            ePass.setError("Please enter a password");
            ePass.requestFocus();
            return false;
        }

        else{
            return true;
        }
    }

    public Customer getData(){
        String name;
        String phone;
        String email;
        boolean gender;//false for women // true for men

        String password;

        name = eName.toString();
        phone = ePhone.toString();
        email = eEmail.toString();
        password = ePass.toString();
        gender = true;

        Customer customer = new Customer(name,phone,email,gender,password);

        return customer;
    }
}