package com.bido.courses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button loginbtn, signupbtn;
    TextInputEditText emailtxt ,passwordtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        loginbtn= findViewById(R.id.button);
        signupbtn= findViewById(R.id.button2);
        emailtxt= findViewById(R.id. email);
        passwordtxt= findViewById(R.id.password);
        loginbtn.setOnClickListener(view -> Login());
        signupbtn.setOnClickListener(view -> signup());


    }



    private void Login(){

        startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
    }
    private void signup(){


        String email = emailtxt.getText().toString().trim();
        String password = passwordtxt.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(SignUpActivity.this, "register", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUpActivity.this,MainActivity.class));

                    }else {
                        Toast.makeText(SignUpActivity.this, "email or password not successful", Toast.LENGTH_SHORT).show();

                    }
                });
    }
}