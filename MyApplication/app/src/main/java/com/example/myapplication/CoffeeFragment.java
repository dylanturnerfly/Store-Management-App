package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

public class CoffeeFragment extends Fragment {
    private MainActivity mainActivity;
    CheckBox sweetCream, frenchVanilla, irishCream, caramel, mocha;

    public CoffeeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void setMochaButtonOnClick(View view) {
        sweetCream = view.findViewById(R.id.buttonHistory);
        sweetCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setCaramelButtonOnClick(View view) {
        sweetCream = view.findViewById(R.id.buttonHistory);
        sweetCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setIrishButtonOnClick(View view) {
        sweetCream = view.findViewById(R.id.buttonHistory);
        sweetCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setFrenchButtonOnClick(View view) {
        sweetCream = view.findViewById(R.id.buttonHistory);
        sweetCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setSweetButtonOnClick(View view) {
        sweetCream = view.findViewById(R.id.buttonHistory);
        sweetCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_coffee, container, false);
        setSweetButtonOnClick(view);
        setFrenchButtonOnClick(view);
        setIrishButtonOnClick(view);
        setCaramelButtonOnClick(view);
        setMochaButtonOnClick(view);
        return view;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
}