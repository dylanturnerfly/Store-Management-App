package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HistoryFragment extends Fragment {

    private MainActivity mainActivity;

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
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
}

// alert dialog code for "are you sure you want to remove order?"

//    AlertDialog.Builder alert = new AlertDialog.Builder(itemView.getContext());
//                    alert.setTitle("Add to order");
//                            alert.setMessage(tv_name);
//                            //handle the "YES" click
//                            alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
//public void onClick(DialogInterface dialog, int which) {
//        Toast.makeText(itemView.getContext(),
//        tv_name + " added.", Toast.LENGTH_LONG).show();
//
//        }
//        //handle the "NO" click
//        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
//public void onClick(DialogInterface dialog, int which) {
//        Toast.makeText(itemView.getContext(),
//        tv_name + " not added.", Toast.LENGTH_LONG).show();
//        }
//        });
//        AlertDialog dialog = alert.create();
//        dialog.show();