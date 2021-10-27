package com.bido.courses.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bido.courses.R;
import com.bido.courses.settings.AboutAppFragment;
import com.bido.courses.settings.AccountSecurityFragment;


public class   SettingsFragment extends Fragment {

    Button btn,btn2,btn3,btn4,btn5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View v =   inflater.inflate(R.layout.fragment_setting, container, false);


        btn2 =v.findViewById(R.id.button8);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_settings_to_aboutAppFragment3);


            } });




        btn3 =v.findViewById(R.id.button5);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_settings_to_emailNotificationFragment);


            } });


        btn4 =v.findViewById(R.id.button6);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_settings_to_pushNotificationFragment);


            } });


        btn5 =v.findViewById(R.id.button10);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_settings_to_contactFragment);


            } });



        btn =v.findViewById(R.id.button7);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_settings_to_accountSecurityFragment);


            } });


        return v;

    }
}