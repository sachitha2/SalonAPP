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
 import com.example.salonappnew.models.District;
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

 import java.util.ArrayList;
 import java.util.List;
 import java.util.UUID;

 public class addcompany extends AppCompatActivity {


     Spinner featuresSelection;
     Spinner dist;
     //Firebase storage
     FirebaseAuth mFirebaseAuth;
     FirebaseStorage storage;
     StorageReference storageReference;
     private DatabaseReference mFDb;
     private FirebaseDatabase mFirebaseInstant;
     //my
     EditText eEmail,eName,ePhone,eAddress,password,passConfirm;

     String district;
     String category;


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
         eAddress = findViewById(R.id.eTxtAddress);
         password = findViewById(R.id.txtPass);
         passConfirm = findViewById(R.id.txtPassConfirm);

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

//         Spinner staticSpinner = (Spinner) findViewById(R.id.Category);
//         ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(this, R.array.Category, android.R.layout.simple_spinner_item);
//         staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//         staticSpinner.setAdapter(staticAdapter);

           featuresSelection = findViewById(R.id.Category);
          ArrayAdapter<CharSequence> featuresAdapter;
          List<CharSequence> featuresList;

         featuresList = new ArrayList<CharSequence>();
         featuresAdapter = new ArrayAdapter<CharSequence>(this,
                 android.R.layout.simple_spinner_item, featuresList);
         featuresAdapter.setDropDownViewResource(
                 android.R.layout.simple_spinner_dropdown_item);
         featuresSelection = ((Spinner) addcompany.this
                 .findViewById(R.id.Category));
         featuresSelection.setAdapter(featuresAdapter);


         featuresAdapter.add("Hair and beauty");
         featuresAdapter.add("Eye care,lip and neck");
         featuresAdapter.add("Bridal dressing");
         featuresAdapter.add("Pedicure");


          dist = findViewById(R.id.spinnerDistrict);
         ArrayAdapter<CharSequence> dAdapter;
         List<CharSequence> daList;

         daList = new ArrayList<CharSequence>();
         dAdapter = new ArrayAdapter<CharSequence>(this,
                 android.R.layout.simple_spinner_item, daList);
         dAdapter.setDropDownViewResource(
                 android.R.layout.simple_spinner_dropdown_item);
         dist = ((Spinner) addcompany.this
                 .findViewById(R.id.spinnerDistrict));
         dist.setAdapter(dAdapter);



         dAdapter.add("Jaffna");
         dAdapter.add("Kilinochchi");
         dAdapter.add("Mannar");
         dAdapter.add("Mullaitivu");
         dAdapter.add("Vavuniya");
         dAdapter.add("Puttalam");
         dAdapter.add("Kurunegala");
         dAdapter.add("Gampaha");
         dAdapter.add("Colombo");
         dAdapter.add("Kalutara");
         dAdapter.add("Anuradhapura");
         dAdapter.add("Polonnaruwa");
         dAdapter.add("Matale");
         dAdapter.add("Kandy");
         dAdapter.add("Nuwara Eliya");
         dAdapter.add("Kegalle");

         dAdapter.add("Trincomalee");
         dAdapter.add("Batticaloa");
         dAdapter.add("Ampara");
         dAdapter.add("Badulla");
         dAdapter.add("Monaragala");
         dAdapter.add("Hambantota");
         dAdapter.add("Matara");
         dAdapter.add("Galle");



         button = (Button) findViewById(R.id.btn_sub);

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(validateData()){
                     Toast.makeText(addcompany.this,"data valid",Toast.LENGTH_LONG).show();

                     //add salon
                     fRegister();
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

             final String imgId = "images/"+ UUID.randomUUID().toString();

             StorageReference ref = storageReference.child(imgId);

             ref.putFile(imageUri)
                     .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                         @Override
                         public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                             addData(imgId);
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

    public void addData(String imgId){
        String name;
        String phone;
        String email;
        String address;
        String d = dist.getSelectedItem().toString();
        String c = featuresSelection.getSelectedItem().toString();;

        name = eName.getText().toString();
        phone = ePhone.getText().toString();
        email = eEmail.getText().toString();
        address = eAddress.getText().toString();

        Company company = new Company(name,address,phone,email,d,c,imgId);

        UserType userType = new UserType(email,"SALON");

        mFDb.child("salon").child(userId).setValue(company);
        mFDb.child("userType").child(userId).setValue(userType);
//        mFDb.child(company.getPhone()).child(userId).setValue(userType);
//        uploadImage();
        emptyInputs();
        openDashBoard();
    }

     public boolean validateData(){
         String name;
         String phone;
         String email;
         String address;
         String pass;
         String passC;

         name = eName.getText().toString();
         phone = ePhone.getText().toString();
         email = eEmail.getText().toString();
         address = eAddress.getText().toString();
         pass = password.getText().toString();
         passC = passConfirm.getText().toString();

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
         }else if(pass.isEmpty()){
             password.setError("Please provide a Password");
             password.requestFocus();
             return false;
         }else if(passC.isEmpty()){
             passConfirm.setError("Please provide a Password");
             passConfirm.requestFocus();
             return false;
         }else if(!passC.equals(pass)){
             Toast.makeText(addcompany.this,"Please Enter same password in both fields",Toast.LENGTH_LONG).show();
             return false;
         }else if(imageUri == null){
             Toast.makeText(addcompany.this,"Please Select a Image",Toast.LENGTH_LONG).show();
             return false;
         }
         else{
             return true;
         }
     }

     public void openDashBoard(){
         Intent intent = new Intent(this, Dashboard.class);
         intent.putExtra("type","SALON");
         startActivity(intent);
     }

     public  void emptyInputs(){
         eName.setText("");
         ePhone.setText("");
         eEmail.setText("");
         eAddress.setText("");
     }



     public  void fRegister(){
         String email = eEmail.getText().toString();
         String pass = password.getText().toString();
         mFirebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(addcompany.this, new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if(!task.isSuccessful()){
                     Toast.makeText(addcompany.this,"Sign up failed", Toast.LENGTH_LONG).show();

                 }else{

                     Toast.makeText(addcompany.this,"Sign up ok",Toast.LENGTH_LONG).show();
                     uploadImage();
                 }
             }
         });
     }

 }