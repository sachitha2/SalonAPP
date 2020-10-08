package com.example.salonappnew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.salonappnew.common.Common;
import com.example.salonappnew.models.Company;
import com.example.salonappnew.models.Customer;
import com.example.salonappnew.ui.Dashboard;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class editsalondetails extends AppCompatActivity {

    //Find profile data start
    static ImageView imgPropic,imgPropicEdit;
    static TextView txtProfileName;
    static String type;
    //Find profile data end

    DrawerLayout drawerLayout;
    FirebaseAuth mFirebaseAuth;
    private DatabaseReference mFDb;
    private FirebaseDatabase mFirebaseInstant;
    private static FirebaseStorage storage;
    private static StorageReference storageReference;
    EditText name;
    EditText address;
    EditText phone;

    Button edit,del,changeImage;

    String key;

    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editsalondetails);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();


        //Find profile data start
        imgPropic = findViewById(R.id.imgProfile);
        imgPropicEdit = findViewById(R.id.imgPropicEdit);
        txtProfileName = findViewById(R.id.txtProfileName);

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

        name = findViewById(R.id.txtSalonName);
        address = findViewById(R.id.txtAddress);
        phone = findViewById(R.id.txtPhone);


        edit = findViewById(R.id.btnEdit);
        del = findViewById(R.id.btnDelete);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Company company = new Company(name.getText().toString(),address.getText().toString(),phone.getText().toString(),mFirebaseAuth.getCurrentUser().getEmail(),"","","");
                mFDb.child("salon").child(key).setValue(company);
                Toast.makeText(getApplicationContext(), "Profile updated", Toast.LENGTH_LONG).show();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFDb.child("salon").child(key).removeValue();
                mFDb.child("userType").child(key).removeValue();
                FirebaseAuth.getInstance().signOut();
                openLogin();
            }
        });



        changeImage = (Button)findViewById(R.id.btn_img);

        changeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        searchFireStore();
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
        Query data = mFDb.child("salon").orderByChild("email").startAt(mFirebaseAuth.getCurrentUser().getEmail())
                .endAt(mFirebaseAuth.getCurrentUser().getEmail()+"\uf8ff");



        data.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                System.out.println(dataSnapshot.getKey());

                Log.d("Data","Data ->"+dataSnapshot.getKey());
                key = dataSnapshot.getKey();
                Log.d("Data","Data ->"+dataSnapshot.getValue().toString());

                Company company = dataSnapshot.getValue(Company.class);


                name.setText(company.getCompanyName());
                address.setText(company.getAddress());
                phone.setText(company.getPhone());


                if(company.getImg() != null){
                    storageReference.child(company.getImg()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
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


                //TODO interface ui error ->not mine

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
}