package com.hephzisoft.eccomerce;

import android.content.Context;
import android.content.Intent;
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


public class Store extends Fragment {


    public Store() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        gridView = view.findViewById(R.id.grid);
        int[] item_image = new int[]{R.drawable.free_sample_by_wix_pdwndp, R.drawable.free_sample_by_wix_pdwndp, R.drawable.free_sample_by_wix_pdwndp, R.drawable.free_sample_by_wix_pdwndp, R.drawable.free_sample_by_wix_pdwndp, R.drawable.free_sample_by_wix_pdwndp, R.drawable.free_sample_by_wix_pdwndp};
        String[] item_name = new String[]{"Sneakers", "Canvas", "All Stars", "Air Max", "Nike Air Force", "Jordan", "Hephzisoft"};
        String[] item_description = new String[]{
                "Lorem ipsum dolor sit amet consectetur adipiscing elit, molestie ornare lacus erat quis dictumst fusce luctus, eget platea pharetra posuere scelerisque purus. Inceptos arcu pulvinar hendrerit, pretium sed, magnis diam.",
                "Lorem ipsum dolor sit amet consectetur adipiscing elit, molestie ornare lacus erat quis dictumst fusce luctus, eget platea pharetra posuere scelerisque purus. Inceptos arcu pulvinar hendrerit, pretium sed, magnis diam.",
                "Lorem ipsum dolor sit amet consectetur adipiscing elit, molestie ornare lacus erat quis dictumst fusce luctus, eget platea pharetra posuere scelerisque purus. Inceptos arcu pulvinar hendrerit, pretium sed, magnis diam.",
                "Lorem ipsum dolor sit amet consectetur adipiscing elit, molestie ornare lacus erat quis dictumst fusce luctus, eget platea pharetra posuere scelerisque purus. Inceptos arcu pulvinar hendrerit, pretium sed, magnis diam.",
                "Lorem ipsum dolor sit amet consectetur adipiscing elit, molestie ornare lacus erat quis dictumst fusce luctus, eget platea pharetra posuere scelerisque purus. Inceptos arcu pulvinar hendrerit, pretium sed, magnis diam.",
                "Lorem ipsum dolor sit amet consectetur adipiscing elit, molestie ornare lacus erat quis dictumst fusce luctus, eget platea pharetra posuere scelerisque purus. Inceptos arcu pulvinar hendrerit, pretium sed, magnis diam.",
                "Lorem ipsum dolor sit amet consectetur adipiscing elit, molestie ornare lacus erat quis dictumst fusce luctus, eget platea pharetra posuere scelerisque purus. Inceptos arcu pulvinar hendrerit, pretium sed, magnis diam."
        };
        String[] item_price = new String[]{"$299.99", "130.50", "$270.80", "$30.90", "$500.99", "$1020.10", "$12000.90"};
        ProductStore productStore = new ProductStore(getActivity(), item_image, item_name, item_description, item_price);
        gridView.setAdapter(productStore);
        return view;
    }
}

class ProductStore extends BaseAdapter {
    Context context;
    int[] item_image;
    String[] item_name, item_price, item_description;
    LayoutInflater inflater;

    ProductStore(Context context, int[] item_image, String[] item_name, String[] item_description, String[] item_price) {
        this.context = context;
        this.item_image = item_image;
        this.item_description = item_description;
        this.item_name = item_name;
        this.item_price = item_price;
        inflater = (LayoutInflater.from(context.getApplicationContext()));
    }

    @Override
    public int getCount() {
        return item_name.length;
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

        view = inflater.inflate(R.layout.card2, null);
        ImageView image = view.findViewById(R.id.item_image);
        TextView name = view.findViewById(R.id.item_name);
        TextView price = view.findViewById(R.id.item_price);

        image.setImageResource(item_image[i]);
        name.setText(item_name[i]);
        price.setText(item_price[i]);

        view.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetailsActivity.class)
                    .putExtra("product_name", item_name[i])
                    .putExtra("product_image", item_image[i])
                    .putExtra("product_description", item_description[i])
                    .putExtra("product_price", item_price[i]);
            context.startActivity(intent);
        });

        return view;
    }
}