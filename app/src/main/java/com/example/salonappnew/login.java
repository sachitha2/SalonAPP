package com.example.salonappnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salonappnew.ui.Dashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    private Button button,logBtn;
    EditText emailId,password;
    FirebaseAuth mFirebaseAuth;
    private DatabaseReference mFDb;
    private FirebaseDatabase mFirebaseInstant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailId = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPass);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mFirebaseInstant = FirebaseDatabase.getInstance();
        mFDb = mFirebaseInstant.getReference("users");

//        FirebaseUser currentUser = mFirebaseAuth.getCurrentUser();

        if(mFirebaseAuth.getCurrentUser() == null ){
            Toast.makeText(login.this,"current user not found", Toast.LENGTH_LONG).show();

        }else {
            //check user data availability
            checkUserAvailability();

        }



        button = (Button) findViewById(R.id.btn_reg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fRegister();
            }
        });

        logBtn = (Button) findViewById(R.id.btn_login);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fLogin();
            }
        });



    }


    public boolean validatePassAndEmail(){
        String email = emailId.getText().toString();
        String pass = password.getText().toString();

        if(email.isEmpty()){
            emailId.setError("Please provide a email id");
            emailId.requestFocus();
            return false;
        }else if(pass.isEmpty()){
            password.setError("Please enter a password");
            password.requestFocus();
            return false;
        }else{
            return true;
        }
    }

    public  void fRegister(){
            String email = emailId.getText().toString();
            String pass = password.getText().toString();
                if(validatePassAndEmail()){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(login.this,"Sign up failed", Toast.LENGTH_LONG).show();

                            }else{

                                Toast.makeText(login.this,"Sign up ok",Toast.LENGTH_LONG).show();
                                openRegister();
                                emailId.setText("");
                                password.setText("");
                            }
                        }
                    });
                }
    }

    public void openRegister(){
        Intent intent = new Intent(this, registeras.class);
        startActivity(intent);


    }


    public void fLogin(){

        String email = emailId.getText().toString();
        String pass = password.getText().toString();
        if(validatePassAndEmail()){
            mFirebaseAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
//                            progressBar.setVisibility(View.GONE);

                            checkUserAvailability();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
//                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
        }


    }


    public void checkUserAvailability(){
        //if user available redirect to dashboard
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Checking User Availability...");
        progressDialog.show();
        Log.d("Data","Current user"+mFirebaseAuth.getCurrentUser().getEmail());
        Query data = mFDb.child("userType").orderByChild("email").startAt(mFirebaseAuth.getCurrentUser().getEmail().toString())
                .endAt(mFirebaseAuth.getCurrentUser().getEmail()+"\uf8ff");

        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    //bus number exists in Databas

                    openDashBoard();
                    progressDialog.dismiss();
                    kill_activity();
                    Log.d("Data","Data  found");

                } else {
                    //bus number doesn't exists.
                    openRegister();
                    progressDialog.dismiss();
                    kill_activity();
                    Log.d("Data","Data not  found");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void openDashBoard(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    public void kill_activity()
    {
        finish();
    }
}