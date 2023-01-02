package com.hephzisoft.semester3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class EditDishActivity extends AppCompatActivity {

    EditText name, ingredients, process, image_url;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dish);

        int id = getIntent().getExtras().getInt("id");
        String n = getIntent().getExtras().getString("name");
        String im = getIntent().getExtras().getString("image");
        String in = getIntent().getExtras().getString("ingredients");
        String p = getIntent().getExtras().getString("process");

        name = findViewById(R.id.dish_name);
        ingredients = findViewById(R.id.dish_ingredients);
        process = findViewById(R.id.dish_process);
        image_url = findViewById(R.id.dish_image_url);

        name.setText(n);
        ingredients.setText(in);
        process.setText(p);
        image_url.setText(im);

        db = new DBHelper(this);

        findViewById(R.id.back_to_home).setOnClickListener(v -> {
            onBackPressed();
        });

        findViewById(R.id.create_dish).setOnClickListener(v -> {
            if (name.getText().toString().isEmpty() || ingredients.getText().toString().isEmpty() || process.getText().toString().isEmpty() || image_url.getText().toString().isEmpty()){
                Toast.makeText(this, "Please fill all the input fields provided", Toast.LENGTH_SHORT).show();
            }else {
                try {
                    db.editDish(id, name.getText().toString(), ingredients.getText().toString(), process.getText().toString(), image_url.getText().toString());
                    onBackPressed();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}