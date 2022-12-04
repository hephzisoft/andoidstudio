package com.hephzisoft.eccomerce;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Cart extends Fragment {


    public Cart() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    ListView product_lists;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);


        return view;
    }

}

class CartAdapter extends BaseAdapter {
    Context context;

    public CartAdapter(Context context, ArrayList<Integer> images, ArrayList<String> name, ArrayList<String> price, ArrayList<String> description) {
        this.context = context;
        this.images = images;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    LayoutInflater inflater;
    ArrayList<Integer> images;
    ArrayList<String> name,price,description;

    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}