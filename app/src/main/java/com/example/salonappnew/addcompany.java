 package com.example.salonappnew;

 import androidx.appcompat.app.AppCompatActivity;

 import android.content.Intent;
 import android.net.Uri;
 import android.os.Bundle;
 import android.provider.MediaStore;
 import android.view.View;
 import android.widget.ArrayAdapter;
 import android.widget.Button;
 import android.widget.ImageView;
 import android.widget.Spinner;

 public class addcompany extends AppCompatActivity {

     private Button button;
     ImageView imageView;
     Button button1;
     private static final int PICK_IMAGE = 100;
     Uri imageUri;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_addcompany);

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
                 openCom1();
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
             imageView.setImageURI(imageUri);
         }
     }

     public void openCom1() {
         Intent intent = new Intent(this, home.class);
         startActivity(intent);
     }
 }