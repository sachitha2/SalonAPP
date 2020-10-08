package com.example.salonappnew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.salonappnew.common.Common;
import com.example.salonappnew.models.Customer;
import com.example.salonappnew.models.UserType;
import com.example.salonappnew.ui.Dashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.UUID;

public class editcustomer extends AppCompatActivity {

    //Find profile data start
    static ImageView imgPropic,imgPropicEdit;
    static TextView txtProfileName;
    static String type;
    private  String userId;
    private  String imageUrl;
    //Find profile data end

    DrawerLayout drawerLayout;
    FirebaseAuth mFirebaseAuth;
    private DatabaseReference mFDb;
    private FirebaseDatabase mFirebaseInstant;
    private static FirebaseStorage storage;
    private static StorageReference storageReference;
    EditText name;
    EditText txtEmail;
    EditText phone;
    EditText txtPassConfirm;
    EditText txtPass;
    EditText txtPassOld;

    Button edit,del,changeImage;

    String key;


    RadioButton gMale;
    RadioButton gFmale;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;


    String sPass;
    String sPassC;
    String sPassOld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcustomer);

        gMale = findViewById(R.id.rMale);
        gFmale = findViewById(R.id.rFemale);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        //Find profile data start
        imgPropic = findViewById(R.id.imgProfile);
        txtProfileName = findViewById(R.id.txtProfileName);
        imgPropicEdit = findViewById(R.id.imgPropicEdit);

        Intent intent = getIntent();
        Log.d("Data",   "Intent select a salon "+intent.getStringExtra("type"));
        type = intent.getStringExtra("type");

        //Find profile data end

        //nav start
        drawerLayout = findViewById(R.id.drawer_layout);
        //nav end

        mFirebaseAuth = FirebaseAuth.getInstance();

        mFirebaseInstant = FirebaseDatabase.getInstance();
        mFDb = mFirebaseInstant.getReference("users");

        name = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        phone = findViewById(R.id.txtPhone);
        txtPass = findViewById(R.id.txtPass);
        txtPassConfirm = findViewById(R.id.txtPassConfirm);
        txtPassOld = findViewById(R.id.txtPassOld);

        txtEmail.setEnabled(false);

        edit = findViewById(R.id.btnEdit);
        del = findViewById(R.id.btnDelete);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sPass = txtPass.getText().toString();
                sPassC = txtPassConfirm.getText().toString();
                sPassOld = txtPassOld.getText().toString();

                //check password status
                if(sPass.isEmpty() && sPassC.isEmpty() && sPassOld.isEmpty()){
                    //change data with out changing password
                    Log.d("Data","All password fields are empty");
                    uploadImage();
                }else{
                    //now check password status
                    Log.d("Data","password checking");
                    if(passChack()){
                        //pass check done
                        Log.d("Data","Password ok");
                        //code here
                        changePassword();
                    }
                }

//

//                String gen;
//                if(gMale.isChecked()){
//                    gen = "Male";
//                }else{
//                    gen = "Female";
//                }
//
//                Customer customer = new Customer(name.getText().toString(),phone.getText().toString(),mFirebaseAuth.getCurrentUser().getEmail(),gen,"",imageUri.toString());
//                mFDb.child("customer").child(key).setValue(customer);
//                Toast.makeText(getApplicationContext(), "Profile updated", Toast.LENGTH_LONG).show();


            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFDb.child("customer").child(key).removeValue();
                mFDb.child("userType").child(key).removeValue();
                FirebaseAuth.getInstance().signOut();
                openLogin();

            }
        });

        searchFireStore();

        changeImage = (Button)findViewById(R.id.btn_img);

        changeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

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
            imgPropicEdit.setImageURI(imageUri);
        }
    }

    private void searchFireStore(){
        Query data = mFDb.child("customer").orderByChild("email").startAt(mFirebaseAuth.getCurrentUser().getEmail())
                .endAt(mFirebaseAuth.getCurrentUser().getEmail()+"\uf8ff");



        data.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                System.out.println(dataSnapshot.getKey());

                Log.d("Data","Data ->"+dataSnapshot.getKey());
                userId = dataSnapshot.getKey();
                Log.d("Data","User id is ->"+userId);
                key = dataSnapshot.getKey();

                Log.d("Data","Data ->"+dataSnapshot.getValue().toString());

                Customer customer = dataSnapshot.getValue(Customer.class);

                Log.d("Data","Customer "+customer.getName());

                imageUrl = customer.getImgUrl();

                name.setText(customer.getName());
                txtEmail.setText(customer.getEmail());
                phone.setText(customer.getPhone());

                if(customer.getGender().equals("Male")){
                    gMale.setChecked(true);
                    gFmale.setChecked(false);
                }else{
                    gMale.setChecked(false);
                    gFmale.setChecked(true);
                }


                if(customer.getImgUrl() != null){
                    storageReference.child(customer.getImgUrl()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            // Got the download URL for 'users/me/profile.png'
                            Log.d("Data",""+uri.toString());


                            Picasso.get().load(uri).into(imgPropicEdit);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            // Handle any errors
                            Log.d("Data","Error in downloading image data");
                        }
                    });
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

    public void kill_activity()
    {
        finish();
    }

    public void openLogin(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    //nav start

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
        //Find profile data start
        Common.findProfileImg(imgPropic,type,txtProfileName);
        //Find profile data end
    }

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void ClickLogout(View view){
        Log.d("Data","Log out clicked");
        Common.logout(this);
    }

    public void ClickDashboard(View view){
        Common.dashboardOpen(this,Dashboard.class,type);

    }
    public void ClickAboutUs(View view){
        redirectActivity(this, about.class);
    }



    public static void redirectActivity(Activity activity, Class aClass) {
        Intent intent = new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

    //nav end


    public  void changePassword(){
        String email = txtEmail.getText().toString();
        final String pass = txtPass.getText().toString();
        final String passOld = txtPassOld.getText().toString();

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        AuthCredential credential = EmailAuthProvider
                .getCredential(email, passOld);

// Prompt the user to re-provide their sign-in credentials
        user.reauthenticate(credential)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            user.updatePassword(pass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Log.d("Data", "Password updated");
                                        Toast.makeText(editcustomer.this,"Password updated",Toast.LENGTH_LONG).show();
                                        uploadImage();
                                    } else {
                                        Toast.makeText(editcustomer.this,"Error password not updated",Toast.LENGTH_LONG).show();
                                        Log.d("Data", "Error password not updated");
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(editcustomer.this,"Error auth failed",Toast.LENGTH_LONG).show();
                            Log.d("Data", "Error auth failed");
                        }
                    }
                });
    }

    public boolean passChack(){
        String sPold;
        String sPnew;
        String sPnewConfirm;

        sPold = txtPassOld.getText().toString();
        sPnew = txtPass.getText().toString();
        sPnewConfirm = txtPassConfirm.getText().toString();

        if(sPold.isEmpty()){
            txtPassOld.setError("Please provide your Old Password");
            txtPassOld.requestFocus();
            return false;
        }else if(sPnew.isEmpty()){
            txtPass.setError("Please provide your New Password");
            txtPass.requestFocus();
            return false;
        }else if(sPnewConfirm.isEmpty()){
            txtPassConfirm.setError("Please confirm your New Password");
            txtPassConfirm.requestFocus();
            return false;
        }
        else if(sPnew.length() < 6 && sPassC.length() < 6){
            Toast.makeText(editcustomer.this,"Min password length is 6 characters",Toast.LENGTH_LONG).show();
            return false;
        }
        else if(!sPnew.equals(sPnewConfirm)){
            Toast.makeText(editcustomer.this,"Please Enter same password in both fields",Toast.LENGTH_LONG).show();
            return false;
        }else{
            return  true;
        }

    }
    private void uploadImage() {

        Log.d("Data","image uri"+imageUri);
        if(imageUri != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            final String imgId = "images/"+ UUID.randomUUID().toString();
            StorageReference ref = storageReference.child(imgId);
            Log.d("Data","uri"+imageUri.toString());
            ref.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            addData(imgId);
                            progressDialog.dismiss();
                            Toast.makeText(editcustomer.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(editcustomer.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
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
        }else{
            addData(imageUrl);
        }
    }



    public void addData(String imageUrl){
        String nameS;
        String phoneS;
        String email;
        String gen;//false for women // true for men

        String password;

        nameS = name.getText().toString();
        phoneS = phone.getText().toString();
        email = txtEmail.getText().toString();

        //take gender
        if(gMale.isChecked()){
            gen = "Male";
        }else{
            gen = "Female";
        }



        Customer customer = new Customer(nameS,phoneS,email,gen,"NO",imageUrl);
        mFDb.child("customer").child(userId).setValue(customer);
    }
}