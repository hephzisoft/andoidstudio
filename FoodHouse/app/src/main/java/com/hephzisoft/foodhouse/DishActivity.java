package com.hephzisoft.foodhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DishActivity extends AppCompatActivity {
    TextView name, ingredient, process;
    ImageView image;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);

        String n = getIntent().getExtras().getString("name");
        String im = getIntent().getExtras().getString("image");
        String in = getIntent().getExtras().getString("ingredients");
        String p = getIntent().getExtras().getString("process");

        name = findViewById(R.id.name);
        ingredient = findViewById(R.id.ingredients);
        process = findViewById(R.id.process);
        image = findViewById(R.id.image);
        db = new DBHelper(DishActivity.this);

        name.setText(n);
        ingredient.setText(in);
        process.setText(p);

        Picasso.get().load(im).placeholder(R.drawable.ic_baseline_image_24).error(R.drawable.ic_baseline_image_24).into(image);

        findViewById(R.id.back).setOnClickListener(v -> onBackPressed());
        
        findViewById(R.id.delete_dish).setOnClickListener(v->{
            boolean is_deleted= db.deleteDish(getIntent().getExtras().getInt("id"));
            
            if(is_deleted){
                onBackPressed();
            }else{
                Toast.makeText(this, "An error occured while attempting to delete this dish", Toast.LENGTH_SHORT).show();
            }
        });
    }
}