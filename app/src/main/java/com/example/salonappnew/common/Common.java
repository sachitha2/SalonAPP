package com.example.salonappnew.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.salonappnew.R;
import com.example.salonappnew.models.Company;
import com.example.salonappnew.models.Customer;
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

public class Common {
    private static FirebaseAuth mFirebaseAuth;
    private static String key;
    private static DatabaseReference mFDb;
    private static FirebaseDatabase mFirebaseInstant;
    private static FirebaseStorage storage;
    private static StorageReference storageReference;




    public static void redirectActivity(Activity activity, Class aClass) {
        Intent intent = new Intent(activity,aClass);
        activity.startActivity(intent);
    }

    public static void dashboardOpen(Activity activity, Class aClass,String type){

        Intent intent = new Intent(activity,aClass);
        intent.putExtra("type",type);
        activity.startActivity(intent);
        activity.finish();
    }

    //This is Common Logout for all drawers
    public static void logout(final Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you Sure you want to logout?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FirebaseAuth.getInstance().signOut();
                activity.finishAffinity();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }


    public static void findProfileImg(ImageView imgView,String type,TextView txtProfileName){
        //Load image data from firebase



        Log.d("Data","Type"+type);

        searchFireStore(type,imgView,txtProfileName);
    }



    private static void searchFireStore(final String type, final ImageView imgView, final TextView txtProfileName){


        final String[] tmpUrl = new String[1];

        final String[] img = new String[1];

        mFirebaseAuth = FirebaseAuth.getInstance();

        mFirebaseInstant = FirebaseDatabase.getInstance();
        mFDb = mFirebaseInstant.getReference("users");



        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        Log.d("Data","Email ->"+mFirebaseAuth.getCurrentUser().getEmail());
        Log.d("Data","Type to lower case ->"+type.toLowerCase());
        Query data = mFDb.child(type.toLowerCase()).orderByChild("email").startAt(mFirebaseAuth.getCurrentUser().getEmail())
                .endAt(mFirebaseAuth.getCurrentUser().getEmail()+"\uf8ff");


        if (type.equals("ADMIN")){
            txtProfileName.setText("ADMIN");
        }


        data.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                System.out.println(dataSnapshot.getKey());

                Log.d("Data","Data ->"+dataSnapshot.getKey());
                key = dataSnapshot.getKey();
                Log.d("Data","Data ->"+dataSnapshot.getValue().toString());



                if(type.equals("CUSTOMER")){
                    Customer customer = dataSnapshot.getValue(Customer.class);
                    txtProfileName.setText(customer.getName());

                    Log.d("Data","Customer "+customer.getName());
                    tmpUrl[0] = customer.getImgUrl();

                }else if(type.equals("SALON")){
                    Company company = dataSnapshot.getValue(Company.class);
                    txtProfileName.setText(company.getCompanyName());

                    Log.d("Data","SALON "+company.getCompanyName());
                    tmpUrl[0] = company.getImg();
                }else{
                    tmpUrl[0] = null;

                }

                    if(tmpUrl[0] != null){
                        storageReference.child(tmpUrl[0]).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                // Got the download URL for 'users/me/profile.png'
                                Log.d("Data",""+uri.toString());
                                img[0] = uri.toString();

                                Picasso.get().load(uri).into(imgView);
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

}
