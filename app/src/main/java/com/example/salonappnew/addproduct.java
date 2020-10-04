package com.example.salonappnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salonappnew.models.Customer;
import com.example.salonappnew.models.Product;
import com.example.salonappnew.models.UserType;
import com.example.salonappnew.ui.Dashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addproduct extends AppCompatActivity {



    private DatabaseReference mFDb;
    private FirebaseDatabase mFirebaseInstant;
    private  String userId;
    FirebaseAuth mFirebaseAuth;
    EditText txtProductName,txtRNo,txtPrice,txtDescri;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproduct);

        txtProductName = findViewById(R.id.txtProductName);
        txtRNo = findViewById(R.id.txtRNo);
        txtPrice = findViewById(R.id.txtPrice);
        txtDescri = findViewById(R.id.txtDescri);

        btnAdd = findViewById(R.id.btnAdd);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mFirebaseInstant = FirebaseDatabase.getInstance();
        mFDb = mFirebaseInstant.getReference("users");


        userId = mFDb.push().getKey();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });


    }


    public void addData(){


        Product product = new Product(txtProductName.getText().toString(),txtRNo.getText().toString(),Float.parseFloat(txtPrice.getText().toString()),txtDescri.getText().toString(),mFirebaseAuth.getCurrentUser().getEmail());
        Toast.makeText(addproduct.this,"Product added",Toast.LENGTH_LONG).show();

        mFDb.child("products").child(userId).setValue(product).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });

    }


//    public boolean validateData(){
//
//
//        if(txtProductName.getText().toString().isEmpty()){
//            txtProductName.setError("Please enter a Name");
//            txtProductName.requestFocus();
//            return false;
//        }else if(phone.isEmpty()){
//            ePhone.setError("Please enter a Phone number");
//            ePhone.requestFocus();
//            return false;
//        }
//        else if(email.isEmpty()){
//            eEmail.setError("Please provide a email");
//            eEmail.requestFocus();
//            return false;
//        }
//        else{
//            return true;
//        }
//    }

}