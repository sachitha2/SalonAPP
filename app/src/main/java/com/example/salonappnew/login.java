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

public class login extends AppCompatActivity {
    private Button button;
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

    }

    public  void fRegister(){
                String email = emailId.getText().toString();
                String pass = password.getText().toString();

                if(email.isEmpty()){
                    emailId.setError("Please provide a email id");
                    emailId.requestFocus();
                }else if(pass.isEmpty()){
                    password.setError("Please enter a password");
                    password.requestFocus();
                }else{
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
}