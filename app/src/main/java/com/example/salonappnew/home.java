package com.example.salonappnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salonappnew.common.Common;


public class home extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView textView, textView1, textView2, textView3, textView4, textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawer_layout);

        textView = (TextView) findViewById(R.id.txt_appointment);
        textView1 = (TextView) findViewById(R.id.txt_notification1);
        textView2 = (TextView) findViewById(R.id.txt_offer);
        textView3 = (TextView) findViewById(R.id.txt_news);
        textView4 = (TextView) findViewById(R.id.txt_product);
        textView5 = (TextView) findViewById(R.id.txt_profile);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

    public void ClickMenu(View view){
        drawer.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
      drawer.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        drawer.redirectActivity(this,drawer.class);
    }
    public void ClickDashboard(View view){
        recreate();
    }
    public void ClickAboutUs(View view){
        drawer.redirectActivity(this,about.class);
    }
    public void ClickLogout(View view){
        Common.logout(this);;
    }
    @Override
    protected void onPause(){
        super.onPause();
        drawer.closeDrawer(drawerLayout);
    }
}