package com.example.salonappnew;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class addapoint extends AppCompatActivity {

    private Button btn;
    Button btn_date;
    TextView tvTimer2;
    int t2Hour,t2Minute;

    private static final String TAG = "addapoint";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mdDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addapoint);

        btn = (Button) findViewById(R.id.btn_sln);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensln();
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
                        addapoint.this,
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

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        tvTimer2 = findViewById(R.id.btn_time);
        tvTimer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addapoint.this,
                        android.R.style.Theme_Material_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t2Hour = hourOfDay;
                                t2Minute = minute;
                                String time = t2Hour +  ":" + t2Minute;
                                @SuppressLint("SimpleDateFormat") SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);

                                    @SuppressLint("SimpleDateFormat") SimpleDateFormat f12Hourse = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    assert date != null;
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

}