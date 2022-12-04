package com.hephzisoft.foodhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class EditDishActivity extends AppCompatActivity {
    EditText dish_name,ingredients, process, image_url;

    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dish);
        dish_name = findViewById(R.id.name_of_dish);
        ingredients = findViewById(R.id.ingredients);
        image_url = findViewById(R.id.image_url);
        process = findViewById(R.id.preparation_process);

        findViewById(R.id.go_back_to_home).setOnClickListener(v->{
            startActivity(new Intent(AddMenuItem.this, HomePageActivity.class));
        });
        db =  new DBHelper(this);
        findViewById(R.id.createDish).setOnClickListener(v->{
            if(dish_name.getText().toString().isEmpty() ||ingredients.getText().toString().isEmpty()||process.getText().toString().isEmpty()||image_url.getText().toString().isEmpty() ){
                Toast.makeText(this, "Please fill all the input fields below", Toast.LENGTH_SHORT).show();
            }else{
                try {
                    db.createDish(dish_name.getText().toString(),ingredients.getText().toString(),process.getText().toString(), image_url.getText().toString());
                    onBackPressed();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


    }
}