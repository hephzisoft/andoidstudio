package com.hephzisoft.semester3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class AddMenuItem extends AppCompatActivity {

    EditText name, ingredients, process, image_url;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu_item);

        name = findViewById(R.id.dish_name);
        ingredients = findViewById(R.id.dish_ingredients);
        process = findViewById(R.id.dish_process);
        image_url = findViewById(R.id.dish_image_url);

        db = new DBHelper(this);

        findViewById(R.id.back_to_home).setOnClickListener(v -> {
            onBackPressed();
        });

        findViewById(R.id.create_dish).setOnClickListener(v -> {
            if (name.getText().toString().isEmpty() || ingredients.getText().toString().isEmpty() || process.getText().toString().isEmpty() || image_url.getText().toString().isEmpty()){
                Toast.makeText(this, "Please fill all the input fields provided", Toast.LENGTH_SHORT).show();
            }else {
                try {
                    db.createDish(name.getText().toString(), ingredients.getText().toString(), process.getText().toString(), image_url.getText().toString());
                    onBackPressed();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}