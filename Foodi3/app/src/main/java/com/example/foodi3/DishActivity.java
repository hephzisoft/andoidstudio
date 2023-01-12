package com.example.foodi3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.HashSet;
import java.util.Set;

public class DishActivity extends AppCompatActivity {

    TextView name, ingredient, process, drinktype;
    ImageView image;
    Button add_to_cart;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);

        db = new DBHelper(this);

        int id = getIntent().getExtras().getInt("id");
        String n = getIntent().getExtras().getString("name");
        String im = getIntent().getExtras().getString("image");
        String in = getIntent().getExtras().getString("ingredients");
        String p = getIntent().getExtras().getString("process");
        String dt = getIntent().getExtras().getString("drinktype");

        name = findViewById(R.id.name);
        ingredient = findViewById(R.id.ingredients);
        process = findViewById(R.id.process);
        image = findViewById(R.id.image);
        drinktype = findViewById(R.id.drinkType);


        name.setText(n);
        ingredient.setText(in);
        process.setText(p);
        drinktype.setText(dt);

        Picasso.get().load(im).placeholder(R.drawable.ic_baseline_image_24).error(R.drawable.ic_baseline_image_24).into(image);

        findViewById(R.id.back).setOnClickListener(v -> onBackPressed());

        findViewById(R.id.delete_dish).setOnClickListener(v -> {
            boolean is_deleted = db.deleteDish(getIntent().getExtras().getInt("id"));

            if (is_deleted) {
                onBackPressed();
            } else {
                Toast.makeText(this, "An error occurred while attempting to delete this dish.", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.edit_dish).setOnClickListener(v -> {
            startActivity(new Intent(DishActivity.this, EditDishActivity.class)
                    .putExtra("id", id)
                    .putExtra("name", n)
                    .putExtra("image", im)
                    .putExtra("ingredients", in)
                    .putExtra("process", p)
                    .putExtra("drinktype", dt));
            finish();
        });



        add_to_cart = findViewById(R.id.add_to_cart);
        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemId = String.valueOf(id);

                // Get the current set of favorite item IDs
                SharedPreferences sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
                Set<String> favoriteItemIds = sharedPreferences.getStringSet("favorite_items", new HashSet<String>());

                // Check if the item is in the user's favorites
                if (favoriteItemIds.contains(itemId)) {
                    favoriteItemIds.remove(itemId);
                    Toast.makeText(DishActivity.this, "Item was added", Toast.LENGTH_SHORT).show();
                } else {
                    favoriteItemIds.add(itemId);
                    Toast.makeText(DishActivity.this, "Item was removed", Toast.LENGTH_SHORT).show();
                }
                // Add the new favorite item ID to the set


                // Save the updated set of favorite item IDs to Shared Preferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putStringSet("favorite_items", favoriteItemIds);
                editor.apply();



            }
        });
    }

}