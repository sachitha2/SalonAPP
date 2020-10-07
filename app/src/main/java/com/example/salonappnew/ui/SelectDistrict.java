package com.example.salonappnew.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.salonappnew.R;
import com.example.salonappnew.about;
import com.example.salonappnew.common.Common;
import com.example.salonappnew.models.Company;
import com.example.salonappnew.models.District;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SelectDistrict extends AppCompatActivity implements TextWatcher {


    //Find profile data start
    static ImageView imgPropic;
    static TextView txtProfileName;
    static String type;
    //Find profile data end
    DrawerLayout drawerLayout;
    ArrayList<District> myList;
    DistrictListAdapter myAdapter;
    EditText searchCustomers;
    ListView customerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_district);

        //Find profile data start
        imgPropic = findViewById(R.id.imgProfile);
        txtProfileName = findViewById(R.id.txtProfileName);

        Intent intent = getIntent();

        Log.d("Data",   "Intent "+intent.getStringExtra("type"));
        type = intent.getStringExtra("type");
        //Find profile data end

        //nav start
        drawerLayout = findViewById(R.id.drawer_layout);
        //nav end

        searchCustomers = findViewById(R.id.txtsearchCustomers);

        customerList = findViewById(R.id.listDistrict);


        searchCustomers.addTextChangedListener(this);


        myList = new ArrayList<>();
        myList.add(new District("Jaffna"));
        myList.add(new District("Kilinochchi"));
        myList.add(new District("Mannar"));
        myList.add(new District("Mullaitivu"));
        myList.add(new District("Vavuniya"));
        myList.add(new District("Puttalam"));
        myList.add(new District("Kurunegala"));
        myList.add(new District("Gampaha"));
        myList.add(new District("Colombo"));
        myList.add(new District("Kalutara"));
        myList.add(new District("Anuradhapura"));
        myList.add(new District("Polonnaruwa"));
        myList.add(new District("Matale"));
        myList.add(new District("Kandy"));
        myList.add(new District("Nuwara Eliya"));
        myList.add(new District("Kegalle"));

        myList.add(new District("Trincomalee"));
        myList.add(new District("Batticaloa"));
        myList.add(new District("Ampara"));
        myList.add(new District("Badulla"));
        myList.add(new District("Monaragala"));
        myList.add(new District("Hambantota"));
        myList.add(new District("Matara"));
        myList.add(new District("Galle"));




        myAdapter = new DistrictListAdapter(SelectDistrict.this,myList);

        customerList.setAdapter(myAdapter);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        this.myAdapter.getFilter().filter(charSequence);
    }

    @Override
    public void afterTextChanged(Editable editable) {

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