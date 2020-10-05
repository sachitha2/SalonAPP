package com.example.salonappnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.salonappnew.models.Customer;
import com.example.salonappnew.models.Product;
import com.example.salonappnew.models.UserType;
import com.example.salonappnew.ui.Dashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class addproduct extends AppCompatActivity {


    //Firebase storage
    FirebaseAuth mFirebaseAuth;
    FirebaseStorage storage;
    StorageReference storageReference;
    private DatabaseReference mFDb;
    private FirebaseDatabase mFirebaseInstant;

    private  String userId;
    EditText txtProductName,txtRNo,txtPrice,txtDescri;
    Button btnAdd;

    private Button button;
    ImageView imageView;
    Button button1;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproduct);


        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseInstant = FirebaseDatabase.getInstance();
        mFDb = mFirebaseInstant.getReference("users");

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
                uploadImage();
            }
        });

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

    public void addData(String img){


        Product product = new Product(txtProductName.getText().toString(),txtRNo.getText().toString(),Float.parseFloat(txtPrice.getText().toString()),txtDescri.getText().toString(),mFirebaseAuth.getCurrentUser().getEmail(),img,userId);
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



    private void uploadImage() {

        if(imageUri != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            final String imgId = "images/"+ UUID.randomUUID().toString();
            StorageReference ref = storageReference.child(imgId);
            //TODO save image reference

            ref.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            addData(imgId);
                            progressDialog.dismiss();
                            Toast.makeText(addproduct.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(addproduct.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
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