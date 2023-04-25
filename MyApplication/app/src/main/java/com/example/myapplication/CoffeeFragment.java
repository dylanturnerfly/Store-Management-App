package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import java.util.ArrayList;

import StoreManager.Coffee;

public class CoffeeFragment extends Fragment {
    private MainActivity mainActivity;
    CheckBox sweetCream, frenchVanilla, irishCream, caramel, mocha;
    Button addButton;
    Spinner sizeSpinner;

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
                update(false);
            }
        });
    }

    private void setCaramelButtonOnClick(View view) {
        sweetCream = view.findViewById(R.id.buttonHistory);
        sweetCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(false);
            }
        });
    }

    private void setIrishButtonOnClick(View view) {
        sweetCream = view.findViewById(R.id.buttonHistory);
        sweetCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(false);
            }
        });
    }

    private void setFrenchButtonOnClick(View view) {
        sweetCream = view.findViewById(R.id.buttonHistory);
        sweetCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(false);
            }
        });
    }

    private void setSweetButtonOnClick(View view) {
        sweetCream = view.findViewById(R.id.buttonHistory);
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
        if(sizeCombo.getSelectionModel().getSelectedItem() == null || quantityCombo.getSelectionModel().getSelectedItem() == null){
            invalidSelectionMessage();
            return;
        }
        int quantity = Integer.parseInt(quantityCombo.getSelectionModel().getSelectedItem());
        for(int i = 0; i < quantity; i++) {
            createCoffee(quantity,add);
        }
        if(add){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Added items to Cart.");
            alert.showAndWait();
        }
    }

    /**
     * Displays invalid selection error pop up.
     */
    private void invalidSelectionMessage(){

    }

    /**
     * Helper method for update(), creates the
     * desired quantities of the selected coffee.
     * @param quantity quantity of type.
     * @param add whether to add to cart.
     */
    private void createCoffee(int quantity,boolean add) {
        ArrayList<String> addIns = new ArrayList<>();
        if(sweetButton.isSelected()){
            addIns.add("Sweet");
        }
        if(mochaButton.isSelected()){
            addIns.add("Mocha");
        }
        if(vanillaButton.isSelected()){
            addIns.add("Vanilla");
        }
        if(caramelButton.isSelected()){
            addIns.add("Caramel");
        }
        if(irishButton.isSelected()){
            addIns.add("Irish");
        }
        Coffee newCoffee = new Coffee(sizeCombo.getSelectionModel().getSelectedItem(),addIns);
        updateCartTotal(newCoffee,quantity,add);
    }

    /**
     * Updates the total price of all
     * items currently in the cart.
     */
    private void updateCartTotal(Coffee newCoffee, int quantity,boolean add) {
        double total = 0;
        total += quantity * newCoffee.itemPrice();
        String totalString = formatDouble(total);
        totalField.setText(("$" + totalString));
        if(add){
            total += mainController.getCurrentOrder().getCurrentTotal();
            mainController.getCurrentOrder().setCurrentTotal(total);
            mainController.getCurrentOrder().addItem(newCoffee);

        }
    }
}