package com.example.salonappnew.ui;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.salonappnew.R;
import com.example.salonappnew.models.Product;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomerProductListAdapter extends BaseAdapter implements Filterable {




    //Firebase storage
    FirebaseAuth mFirebaseAuth;
    FirebaseStorage storage;
    StorageReference storageReference;
    private DatabaseReference mFDb;
    private FirebaseDatabase mFirebaseInstant;

    Context c;
    ArrayList<Product> originalArray,tmpArray;
    ///filter
    CustomFilter cs;
    ///filter
    String img = "";



    public CustomerProductListAdapter(Context c, ArrayList<Product> originalArray){
        this.c = c;
        this.originalArray = originalArray;
        this.tmpArray = originalArray;
    }


    @Override
    public Object getItem(int position) {
        return originalArray.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.customer_product_list,null);

        TextView productName =row.findViewById(R.id.txtProductName);
        final ImageView simpleImageView = row.findViewById(R.id.simpleImageView);

        TextView txtPrice = row.findViewById(R.id.txtPrice);
        TextView txtRNo = row.findViewById(R.id.txtRNo);
        TextView txtDescri = row.findViewById(R.id.txtDescri);
        txtPrice.setText(originalArray.get(position).getPrice()+"");
        txtRNo.setText(originalArray.get(position).getrNo());
        txtDescri.setText("Description-"+originalArray.get(position).getDescription());

//        Log.d("Data ",URL+originalArray.get(position).getImg());

        mFirebaseInstant = FirebaseDatabase.getInstance();
        mFDb = mFirebaseInstant.getReference("users");




        

        //take image url from firebase

        //firebase storage
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        if(originalArray.get(position).getImg() != null){
            storageReference.child(originalArray.get(position).getImg()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    // Got the download URL for 'users/me/profile.png'
                    Log.d("Data",""+uri.toString());
                    img = uri.toString();

                    Picasso.get().load(uri).into(simpleImageView);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                    Log.d("Data","Error in downloading image data");
                }
            });
        }

        // Alternatively way to get download URL
//        final Uri result = storageReference.child("images/05f1a198-6a05-441b-a4d9-9bbb4f53d037").getDownloadUrl().getResult();
//        Log.d("Data","Image reference "+result);

        productName.setText(originalArray.get(position).getpName());
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return row;
    }

    @Override
    public int getCount() {
        return originalArray.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    ///Codes for filter
    @Override
    public Filter getFilter() {

        if(cs == null){
            cs = new CustomFilter();
        }

        return cs;
    }

    class CustomFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if(constraint != null && constraint.length() > 0) {
                constraint = constraint.toString().toUpperCase();


                ArrayList<Product> filters = new ArrayList<>();

                for (int i = 0; i < tmpArray.size(); i++) {
                    if (tmpArray.get(i).getpName().toUpperCase().contains(constraint)) {
                        Product singleRow = new Product(tmpArray.get(i).getpName(),tmpArray.get(i).getrNo(),tmpArray.get(i).getPrice(),tmpArray.get(i).getDescription(),tmpArray.get(i).getEmail(),tmpArray.get(i).getImg(),tmpArray.get(i).getId());
                        filters.add(singleRow);


                    }



                }
                results.count = filters.size();
                results.values = filters;

            }else {
                results.count = tmpArray.size();
                results.values = tmpArray;

            }
            return results;
        }


        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            originalArray  = (ArrayList<Product>)results.values;
            notifyDataSetChanged();
        }
    }
    ///Codes for filter


}
