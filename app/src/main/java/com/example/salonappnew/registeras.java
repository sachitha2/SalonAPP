package com.example.salonappnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registeras extends AppCompatActivity {
    private Button button, button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeras);

        button = (Button) findViewById(R.id.btn_cus);
        button1 = (Button) findViewById(R.id.btn_com);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCus();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCom();
            }
        });
    }
    public void openCus(){
        Intent intent = new Intent(this, addcustomer.class);
        startActivity(intent);
    }
    public void openCom(){
        Intent intent = new Intent(this, addcompany.class);
        startActivity(intent);
    }

}