package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import StoreManager.Coffee;

public class CoffeeFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private MainActivity mainActivity;
    CheckBox sweetCream, frenchVanilla, irishCream, caramel, mocha;
    Button addButton;
    Spinner sizeSpinner;
    TextView subtotal;

    public CoffeeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setMochaButtonOnClick(View view) {
        mocha = view.findViewById(R.id.mochaButton);
        mocha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(false);
            }
        });
    }

    private void setCaramelButtonOnClick(View view) {
        caramel = view.findViewById(R.id.caramelButton);
        caramel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(false);
            }
        });
    }

    private void setIrishButtonOnClick(View view) {
        irishCream = view.findViewById(R.id.irishCreamButton);
        irishCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(false);
            }
        });
    }

    private void setFrenchButtonOnClick(View view) {
        frenchVanilla = view.findViewById(R.id.frenchVanillaButton);
        frenchVanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(false);
            }
        });
    }

    private void setSweetButtonOnClick(View view) {
        sweetCream = view.findViewById(R.id.sweetCreamButton);
        sweetCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(false);
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
        setAddButtonOnClick(view);
        subtotal = view.findViewById(R.id.subtotalField);
        sizeSpinner = view.findViewById(R.id.coffeeSizeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),R.array.coffeeSizes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(adapter);
        sizeSpinner.setOnItemSelectedListener(this);
        update(false);
        return view;
    }

    private void setAddButtonOnClick(View view) {
        addButton = view.findViewById(R.id.addOrderButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(true);
            }
        });
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    /**
     * Updates the cart and adds items to check out if
     * called from add method,
     * @param add whether to add items to check out.
     */
    public void update(boolean add) {
        createCoffee(add);
        if(add){
            String text = "Added to Cart";
            Toast.makeText(mainActivity, text, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Helper method for update(), creates the
     * desired quantities of the selected coffee.
     * @param add whether to add to cart.
     */
    private void createCoffee(boolean add) {
        ArrayList<String> addIns = new ArrayList<>();
        if(sweetCream.isChecked()){
            addIns.add("Sweet");
        }
        if(mocha.isChecked()){
            addIns.add("Mocha");
        }
        if(frenchVanilla.isChecked()){
            addIns.add("Vanilla");
        }
        if(caramel.isChecked()){
            addIns.add("Caramel");
        }
        if(irishCream.isChecked()){
            addIns.add("Irish");
        }
        Coffee newCoffee = new Coffee(sizeSpinner.getSelectedItem().toString(),addIns);
        updateCartTotal(newCoffee,add);
    }

    /**
     * Updates the total price of all
     * items currently in the cart.
     */
    private void updateCartTotal(Coffee newCoffee,boolean add) {
        double total = 0;
        total += newCoffee.itemPrice();
        String totalString = formatDouble(total);
        subtotal.setText(("Subtotal: \n$" + totalString));
        if(add){
            total += mainActivity.getCurrentOrder().getCurrentTotal();
            mainActivity.getCurrentOrder().setCurrentTotal(total);
            mainActivity.getCurrentOrder().addItem(newCoffee);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        update(false);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private String formatDouble(double total){
        String pattern = "0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(total);
    }
}