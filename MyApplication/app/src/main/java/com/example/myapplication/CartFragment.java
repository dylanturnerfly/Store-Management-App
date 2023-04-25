package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

import StoreManager.Flavors;
import StoreManager.MenuItem;

public class CartFragment extends Fragment implements AdapterView.OnItemClickListener {

    private MainActivity mainActivity;
    private ListView listView;
    private ObservableArrayList<String> list;
    ArrayAdapter<String> items;
    private final Flavors[] donutTypes = {Flavors.Tuna,Flavors.Mint,Flavors.Space,Flavors.Sus,
            Flavors.Tomato,Flavors.Glowstone,Flavors.Strawberry,Flavors.Chocolate,
            Flavors.MacnCheese,Flavors.Cat,Flavors.Dog,Flavors.Banana};
    TextView subTotal, sales, totalField;
    Button placeOrderButton;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        listView = view.findViewById(R.id.cartListView);
        list = new ObservableArrayList<>();
        //The statement below create an adapter for the ListView and set the data source to the
        //ObservableList.
        items = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(items); //set the adapter of the ListView to the source
        listView.setOnItemClickListener(this); //add a listener to the ListView
        subTotal = view.findViewById(R.id.subtotalCart);
        sales = view.findViewById(R.id.salesFieldCart);
        totalField = view.findViewById(R.id.totalFieldCart);
        updateCheckOut();
        setPlaceButtonOnClick(view);
        return view;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    /**
     * The event Handler for the onItemClick event on the ListView
     * @param adapterView The AdapterView where the click happened.
     * @param view The View within the AdapterView that was clicked (in this example is ListView)
     * @param i the index/position of the view that was clicked in the adapter.
     * @param l the row id (index) of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ArrayList<MenuItem> grabbedOrder = mainActivity.getCurrentOrder().getMenuItems();
        AlertDialog.Builder alert = new AlertDialog.Builder(adapterView.getContext());
        alert.setTitle("Remove from Order");
        alert.setMessage("Remove " + list.get(i) + "?");
        //handle the "YES" click
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(adapterView.getContext(), list.get(i) + " removed.", Toast.LENGTH_LONG).show();
                    String selectedItem = list.get(i);
                    String removeTypeCoffee = selectedItem.substring(0,selectedItem.length()-4);
                    StringTokenizer stringTokenizer = new StringTokenizer(selectedItem);
                    String removeTypeDonut = stringTokenizer.nextToken();
                    grabbedOrder.removeIf(donut -> donut.toString().equals(removeTypeDonut));
                    grabbedOrder.removeIf(donut -> donut.toString().equals(removeTypeCoffee));
                    list.remove(selectedItem);
                    items.notifyDataSetChanged();
                    updateTotal();
            }
                    //handle the "NO" click
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(adapterView.getContext(), list.get(i) + " not removed.", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    /**
     * Updates the list of items in the checkout when called.
     */
    public void updateCheckOut() {
        ArrayList<MenuItem> grabbedOrder = mainActivity.getCurrentOrder().getMenuItems();
        ArrayList<String> coffeeTypes = new ArrayList<>();

        list.clear();
        for (MenuItem item : grabbedOrder) {
            if (item.getType().equals("Coffee")) {
                int count = 0;
                for (MenuItem item2 : grabbedOrder) {
                    if (item.equals(item2) && !coffeeTypes.contains(item.toString())) {
                        count++;
                    }
                }
                coffeeTypes.add(item.toString());
                if (count != 0)
                    list.add(item + " (" + count + ")");
            }
        }
        for (Flavors donutType : donutTypes) {
            int count = 0;
            for (MenuItem donut : grabbedOrder) {
                if (donut.toString().equals(donutType.toString())) {
                    count++;
                }
            }
            if (count != 0)
                list.add(donutType + donutType.getDonutType() + " (" + count + ")");
        }
        updateTotal();
    }

    /**
     * Updates the total amount owed from the cart.
     * Called whenever a button is pressed.
     */
    private void updateTotal() {
        ArrayList<MenuItem> grabbedOrder = mainActivity.getCurrentOrder().getMenuItems();
        double total = 0;
        for(MenuItem item : grabbedOrder) {
            total += item.itemPrice();
        }
        double salesTax = total * 0.06625;
        double totalWithSales = salesTax + total;
        subTotal.setText(("Subtotal: \n $" + formatDouble(total)));
        sales.setText(("Sales Tax: \n $" + formatDouble(salesTax)));
        totalField.setText(("Total: \n $" + formatDouble(totalWithSales)));
    }

    /**
     * Correctly formats the amount due.
     * @param total amount to format
     * @return correctly formated total amount due.
     */
    public String formatDouble(double total){
        String pattern = "0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(total);
    }

    private void setPlaceButtonOnClick(View view) {
        placeOrderButton = view.findViewById(R.id.placeOrderButton);
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(list == null || list.isEmpty()){
                    Toast.makeText(view.getContext(), "Cart is Empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                mainActivity.sendOrder();
                list.clear();
                items.clear();
                subTotal.setText("Subtotal: \n $0.00");
                sales.setText("Sales Tax: \n $0.00");
                totalField.setText("Total: \n $0.00");
                Toast.makeText(view.getContext(), "Order Placed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}