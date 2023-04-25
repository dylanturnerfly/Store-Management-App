package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * This is an Adapter class to be used to instantiate an adapter for the RecyclerView.
 * Must extend RecyclerView.Adapter, which will enforce you to implement 3 methods:
 *      1. onCreateViewHolder, 2. onBindViewHolder, and 3. getItemCount
 *
 * You must use the data type <thisClassName.yourHolderName>, in this example
 * <ItemAdapter.ItemHolder>. This will enforce you to define a constructor for the
 * ItemAdapter and an inner class ItemsHolder (a static class)
 * The ItemsHolder class must extend RecyclerView.ViewHolder. In the constructor of this class,
 * you do something similar to the onCreate() method in an Activity.
 * @author Lily Chang
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsHolder> {
    private Context context; //need the context to inflate the layout
    private ArrayList<Item> items; //need the data binding to each row of RecyclerView
    private static ArrayList<Integer> quantities;

    public ItemsAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
        quantities = new ArrayList<>();
        for(int i = 0; i < getItemCount(); i++){
            quantities.add(0);
        }
    }

    /**
     * This method will inflate the row layout for the items in the RecyclerView
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the row layout for the items
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_row, parent, false);

        return new ItemsHolder(view);
    }

    /**
     * Assign data values for each row according to their "position" (index) when the item becomes
     * visible on the screen.
     *
     * @param holder   the instance of ItemsHolder
     * @param position the index of the item in the list of items
     */
    @Override
    public void onBindViewHolder(@NonNull ItemsHolder holder, int position) {
        holder.tv_name = items.get(position).getItemName();
        holder.tv_price.setText(items.get(position).getUnitPrice());
        holder.im_item.setImageResource(items.get(position).getImage());

        holder.position = holder.getAdapterPosition();
        holder.quantityField.setText(Integer.toString(quantities.get(position)));

    }

    /**
     * Get the number of items in the ArrayList.
     *
     * @return the number of items in the list.
     */
    @Override
    public int getItemCount() {
        return items.size(); //number of MenuItem in the array list.
    }

    /**
     * Get the views from the row layout file, similar to the onCreate() method.
     */
    public static class ItemsHolder extends RecyclerView.ViewHolder {
        private String tv_name;
        private int position;
        private TextView tv_price, quantityField;
        private ImageView im_item;
        private Button btn_add;
        private Button quantityUp;
        private Button quantityDown;
        private ConstraintLayout parentLayout; //this is the row layout

        public ItemsHolder(@NonNull View itemView) {
            super(itemView);
            tv_price = itemView.findViewById(R.id.donutPrice);
            quantityField = itemView.findViewById(R.id.quantityField);
            im_item = itemView.findViewById(R.id.imageView);
            btn_add = itemView.findViewById(R.id.addButton);
            quantityUp = itemView.findViewById(R.id.quantityUp);
            quantityDown = itemView.findViewById(R.id.quantityDown);
            parentLayout = itemView.findViewById(R.id.rowLayout);
            setAddButtonOnClick(itemView); //register the onClicklistener for the add button on each row.
            setUpButtonOnClick(itemView);
            setDownButtonOnClick(itemView);
        }

        /**
         * Set the onClickListener for the button on each row.
         * Clicking on the button will create an AlertDialog with the options of YES/NO.
         *
         * @param itemView
         */
        private void setAddButtonOnClick(@NonNull View itemView) {
            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(itemView.getContext());
                    alert.setTitle("Add to order");
                    alert.setMessage(tv_name);
                    //handle the "YES" click
                    alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(itemView.getContext(),
                                    tv_name + " added.", Toast.LENGTH_LONG).show();

                        }
                        //handle the "NO" click
                    }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(itemView.getContext(),
                                    tv_name + " not added.", Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog dialog = alert.create();
                    dialog.show();
                }
            });
        }

        private void setUpButtonOnClick(@NonNull View itemView) {
            quantityUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    quantities.set(position, quantities.get(position)+1);
                    quantityField.setText(Integer.toString(quantities.get(position)));
                }
            });
        }

        private void setDownButtonOnClick(@NonNull View itemView) {
            quantityDown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(quantities.get(position) - 1 >= 0) {
                        quantities.set(position, quantities.get(position)-1);
                        quantityField.setText(Integer.toString(quantities.get(position)));
                    }
                }
            });
        }
    }
}
