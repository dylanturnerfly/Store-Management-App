package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DonutFragment extends Fragment {
    MainActivity mainActivity;
    RecyclerView recycler;
    private ArrayList<Item> items = new ArrayList<>();
    private int [] itemImages = {R.drawable.tunadonut, R.drawable.mintdonut, R.drawable.spacedonut,
            R.drawable.susdonut, R.drawable.tsaucedonut, R.drawable.glowdonut, R.drawable.strawbaybi,
            R.drawable.chocolate, R.drawable.mac, R.drawable.cat, R.drawable.dog, R.drawable.banana};


    public DonutFragment() {
        // Required empty public constructor (???)
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_donut, container, false);
        recycler = view.findViewById(R.id.recyclerView);
        setupMenuItems(); //add the list of items to the ArrayList
        ItemsAdapter adapter = new ItemsAdapter(mainActivity, view.getContext(), items); //create the adapter
        recycler.setAdapter(adapter); //bind the list of items to the RecyclerView
        recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }

    /**
     * Helper method to set up the data (the Model of the MVC).
     */
    private void setupMenuItems() {
        String [] itemNames = getResources().getStringArray(R.array.donut_flavors);
        String [] itemPrices = getResources().getStringArray(R.array.donut_prices);
        for (int i = 0; i < itemNames.length; i++) {
            items.add(new Item(itemNames[i], itemImages[i], itemPrices[i]));
        }
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
}