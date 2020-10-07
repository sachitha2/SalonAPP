package com.example.salonappnew.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DirectAction;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.salonappnew.R;
import com.example.salonappnew.about;
import com.example.salonappnew.addapoint;
import com.example.salonappnew.common.Common;
import com.example.salonappnew.models.Appointment;
import com.example.salonappnew.selectsalon;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class EditAppointments extends AppCompatActivity {


    //Find profile data start
    static ImageView imgPropic;
    static TextView txtProfileName;
    static String type;
    //Find profile data end


    DrawerLayout drawerLayout;
    private DatabaseReference mFDb;
    private FirebaseDatabase mFirebaseInstant;


    String salonName;
    FirebaseAuth mFirebaseAuth;
    String salonEmail;
    TextView txtSalon;
    private Button addAppoint;
    Button btn_date;
    TextView tvTimer2;
    int t2Hour,t2Minute;
    String key;
    String date = null, time = null,selectedTime;


    private static final String TAG = "addapoint";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mdDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_appointments);

        //Find profile data start
        imgPropic = findViewById(R.id.imgProfile);
        txtProfileName = findViewById(R.id.txtProfileName);

        Intent intent = getIntent();
        Log.d("Data",   "Intent select a salon "+intent.getStringExtra("type"));
        type = intent.getStringExtra("type");

        //Find profile data end

        //nav start
        drawerLayout = findViewById(R.id.drawer_layout);
        //nav end

        //set salon in text view
        salonEmail = intent.getStringExtra("salonEmail");


        txtSalon = findViewById(R.id.txtSalonName);
        salonName = intent.getStringExtra("salonName");
        key = intent.getStringExtra("key");

        txtSalon.setText(salonName);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mFirebaseInstant = FirebaseDatabase.getInstance();
        mFDb = mFirebaseInstant.getReference("users");




        addAppoint = findViewById(R.id.btnAddAppointment);

        addAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validateData()){
                    addData();
                }else{

                }
            }
        });



        mDisplayDate = (TextView) findViewById(R.id.btn_sub1);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        EditAppointments.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mdDateSetListener,
                        year,month,day);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mdDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: date: mm/dd/yyy: "+ month + "/" + day + "/" +year);

                date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        tvTimer2 = findViewById(R.id.btn_time);
        tvTimer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        EditAppointments.this,
                        android.R.style.Theme_Material_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t2Hour = hourOfDay;
                                t2Minute = minute;
                                time = t2Hour +  ":" + t2Minute;
                                @SuppressLint("SimpleDateFormat") SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);

                                    @SuppressLint("SimpleDateFormat") SimpleDateFormat f12Hourse = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    assert date != null;

                                    selectedTime = f12Hourse.format(date);
                                    tvTimer2.setText(f12Hourse.format(date));
                                }catch (ParseException e){
                                    e.printStackTrace();
                                }
                            }
                        },12,0,false
                );
                Objects.requireNonNull(timePickerDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(t2Hour,t2Minute);
                timePickerDialog.show();
            }
        });




    }


    public void opensln(){
        Intent intent = new Intent(this, selectsalon.class);
        startActivity(intent);
    }

    public void addData(){

        Appointment appointment = new Appointment(salonEmail,date,selectedTime,mFirebaseAuth.getCurrentUser().getEmail(),salonName,"Customer Name",key);

        mFDb.child("appointment").child(key).setValue(appointment);
        Toast.makeText(this, "Appointment added successfully", Toast.LENGTH_SHORT).show();

        kill_activity();
    }

    public boolean validateData(){
        if(date == null){
            Log.d("Data","Date is null");
            Toast toast= Toast. makeText(EditAppointments.this,"Please Select a Date",Toast. LENGTH_SHORT);
            toast. show();
            return false;
        }else if(selectedTime == null){
            Log.d("Data","Time is null");
            Toast toast= Toast. makeText(EditAppointments.this,"Please Select a Time",Toast. LENGTH_SHORT);
            toast. show();
            return false;
        }else{
            return true;
        }


    }

    public void kill_activity()
    {
        finish();
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
        Common.dashboardOpen(this, Dashboard.class,type);

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