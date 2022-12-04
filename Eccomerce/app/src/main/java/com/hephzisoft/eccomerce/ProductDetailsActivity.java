package com.hephzisoft.eccomerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {
    TextView name, description, price;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        String product_name = getIntent().getExtras().getString("product_name");
        String product_description = getIntent().getExtras().getString("product_description");
        String product_price = getIntent().getExtras().getString("product_price");
        int product_image = getIntent().getExtras().getInt("product_image");


        name  = findViewById(R.id.product_detail_name);
        description = findViewById(R.id.product_detail_description);
        price = findViewById(R.id.product_detail_price);
        image = findViewById(R.id.product_image_large_view);


        name.setText(product_name);
        description.setText(product_description);
        price.setText(product_price);
        image.setImageResource(product_image);

        findViewById(R.id.back_btn).setOnClickListener(v -> {
            onBackPressed();
        });

    }
}