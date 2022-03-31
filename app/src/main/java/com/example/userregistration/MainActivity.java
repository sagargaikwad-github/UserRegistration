package com.example.userregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText fname,lname,email,password,phone,address;
    Button btn;
    String Firstname,Lastname,Email,Password,Phone,Address;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname=findViewById(R.id.fname);
        lname=findViewById(R.id.lname);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password_layout);
        phone=findViewById(R.id.phone);
        address=findViewById(R.id.address);
        btn=findViewById(R.id.btn);

         Firstname=fname.getText().toString();
         Lastname=lname.getText().toString();
         Email=email.getText().toString().trim();
         Password=password.getText().toString();
         Phone=phone.getText().toString();
         Address=address.getText().toString();


       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               checkempty();
           }
       });


    }

    private void checkempty() {
        Firstname=fname.getText().toString();
        Lastname=lname.getText().toString();
        Email=email.getText().toString();
        Password=password.getText().toString();
        Phone=phone.getText().toString();
        Address=address.getText().toString();

        if(Firstname.isEmpty())
        {
            fname.setError("Error");
            fname.requestFocus();
        }else if(Lastname.isEmpty())
        {
            lname.setError("Error");
            lname.requestFocus();
        }
//        else if(Email.isEmpty())
//        {
//           email.setError("Error");
//           email.requestFocus();
//        }
        else if(Password.isEmpty())
        {
            password.setError("Error");
            password.requestFocus();
        }else if(Phone.isEmpty())
        {
            phone.setError("Error");
            phone.requestFocus();
        }
//        else if(Address.isEmpty())
//        {
//            address.setError("Error");
//            address.requestFocus();
//        }
        else
        {
            validateemail();

        }


        }

    private void validatephone()
    {
        if (!Phone.isEmpty() && Phone.length()>9 && Phone.length()<=10) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("Firstname", String.valueOf(Firstname));
            intent.putExtra("Lastname", String.valueOf(Lastname));
            intent.putExtra("Phone", String.valueOf(Phone));
            startActivity(intent);

            fname.setText("");
            lname.setText("");
            email.setText("");
            phone.setText("");
            password.setText("");
            address.setText("");
        }
        else {
            phone.setError("invalid Phone Number");
            phone.requestFocus();

        }

    }

    private void validateemail() {
        if (Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
//            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//            intent.putExtra("Firstname", String.valueOf(Firstname));
//            intent.putExtra("Lastname", String.valueOf(Lastname));
//            intent.putExtra("Email", String.valueOf(Email));
////            intent.putExtra("LastName",Lastname);
////            intent.putExtra("Email",Email);
//            startActivity(intent);
//
//            fname.setText("");
//            lname.setText("");
//            email.setText("");
//            phone.setText("");
//            password.setText("");
//            address.setText("");

        }
        else
        {
            validatephone();
        }
    }


}

