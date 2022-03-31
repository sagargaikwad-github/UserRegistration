package com.example.userregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Handler handler=new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getSharedPreferences("Register",MODE_PRIVATE);
                String a=sharedPreferences.getString("Email","");
                String b=sharedPreferences.getString("Password","");

                SharedPreferences islogin=getSharedPreferences("Login",MODE_PRIVATE);
                String n=islogin.getString("login","");
                //Toast.makeText(SplashScreenActivity.this, n, Toast.LENGTH_SHORT).show();
                if(n.equals("LOGIN"))
                {
                    Intent intent=new Intent(SplashScreenActivity.this,MainActivity2.class);
                    startActivity(intent);
                }
                else
                {
                   if(a!="" && !a.isEmpty())
                   {
                    Intent intent=new Intent(SplashScreenActivity.this,LoginActivity.class);
                    startActivity(intent);
                   }
                 else
                  {
                    Intent intent1=new Intent(SplashScreenActivity.this,MainActivity3.class);
                    startActivity(intent1);
                   }
//                    Intent intent=new Intent(SplashScreenActivity.this,LoginActivity.class);
//                    Toast.makeText(SplashScreenActivity.this, "not ok", Toast.LENGTH_SHORT).show();
//                    startActivity(intent);
                }






            }
        },2000);

    }
}