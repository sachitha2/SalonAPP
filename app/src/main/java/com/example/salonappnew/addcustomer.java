package com.example.salonappnew;

import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addcustomer extends AppCompatActivity {
    private DatabaseReference mFDb;
    private FirebaseDatabase mFirebaseInstant;
    private Button button;
    private  String userId;
    EditText eEmail,eName,ePhone;
    FirebaseAuth mFirebaseAuth;
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


        gMale = findViewById(R.id.rMale);
        gFmale = findViewById(R.id.rFemale);



        eEmail.setEnabled(false);
        button = (Button) findViewById(R.id.btn_sub1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validate and add data to data base
                if(validateData()){
                    Toast.makeText(addcustomer.this,"data valid",Toast.LENGTH_LONG).show();

                      //add customer
                        addData();
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

        //TODO reversed because merging
        name = eName.getText().toString();
        phone = ePhone.getText().toString();
        email = eEmail.getText().toString();

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
        }
       else if(!(gMale.isChecked() || gFmale.isChecked())){
            Toast.makeText(addcustomer.this,"Please Select a gender",Toast.LENGTH_LONG).show();
            return false;
        }

        else{
            return true;
        }
    }

    public void addData(){
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



        Customer customer = new Customer(name,phone,email,gen,"no");
        UserType userType = new UserType(email,"CUSTOMER");

        mFDb.child("customer").child(userId).setValue(customer);
        mFDb.child("userType").child(userId).setValue(userType);
//        mFDb.child("E").setValue(customer);
        emptyInputs();
        openDashBoard();

    }

    public  void emptyInputs(){
        eName.setText("");
        ePhone.setText("");
        eEmail.setText("");
    }

    //TODO need to add image upload part
}

