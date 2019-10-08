package com.example.synd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.synd.Admin.Admin_recyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Map;
import java.util.Objects;

public class Choose extends AppCompatActivity {
Button btn1,btn2;

FirebaseAuth firebaseAuth;
FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();

        if(firebaseUser!=null){
            Toast.makeText(Choose.this,"onComplete",Toast.LENGTH_LONG).show();

            Intent i=new Intent(Choose.this,Speech.class);
            startActivity(i);

        }
        btn1 =(Button)findViewById(R.id.user);
        btn2=(Button)findViewById(R.id.admin);
        SharedPreferences sharedPreferences = getSharedPreferences("who", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("1", "1");

                editor.apply();

                Intent intent1=new Intent(Choose.this, s_login.class);
                startActivity(intent1);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("2", "2");

                editor.apply();


                Intent intent1=new Intent(Choose.this, MainActivity.class);
                startActivity(intent1);

            }
        });

    }
}
