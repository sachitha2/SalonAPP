package com.example.salonappnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addcustomer extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcustomer);

        button = (Button) findViewById(R.id.btn_sub1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCus1();
            }
        });


    }
    public void openCus1(){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}