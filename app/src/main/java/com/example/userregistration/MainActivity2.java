package com.example.userregistration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class MainActivity2 extends AppCompatActivity {
    TextView name,email,phone,tv,addphoto;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name=findViewById(R.id.w1);
        email=findViewById(R.id.email2);
        phone=findViewById(R.id.phone2);
        tv=findViewById(R.id.regtv);
        addphoto=findViewById(R.id.addphoto);
        img=findViewById(R.id.img);

//        Bundle bundle=getIntent().getExtras();
//        String s=bundle.getString("Name");;
//        String t=bundle.getString("Email");
//        String u=bundle.getString("Phone");
//
//        name.setText("Welcome, "+s);
//        email.setText("Email : "+t);
//        phone.setText("Phone : "+u);

        SharedPreferences get=getSharedPreferences("Register",MODE_PRIVATE);
        String e1=get.getString("Name"," ");
        String e2=get.getString("Email"," ");
        String e3=get.getString("Phone"," ");

        name.setText("Welcome, "+e1);
        email.setText("Email : "+e2);
        phone.setText("Phone : "+e3);



        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor myEdit=get.edit();
                myEdit.putString("Name","");
                myEdit.putString("Email","");
                myEdit.putString("Phone","");
                myEdit.putString("Password","");
                myEdit.apply();

                Intent intent3=new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent3);

            }
        });

        addphoto.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                    requestPermissions(new String[]{Manifest.permission.CAMERA}, 10);
                } else {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, 1);
                }
            }
        });
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 10)
//        {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
//            {
//                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
//                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(cameraIntent, 1);
//            }
//            else
//            {
//                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
//            }
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==Activity.RESULT_OK)
        {
            Bitmap bitmap= (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(bitmap);

        }
    }

  //  @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1 && resultCode == Activity.RESULT_OK)
//        {
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            img.setImageBitmap(photo);
//
//        }
//    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();



    }
}