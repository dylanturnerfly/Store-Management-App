package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

import StoreManager.MenuItem;
import StoreManager.Order;
import StoreManager.OrderHistory;

public class MainActivity extends AppCompatActivity {
    public static OrderHistory orderHistory;
    public static int orderNumberGlobal;
    public static Order currentOrderGlobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderHistory = new OrderHistory();
        orderNumberGlobal = 1;
        currentOrderGlobal = new Order(orderNumberGlobal);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Code for switching fragments when the Donut button is clicked.
        Button buttonDonut = findViewById(R.id.buttonDonut);
        buttonDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, DonutFragment.class, null)
                        .addToBackStack("name")
                        .commit();
            }
        });

        //Code for switching fragments when the Coffee button is clicked.
        Button buttonCoffee = findViewById(R.id.buttonCoffee);
        buttonCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, CoffeeFragment.class, null)
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
                        .addToBackStack("name")
                        .commit();
            }
        });
    }
}