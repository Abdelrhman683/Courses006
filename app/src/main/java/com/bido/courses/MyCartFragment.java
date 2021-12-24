package com.bido.courses;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MyCartFragment extends Fragment {

    Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
           View v =      inflater.inflate(R.layout.fragment_my_cart, container, false);
        btn =v.findViewById(R.id.button14);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_myCartFragment_to_confirmPaymentFragment);


            } });

        return v;
    }
}