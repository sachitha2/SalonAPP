package com.example.salonappnew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salonappnew.models.Company;
import com.example.salonappnew.models.Customer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class editsalondetails extends AppCompatActivity {
    FirebaseAuth mFirebaseAuth;
    private DatabaseReference mFDb;
    private FirebaseDatabase mFirebaseInstant;
    EditText name;
    EditText address;
    EditText phone;

    Button edit,del;

    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editsalondetails);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mFirebaseInstant = FirebaseDatabase.getInstance();
        mFDb = mFirebaseInstant.getReference("users");

        name = findViewById(R.id.txtSalonName);
        address = findViewById(R.id.txtAddress);
        phone = findViewById(R.id.txtPhone);


        edit = findViewById(R.id.btnEdit);
        del = findViewById(R.id.btnDelete);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Company company = new Company(name.getText().toString(),address.getText().toString(),phone.getText().toString(),mFirebaseAuth.getCurrentUser().getEmail());
                mFDb.child("salon").child(key).setValue(company);
                Toast.makeText(getApplicationContext(), "Profile updated", Toast.LENGTH_LONG).show();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFDb.child("salon").child(key).removeValue();
                mFDb.child("userType").child(key).removeValue();
                FirebaseAuth.getInstance().signOut();
                openLogin();
            }
        });

        searchFireStore();
    }



    private void searchFireStore(){
        Query data = mFDb.child("salon").orderByChild("email").startAt(mFirebaseAuth.getCurrentUser().getEmail())
                .endAt(mFirebaseAuth.getCurrentUser().getEmail()+"\uf8ff");



        data.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                System.out.println(dataSnapshot.getKey());

                Log.d("Data","Data ->"+dataSnapshot.getKey());
                key = dataSnapshot.getKey();
                Log.d("Data","Data ->"+dataSnapshot.getValue().toString());

                Company company = dataSnapshot.getValue(Company.class);


                name.setText(company.getCompanyName());
                address.setText(company.getAddress());
                phone.setText(company.getPhone());



                //TODO interface ui error ->not mine

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void kill_activity()
    {
        finish();
    }

    public void openLogin(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}