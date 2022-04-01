package com.example.userregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    TextView user,pass;
    Button login;
    TextView newuser;
    int log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user=findViewById(R.id.username);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.login_button);
        newuser=findViewById(R.id.newregister);


        SharedPreferences sharedPreferences=getSharedPreferences("Register",MODE_PRIVATE);
        String log_username=sharedPreferences.getString("Name"," ");
        String log_password=sharedPreferences.getString("Password"," ");
        String log_email=sharedPreferences.getString("Email"," ");





//        String e=user.getText().toString();
//        String p=pass.getText().toString();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e=user.getText().toString().trim();
                String p=pass.getText().toString().trim();

                SharedPreferences islogin=getSharedPreferences("Login",MODE_PRIVATE);
                SharedPreferences.Editor editor=islogin.edit();
                editor.putString("login","LOGIN");
                editor.apply();

                if(e.equals(log_email) && p.equals(log_password))
                {
                    Intent intent=new Intent(LoginActivity.this,MainActivity2.class);
                    startActivity(intent);
                }
                else if(e.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Please provide username and password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Please provide username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              SharedPreferences.Editor newedit=sharedPreferences.edit();
              newedit.putString("Name","");
              newedit.putString("Email","");
              newedit.putString("Phone","");
              newedit.putString("Password","");
              newedit.apply();

                Intent register=new Intent(LoginActivity.this,MainActivity3.class);
                startActivity(register);



            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}