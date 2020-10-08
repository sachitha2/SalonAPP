package com.example.salonappnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.salonappnew.models.Customer;
import com.example.salonappnew.models.UserType;
import com.example.salonappnew.ui.Dashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class addcustomer extends AppCompatActivity {

    //Firebase storage
    FirebaseAuth mFirebaseAuth;
    FirebaseStorage storage;
    StorageReference storageReference;
    private DatabaseReference mFDb;
    private FirebaseDatabase mFirebaseInstant;


    private Button button;
    private  String userId;
    EditText eEmail,eName,ePhone,password,passConfirm;
    boolean gender;
    RadioButton gMale;
    RadioButton gFmale;


    ImageView imageView;
    Button button1;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcustomer);


        mFirebaseAuth = FirebaseAuth.getInstance();

        eName = findViewById(R.id.editTextTextPersonName);
        ePhone = findViewById(R.id.editTextTextPersonName4);
        eEmail = findViewById(R.id.eTxtEmail);
        password = findViewById(R.id.txtPass);
        passConfirm = findViewById(R.id.txtPassConfirm);


        gMale = findViewById(R.id.rMale);
        gFmale = findViewById(R.id.rFemale);



        button = (Button) findViewById(R.id.btn_sub1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validate and add data to data base
                if(validateData()){
                    Toast.makeText(addcustomer.this,"data valid",Toast.LENGTH_LONG).show();

                      //add customer
//                        addData("Image url here");
                    fRegister();
                }
            }
        });


        mFirebaseInstant = FirebaseDatabase.getInstance();
        mFDb = mFirebaseInstant.getReference("users");


        userId = mFDb.push().getKey();
        Log.d("Add Customer ","user id is "+userId);


        imageView = (ImageView)findViewById(R.id.img);
        button1 = (Button)findViewById(R.id.btn_img);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });


        //firebase storage
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }

    public void openDashBoard(){
        Intent intent = new Intent(this, Dashboard.class);
        intent.putExtra("type","CUSTOMER");
        startActivity(intent);
    }


    public boolean validateData(){
        String name;
        String phone;
        String email;
        String pass;
        String passC;

        name = eName.getText().toString();
        phone = ePhone.getText().toString();
        email = eEmail.getText().toString();
        pass = password.getText().toString();
        passC = passConfirm.getText().toString();

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
        }else if(pass.isEmpty()){
            password.setError("Please provide a Password");
            password.requestFocus();
            return false;
        }else if(passC.isEmpty()){
            passConfirm.setError("Please provide a Password");
            passConfirm.requestFocus();
            return false;
        }else if(!passC.equals(pass)){
            Toast.makeText(addcustomer.this,"Please Enter same password in both fields",Toast.LENGTH_LONG).show();
            return false;
        }
       else if(!(gMale.isChecked() || gFmale.isChecked())){
            Toast.makeText(addcustomer.this,"Please Select a gender",Toast.LENGTH_LONG).show();
            return false;
        }else if(imageUri == null){
            Toast.makeText(addcustomer.this,"Please Select a Image",Toast.LENGTH_LONG).show();
            return false;
        }

        else{
            return true;
        }
    }

    public void addData(String imageUrl){
        String name;
        String phone;
        String email;
        String gen;//false for women // true for men

        String password;

        name = eName.getText().toString();
        phone = ePhone.getText().toString();
        email = eEmail.getText().toString();

        //take gender
        if(gMale.isChecked()){
            gen = "Male";
        }else{
            gen = "Female";
        }



        Customer customer = new Customer(name,phone,email,gen,"NO",imageUrl);
        UserType userType = new UserType(email,"CUSTOMER");

        mFDb.child("customer").child(userId).setValue(customer);
        mFDb.child("userType").child(userId).setValue(userType);
        emptyInputs();
        openDashBoard();

    }

    public  void emptyInputs(){
        eName.setText("");
        ePhone.setText("");
        eEmail.setText("");
    }

      public  void fRegister(){
            String email = eEmail.getText().toString();
            String pass = password.getText().toString();
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(addcustomer.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(addcustomer.this,"Sign up failed", Toast.LENGTH_LONG).show();

                            }else{

                                Toast.makeText(addcustomer.this,"Sign up ok",Toast.LENGTH_LONG).show();
                                uploadImage();
                            }
                        }
                    });
                }
    private void uploadImage() {

        if(imageUri != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            final String imgId = "images/"+ UUID.randomUUID().toString();
            StorageReference ref = storageReference.child(imgId);

            ref.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            addData(imgId);
                            progressDialog.dismiss();
                            Toast.makeText(addcustomer.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(addcustomer.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }
    }
}

