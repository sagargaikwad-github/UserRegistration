package com.example.userregistration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity3 extends AppCompatActivity {
    EditText name,email,password,phone;
    Button btn;
    String Name,Email,Password,Phone;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        name=findViewById(R.id.name3);
        email=findViewById(R.id.email3);
        password=findViewById(R.id.password3);
        phone=findViewById(R.id.phone3);
        btn=findViewById(R.id.register3);


        Name=name.getText().toString();
        Email=email.getText().toString().trim();
        Phone=phone.getText().toString().trim();
        Password=password.getText().toString().trim();

        SharedPreferences sharedPreferences=getSharedPreferences("Register",MODE_PRIVATE);
        //SharedPreferences sharedPreferences=getSharedPreferences("Reg",MODE_PRIVATE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name=name.getText().toString();
                Email=email.getText().toString().trim();
                Phone=phone.getText().toString().trim();
                Password=password.getText().toString().trim();


                if(Name.isEmpty())
                {
                    name.setError("Can't Empty");
                    name.requestFocus();
                }
                else if(Email.isEmpty())
                {
                    email.setError("Can't Empty");
                    email.requestFocus();
                }
                else if(Phone.isEmpty())
                {
                    phone.setError("Can't Empty");
                    phone.requestFocus();
                }
                else if(Password.isEmpty())
                {
                    password.setError("Can't Empty");
                    password.requestFocus();
                }
                else
                {
                    emailvalid();
                }

                SharedPreferences.Editor myEdit=sharedPreferences.edit();
                myEdit.putString("Name",Name);
                myEdit.putString("Email",Email);
                myEdit.putString("Phone",Phone);
                myEdit.putString("Password",Password);
                myEdit.apply();




            }

            private void emailvalid() {
                    if(Patterns.EMAIL_ADDRESS.matcher(Email).matches())
                    {
                        phonevalid();
                    }
                    else
                    {
                        email.setError("Invalid Email");
                        email.requestFocus();
                    }
            }

            private void phonevalid()
            {
                if(Patterns.PHONE.matcher(Phone).matches() && Phone.length()>9 && Phone.length()<11)
                {
                    Intent intent=new Intent(MainActivity3.this, MainActivity2.class);
                    intent.putExtra("Name",String.valueOf(Name));
                    intent.putExtra("Email",String.valueOf(Email));
                    intent.putExtra("Phone",String.valueOf(Phone));
                    startActivity(intent);

                    name.setText("");
                    email.setText("");
                    phone.setText("");
                    password.setText("");
                    name.requestFocus();

                }
                else
                {
                    phone.setError("Invalid Phone");
                    phone.requestFocus();
                }
            }

        });

        SharedPreferences get=getSharedPreferences("Register",MODE_PRIVATE);
        String e1=get.getString("Name","");
        String e2=get.getString("Email","");
        String e3=get.getString("Phone","");
        String e4=get.getString("Password","");

        name.setText(e1);
        email.setText(e2);
        phone.setText(e3);
        password.setText(e4);


       if(!e1.equals("") && !e2.equals(" "))
       {
           Intent intent2=new Intent(MainActivity3.this,MainActivity2.class);
           startActivity(intent2);
       }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}

