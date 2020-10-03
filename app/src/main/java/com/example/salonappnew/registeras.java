package com.example.salonappnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.salonappnew.models.Customer;
import com.example.salonappnew.models.UserType;
import com.example.salonappnew.ui.Dashboard;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

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

        //find user data is available and if available intent to dashboard
//        searchFireStore();
        //TODO
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
            //s

        String queryText = "chata@gmail.com";
          Query data = mFDb.child("userType").orderByChild("email").startAt(queryText)
                  .endAt(queryText+"\uf8ff");


          data.addValueEventListener(new ValueEventListener() {
              @Override
              public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                  openDashBoard();

              }


              @Override
              public void onCancelled(@NonNull DatabaseError databaseError) {

              }
          });


            //e


         }

    public void openDashBoard(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}