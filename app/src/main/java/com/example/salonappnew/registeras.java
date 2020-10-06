package com.example.salonappnew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.salonappnew.models.Customer;
import com.example.salonappnew.models.UserType;
import com.example.salonappnew.ui.Dashboard;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class registeras extends AppCompatActivity {
    private Button button, button1;


    private  String userId;

//    EditText user,email


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




    }



    public void openCus(){
        Intent intent = new Intent(this, addcustomer.class);
        startActivity(intent);
    }
    public void openCom(){
        Intent intent = new Intent(this, addcompany.class);
        startActivity(intent);
    }




}