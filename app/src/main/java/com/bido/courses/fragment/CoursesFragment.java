package com.bido.courses.fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bido.courses.R;

public class CoursesFragment extends Fragment {
    CardView btn3,btn8,btn4,btn5,btn6,btn7;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View v = inflater.inflate(R.layout.fragment_courses, container, false);


        btn3 =v.findViewById(R.id.cardView6);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_courses_to_myCartFragment);


            } });

        btn8 =v.findViewById(R.id.cardView8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_courses_to_myCartFragment);


            } });  btn4 =v.findViewById(R.id.cardView4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_courses_to_myCartFragment);


            } });  btn5 =v.findViewById(R.id.cardView9);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_courses_to_myCartFragment);


            } });  btn6 =v.findViewById(R.id.cardView5);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_courses_to_myCartFragment);


            } });
        btn7 =v.findViewById(R.id.cardView7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_courses_to_myCartFragment);


            } });

        return v;
    }
}