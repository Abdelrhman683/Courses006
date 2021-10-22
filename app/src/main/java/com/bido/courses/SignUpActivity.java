package com.bido.courses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.bido.courses.firebase.UserData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button loginbtn, signupbtn;
    TextInputEditText emailtxt ,passwordtxt,fnametxt,lnametxt;
    String key;
    public static String fname="",lname="", password="",email="";

    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

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
        fnametxt= findViewById(R.id.fname);
        lnametxt= findViewById(R.id.lname);

        loginbtn.setOnClickListener(view -> Login());
        signupbtn.setOnClickListener(view -> signup());


    }



    private void Login(){

        startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
    }
    private void signup(){


        fname = fnametxt.getText().toString().trim();
        lname = lnametxt.getText().toString().trim();
        email = emailtxt.getText().toString().trim();
        password = passwordtxt.getText().toString().trim();
       

        if (password.length()<6){

            Toast.makeText(this, "password should be at least 6 characters", Toast.LENGTH_SHORT).show();
        }
        CreatUserByEmail(email,password);







      
        
    }

    private void CreatUserByEmail(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(SignUpActivity.this, "register", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUpActivity.this,MainActivity.class));


                        String   userUID    = task.getResult().getUser().getUid();


                        upLoadUserData(userUID);

                    }else {
                        Toast.makeText(SignUpActivity.this, "email or password not successful", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void upLoadUserData(String userUID) {


        UserData userData = new UserData(fname,lname,email);
        firebaseFirestore.collection("Account")
                .document(userUID).set(userData)
                .addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(SignUpActivity.this, "user data uploaded", Toast.LENGTH_SHORT).show();
                        } else {
                            String errorMassae = task.getException().getLocalizedMessage();
                            Toast.makeText(SignUpActivity.this, errorMassae, Toast.LENGTH_LONG).show();


                        }
                    }
                });
    }

}