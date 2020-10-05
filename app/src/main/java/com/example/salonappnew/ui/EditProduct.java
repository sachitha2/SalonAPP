package com.example.salonappnew.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.salonappnew.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class EditProduct extends AppCompatActivity {

    Context c;
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
        setContentView(R.layout.activity_edit_product);
    }
}