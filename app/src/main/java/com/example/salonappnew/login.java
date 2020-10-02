package com.example.salonappnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    private Button button,logBtn;
    EditText emailId,password;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailId = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPass);

        mFirebaseAuth = FirebaseAuth.getInstance();

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

                            openRegister();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
//                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
        }


    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mFirebaseAuth.getCurrentUser();
//
//    }
}