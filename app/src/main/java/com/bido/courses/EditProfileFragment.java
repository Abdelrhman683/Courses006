package com.bido.courses;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;



import com.bido.courses.firebase.UserData;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.HashMap;



public class EditProfileFragment extends Fragment {
    EditText profile_frist_name,profile_last_name,profile_email;
    Button profile_bt_update;
    String uid;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_edit_profile, container, false);
        profile_frist_name=view.findViewById(R.id.profile_frist_name);
        profile_last_name=view.findViewById(R.id.profile_last_name);
        profile_email=view.findViewById(R.id.profile_email);
        profile_bt_update=view.findViewById(R.id.button16);
        uid = firebaseAuth.getCurrentUser().getUid();
        getuserdata();
        profile_bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateUsername();
            }
        });
        return  view;
    }


    private void updateUsername() {
        String fname=profile_frist_name.getText().toString().trim();
        String lname=profile_last_name.getText().toString().trim();

        if (fname.isEmpty()||lname.isEmpty()){
            Toast.makeText(getActivity(), "Please write your name", Toast.LENGTH_SHORT).show();
            profile_frist_name.setError("Frist Name required");
            profile_last_name.setError("last Name required");

            return;

        }
        HashMap<String, Object> firstnameMap = new HashMap<>();
        firstnameMap.put("fname", fname);
        firestore.collection("Account").document(uid)
                .update(firstnameMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getActivity(), "profile is update", Toast.LENGTH_SHORT).show();
                } else {
                    String errorMassae = task.getException().getLocalizedMessage();
                    Toast.makeText(getActivity(), errorMassae, Toast.LENGTH_SHORT).show();

                }
            }
        });
        HashMap<String, Object> lastnameMap = new HashMap<>();
        lastnameMap.put("lname", lname);
        firestore.collection("Account").document(uid)
                .update(lastnameMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {


                } else {
                    String errorMassae = task.getException().getLocalizedMessage();
                    Toast.makeText(getActivity(), errorMassae, Toast.LENGTH_SHORT).show();

                }
            }
        });




    }

    private void updateUI(UserData userData) {
        profile_frist_name.setText(userData.getFname());
        profile_last_name.setText(userData.getLname());
        profile_email.setText(userData.getEmail());


    }
    private void getuserdata() {

        firestore.collection("Account")
                .document(uid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {

                    UserData userData = task.getResult().toObject(UserData.class);
                    updateUI(userData);

                } else {
                    String errorMassae = task.getException().getLocalizedMessage();
                    Toast.makeText(getActivity(), errorMassae, Toast.LENGTH_SHORT).show();


                }

            }
        });
    }

}