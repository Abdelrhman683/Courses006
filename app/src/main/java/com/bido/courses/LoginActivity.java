package com.bido.courses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button loginbtn, signupbtn;
    TextInputEditText emailtxt ,passwordtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        //getSupportActionBar().setTitle("login");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        loginbtn =findViewById(R.id.button2);

        signupbtn= findViewById(R.id.button);
        emailtxt= findViewById(R.id. email);
        passwordtxt= findViewById(R.id.password);

        loginbtn.setOnClickListener(view -> login());
        signupbtn.setOnClickListener(view -> singup());

    }

    private void login(){



        String email = emailtxt.getText().toString().trim();
        String password = passwordtxt.getText().toString().trim();


        if (email.isEmpty()){
emailtxt.setError("Enter email");
return;
        }


        if (password.isEmpty()){
            passwordtxt.setError("Enter Password");
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "register", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));

                    }else {
                        Toast.makeText(LoginActivity.this, "email or password not successful", Toast.LENGTH_SHORT).show();

                    }
                });
    }
    private void singup(){
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }
}