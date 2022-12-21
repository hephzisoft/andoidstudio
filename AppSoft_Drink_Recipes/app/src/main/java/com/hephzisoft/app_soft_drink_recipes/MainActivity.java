package com.hephzisoft.app_soft_drink_recipes;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.taketohomepage).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AllRecipeActivity.class));
        });
    }


}