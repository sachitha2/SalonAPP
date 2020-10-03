package com.example.salonappnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.salonappnew.models.Customer;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registeras extends AppCompatActivity {
    private Button button, button1;
    private DatabaseReference mFDb;
    private FirebaseDatabase mFirebaseInstant;


    private  String userId;

//    EditText user,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeras);

        button = (Button) findViewById(R.id.btn_cus);
        button1 = (Button) findViewById(R.id.btn_com);

        //find user data is available and if available intent to dashboard

        //TODO

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCus();

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCom();

            }
        });

        mFirebaseInstant = FirebaseDatabase.getInstance();
        mFDb = mFirebaseInstant.getReference("users");


        userId = mFDb.push().getKey();
    }

    public void addCustomer(){
        Customer customer = new Customer("hevecdfc","venncd","erfe",false,"pass");
        mFDb.child("customer").child(userId).setValue(customer);
    }
    public  void updateCustomer(){
        mFDb.child("customer").child(userId).child("name").setValue("chata1");
        mFDb.child("customer").child(userId).child("phone").setValue("07155");
        mFDb.child("customer").child(userId).child("email").setValue("chata@chata.com");
        mFDb.child("customer").child(userId).child("gender").setValue(false);
        mFDb.child("customer").child(userId).child("password").setValue("password is me");

    }
    public void openCus(){
        Intent intent = new Intent(this, addcustomer.class);
        startActivity(intent);
    }
    public void openCom(){
        Intent intent = new Intent(this, addcompany.class);
        startActivity(intent);
    }
    private void searchFireStore(){
         }
}