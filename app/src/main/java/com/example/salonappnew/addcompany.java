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

 import com.example.salonappnew.models.Company;
 import com.example.salonappnew.models.Customer;
 import com.example.salonappnew.models.UserType;
 import com.example.salonappnew.ui.Dashboard;
 import com.google.android.gms.tasks.OnFailureListener;
 import com.google.android.gms.tasks.OnSuccessListener;
 import com.google.firebase.auth.FirebaseAuth;
 import com.google.firebase.database.DatabaseReference;
 import com.google.firebase.database.FirebaseDatabase;
 import com.google.firebase.storage.FirebaseStorage;
 import com.google.firebase.storage.OnProgressListener;
 import com.google.firebase.storage.StorageReference;
 import com.google.firebase.storage.UploadTask;

 import java.util.UUID;

 public class addcompany extends AppCompatActivity {


     //Firebase storage
     FirebaseStorage storage;
     StorageReference storageReference;
     private DatabaseReference mFDb;
     private FirebaseDatabase mFirebaseInstant;
     //my
     EditText eEmail,eName,ePhone,eAddress;
     FirebaseAuth mFirebaseAuth;

     private  String userId;
     //end my

     private Button button;
     ImageView imageView;
     Button button1;
     private static final int PICK_IMAGE = 100;
     Uri imageUri;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_addcompany);

         mFirebaseAuth = FirebaseAuth.getInstance();

         eName = findViewById(R.id.eTxtCName);
         ePhone = findViewById(R.id.eTxtPNumber);
         eEmail = findViewById(R.id.eTxtEmail);
         eEmail.setText(mFirebaseAuth.getCurrentUser().getEmail());
         eEmail.setEnabled(false);
         eAddress = findViewById(R.id.eTxtAddress);

         mFirebaseInstant = FirebaseDatabase.getInstance();
         mFDb = mFirebaseInstant.getReference("users");


         userId = mFDb.push().getKey();

         imageView = (ImageView)findViewById(R.id.img);
         button1 = (Button)findViewById(R.id.btn_img);

         button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 openGallery();
             }
         });

         Spinner staticSpinner = (Spinner) findViewById(R.id.Category);
         ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(this, R.array.Category, android.R.layout.simple_spinner_item);
         staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         staticSpinner.setAdapter(staticAdapter);

         button = (Button) findViewById(R.id.btn_sub);

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(validateData()){
                     Toast.makeText(addcompany.this,"data valid",Toast.LENGTH_LONG).show();

                     //add salon
                     addData();
                 }
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

     //upload image part
     private void uploadImage() {

         if(imageUri != null)
         {
             final ProgressDialog progressDialog = new ProgressDialog(this);
             progressDialog.setTitle("Uploading...");
             progressDialog.show();

             StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
             //TODO save image reference

             ref.putFile(imageUri)
                     .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                         @Override
                         public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                             progressDialog.dismiss();
                             Toast.makeText(addcompany.this, "Uploaded", Toast.LENGTH_SHORT).show();
                         }
                     })
                     .addOnFailureListener(new OnFailureListener() {
                         @Override
                         public void onFailure(@NonNull Exception e) {
                             progressDialog.dismiss();
                             Toast.makeText(addcompany.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
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

    public void addData(){
        String name;
        String phone;
        String email;
        String address;

        name = eName.getText().toString();
        phone = ePhone.getText().toString();
        email = eEmail.getText().toString();
        address = eAddress.getText().toString();

        Company company = new Company(name,address,phone,email);

        UserType userType = new UserType(email,"SALON");

        mFDb.child("salon").child(userId).setValue(company);
        mFDb.child("userType").child(userId).setValue(userType);
//        mFDb.child(company.getPhone()).child(userId).setValue(userType);
//        uploadImage();
        emptyInputs();
        openLogin();
    }

     public boolean validateData(){
         String name;
         String phone;
         String email;
         String address;

         name = eName.getText().toString();
         phone = ePhone.getText().toString();
         email = eEmail.getText().toString();
         address = eAddress.getText().toString();

         if(name.isEmpty()){
             eName.setError("Please enter a Name");
             eName.requestFocus();
             return false;
         }
         else if(address.isEmpty()){
             ePhone.setError("Please enter a Address");
             ePhone.requestFocus();
             return false;
         }
         else if(phone.isEmpty()){
             ePhone.setError("Please enter a Phone number");
             ePhone.requestFocus();
             return false;
         }
         else if(email.isEmpty()){
             eEmail.setError("Please provide a email");
             eEmail.requestFocus();
             return false;
         }
         else{
             return true;
         }
     }

     public void openLogin(){
         Intent intent = new Intent(this, login.class);
         startActivity(intent);
     }

     public  void emptyInputs(){
         eName.setText("");
         ePhone.setText("");
         eEmail.setText("");
         eAddress.setText("");
     }



 }