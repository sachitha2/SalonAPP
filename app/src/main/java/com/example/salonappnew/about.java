package com.example.salonappnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

import com.example.salonappnew.ui.Dashboard;

public class about extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        drawerLayout = findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view){
        drawer.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        drawer.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        drawer.redirectActivity(this, Dashboard.class);
    }
    public void ClickDashboard(View view){
        drawer.redirectActivity(this,Dashboard.class);
    }
    public void ClickAboutUs(View view){

    }
    public void ClickLogout(View view){
        drawer.logout(this);
    }
    @Override
    protected void onPause(){
        super.onPause();
        drawer.closeDrawer(drawerLayout);
    }
}