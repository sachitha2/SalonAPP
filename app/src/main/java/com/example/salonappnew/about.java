package com.example.salonappnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.salonappnew.common.Common;
import com.example.salonappnew.ui.Dashboard;

public class about extends AppCompatActivity {

    //Find profile data start
    static ImageView imgPropic;
    static TextView txtProfileName;
    static String type;
    //Find profile data end
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //Find profile data start
        imgPropic = findViewById(R.id.imgProfile);
        txtProfileName = findViewById(R.id.txtProfileName);

        Intent intent = getIntent();
        Log.d("Data",   "Intent select a salon "+intent.getStringExtra("type"));
//        type = intent.getStringExtra("type");

        //Find profile data end

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
        //Find profile data start
        Common.findProfileImg(imgPropic,type,txtProfileName);
        //Find profile data end
    }

    public void ClickMenu(View view){
        drawer.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        drawer.closeDrawer(drawerLayout);
    }
    public void ClickDashboard(View view){
        Common.dashboardOpen(this,Dashboard.class,"CUSTOMER");
    }
    public void ClickAboutUs(View view){

    }
    public void ClickLogout(View view){
        Common.logout(this);
    }
    @Override
    protected void onPause(){
        super.onPause();
        drawer.closeDrawer(drawerLayout);
    }
}