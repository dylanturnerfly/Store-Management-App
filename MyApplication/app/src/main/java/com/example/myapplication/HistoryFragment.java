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
import android.widget.ListView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

import StoreManager.Flavors;
import StoreManager.MenuItem;
import StoreManager.Order;
import StoreManager.OrderHistory;

public class HistoryFragment extends Fragment implements AdapterView.OnItemClickListener {

    private MainActivity mainActivity;
    private ListView listView;
    private ObservableArrayList<String> list;
    ArrayAdapter<String> orders;
    private final Flavors[] donutTypes = {Flavors.Tuna,Flavors.Mint,Flavors.Space,Flavors.Sus,
            Flavors.Tomato,Flavors.Glowstone,Flavors.Strawberry,Flavors.Chocolate,
            Flavors.MacnCheese,Flavors.Cat,Flavors.Dog,Flavors.Banana};

    public HistoryFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_history, container, false);
        listView = view.findViewById(R.id.historyListView);
        list = new ObservableArrayList<>();
        //The statement below create an adapter for the ListView and set the data source to the
        //ObservableList.
        orders = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(orders); //set the adapter of the ListView to the source
        listView.setOnItemClickListener(this); //add a listener to the ListView
        updateList();
        return view;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void updateList(){
        OrderHistory history = mainActivity.getOrderHistory();
        ArrayList<String> coffeeTypes = new ArrayList<>();
        for(Order order: history.getOrders()){
            coffeeTypes.clear();
            String output = "Order #" + order.getOrderNumber();
            for (MenuItem item : order.getMenuItems()) {
                if (item.getType().equals("Coffee")) {
                    int count = 0;
                    for (MenuItem item2 : order.getMenuItems()) {
                        if (item.equals(item2) && !coffeeTypes.contains(item.toString())) {
                            count++;
                        }
                    }
                    coffeeTypes.add(item.toString());
                    if (count != 0)
                        output = output + "\n" + item + " (" + count + ")" + " $" + formatDouble(item.itemPrice() * count);
                }
            }
            for (Flavors donutType : donutTypes) {
                int count = 0;
                double price = 0;
                for (MenuItem donut : order.getMenuItems()) {
                    if (donut.toString().equals(donutType.toString())) {
                        count++;
                        price += donut.itemPrice();
                    }
                }
                if (count != 0)
                    output = output + "\n" + donutType + donutType.getDonutType() + " (" + count + ")" + " $" + formatDouble(price);
            }
            double total = 0;
            for(MenuItem item : order.getMenuItems()) {
                total += item.itemPrice();
            }
            double salesTax = total * 0.06625;
            double totalWithSales = salesTax + total;
            output = output + "\nOrder total: $" + formatDouble(totalWithSales) + " Subtotal: $" + formatDouble(total) + " Tax: $" + formatDouble(salesTax);
            list.add(output);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        OrderHistory history = mainActivity.getOrderHistory();
        AlertDialog.Builder alert = new AlertDialog.Builder(adapterView.getContext());
        alert.setTitle("Remove from Order History");
        alert.setMessage("Remove Order #" + history.getOrders().get(i).getOrderNumber() + "?");
        //handle the "YES" click
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(adapterView.getContext(), "Order #" + history.getOrders().get(i).getOrderNumber() + " removed.", Toast.LENGTH_SHORT).show();
                history.cancelOrder(history.getOrders().get(i).getOrderNumber());
                list.remove(list.get(i));
                orders.notifyDataSetChanged();
            }
            //handle the "NO" click
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(adapterView.getContext(), "Order #" + history.getOrders().get(i).getOrderNumber()+ " not removed.", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
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

}