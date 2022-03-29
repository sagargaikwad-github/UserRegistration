package com.example.userregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView name,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name=findViewById(R.id.w1);
        email=findViewById(R.id.email2);
        phone=findViewById(R.id.phone2);

//        Bundle bundle=getIntent().getExtras();
//        String s=bundle.getString("Name");
//        String t=bundle.getString("Email");
//        String u=bundle.getString("Phone");
//


        Bundle bundle=getIntent().getExtras();
        String s=bundle.getString("Name");
        String t=bundle.getString("Email");
        String u=bundle.getString("Phone");

        name.setText("Welcome, "+s);
        email.setText("Email : "+t);
        phone.setText("Phone : "+u);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}