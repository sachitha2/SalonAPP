package com.example.salonappnew;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salonappnew.models.UserType;
import com.example.salonappnew.ui.Dashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class loginAdmin extends AppCompatActivity {
    private Button button,logBtn;
    EditText emailId,password;
    FirebaseAuth mFirebaseAuth;
    private DatabaseReference mFDb;
    private FirebaseDatabase mFirebaseInstant;

    TextView adminLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        emailId = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPass);

        adminLogin = findViewById(R.id.txtLogin);

        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });

        mFirebaseAuth = FirebaseAuth.getInstance();

        mFirebaseInstant = FirebaseDatabase.getInstance();
        mFDb = mFirebaseInstant.getReference("users");

//        FirebaseUser currentUser = mFirebaseAuth.getCurrentUser();

        if(mFirebaseAuth.getCurrentUser() == null ){
            Toast.makeText(loginAdmin.this,"current user not found", Toast.LENGTH_LONG).show();

        }else {
            //check user data availability
            checkUserAvailability();

        }





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

//    public  void fRegister(){
//            String email = emailId.getText().toString();
//            String pass = password.getText().toString();
//                if(validatePassAndEmail()){
//                    mFirebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(!task.isSuccessful()){
//                                Toast.makeText(login.this,"Sign up failed", Toast.LENGTH_LONG).show();
//
//                            }else{
//
//                                Toast.makeText(login.this,"Sign up ok",Toast.LENGTH_LONG).show();
//                                openRegister();
//                                emailId.setText("");
//                                password.setText("");
//                            }
//                        }
//                    });
//                }
//    }

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
//                            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
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
                    Log.d("Data","Data ->"+dataSnapshot.getValue().toString());

                    UserType userType = dataSnapshot.getValue(UserType.class);
//
                    Log.d("Data","User type found -> key "+dataSnapshot.getKey());
                    progressDialog.dismiss();

                    searchFireStore(mFirebaseAuth.getCurrentUser().getEmail());
                    Log.d("Data","Data  found");

                } else {
                    //bus number doesn't exists.
                    Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
//
                    progressDialog.dismiss();
                    Log.d("Data","Data not  found");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void openDashBoard(String type){
        Intent intent = new Intent(this, Dashboard.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }

    public void kill_activity()
    {
        finish();
    }


    private void searchFireStore( String queryText){
        Query data = mFDb.child("userType").orderByChild("email").startAt(queryText)
                .endAt(queryText+"\uf8ff");



        data.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                System.out.println(dataSnapshot.getKey());

                Log.d("Data","Data ->"+dataSnapshot.getKey());
                Log.d("Data","Data ->"+dataSnapshot.getValue().toString());

                UserType userType = dataSnapshot.getValue(UserType.class);

                Log.d("Data","Data ->"+userType.getType());
                String  usertT = userType.getType();
                if(usertT.equals("ADMIN")){
                    Toast.makeText(getApplicationContext(), "Opening Dashboard", Toast.LENGTH_LONG).show();

                    openDashBoard(userType.getType());
                    kill_activity();
                }else{
                    Toast.makeText(getApplicationContext(), "You are not an admin", Toast.LENGTH_LONG).show();


                }

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

    public void openLogin(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}