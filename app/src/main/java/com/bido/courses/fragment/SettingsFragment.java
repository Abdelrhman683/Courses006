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


public class SettingsFragment extends Fragment {

    Button btn,btn2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View v =   inflater.inflate(R.layout.fragment_setting, container, false);


        btn2 =v.findViewById(R.id.button8);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavDirections action =
                        SettingsFragmentDirections
                                .actionSpecifyAmountFragmentToConfirmationFragment();
                Navigation.findNavController(view).navigate(action);


            } });


        return v;

    }
}