package com.bido.courses.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bido.courses.R;


public class ProfileFragment extends Fragment {


    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_profile, container, false);



        textView=v.findViewById(R.id.textView62);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        Navigation.findNavController(view).navigate(R.id.action_navigation_profile_to_editProfileFragment);


        }


        });



        return v;
    }
}