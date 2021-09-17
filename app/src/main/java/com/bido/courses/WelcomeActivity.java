package com.bido.courses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {
    Button loginbtn,signupbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);
        loginbtn =findViewById(R.id.button3);
        signupbtn =findViewById(R.id.button4);

        loginbtn.setOnClickListener(view -> login());
        signupbtn.setOnClickListener(view -> signup());


    }
    private void login(){


        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
    }



    private void signup(){


        startActivity(new Intent(WelcomeActivity.this,SignUpActivity.class));
    }



}