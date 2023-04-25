package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        donutFragment(fragmentManager);

        //Code for switching fragments when the Coffee button is clicked.
        coffeeFragment(fragmentManager);

        //Code for switching fragments when the Cart button is clicked.
        cartFragment(fragmentManager);

        //Code for switching fragments when the History button is clicked.
        historyFragment(fragmentManager);
    }

    private void historyFragment(FragmentManager fragmentManager) {
        Button buttonHistory = findViewById(R.id.buttonHistory);
        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HistoryFragment historyFragment = new HistoryFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, historyFragment, null)
                        .addToBackStack("name")
                        .commit();
                historyFragment.setMainActivity(MainActivity.this);
            }
        });
    }

    private void cartFragment(FragmentManager fragmentManager) {
        Button buttonCart = findViewById(R.id.buttonCart);
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartFragment cartFragment = new CartFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, cartFragment, null)
                        .addToBackStack("name")
                        .commit();
                cartFragment.setMainActivity(MainActivity.this);
            }
        });
    }

    private void coffeeFragment(FragmentManager fragmentManager) {
        Button buttonCoffee = findViewById(R.id.buttonCoffee);
        buttonCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CoffeeFragment coffeeFragment = new CoffeeFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, coffeeFragment, null)
                        .addToBackStack("name")
                        .commit();
                coffeeFragment.setMainActivity(MainActivity.this);
            }
        });
    }

    private void donutFragment(FragmentManager fragmentManager) {
        Button buttonDonut = findViewById(R.id.buttonDonut);
        buttonDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DonutFragment donutFragment = new DonutFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, donutFragment, null)
                        .addToBackStack("name")
                        .commit();
                donutFragment.setMainActivity(MainActivity.this);
            }
        });
    }
}