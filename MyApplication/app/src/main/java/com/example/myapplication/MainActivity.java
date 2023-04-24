package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();


         //Code for switching fragments when the Menu button is clicked.
        Button buttonMenu = findViewById(R.id.buttonMenu);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, MenuFragment.class, null)
//                        .setRecordingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        //Code for switching fragments when the Cart button is clicked.
        Button buttonCart = findViewById(R.id.buttonCart);
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, CartFragment.class, null)
//                        .setRecordingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        //Code for switching fragments when the History button is clicked.
        Button buttonHistory = findViewById(R.id.buttonHistory);
        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, HistoryFragment.class, null)
//                        .setRecordingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });
    }
}