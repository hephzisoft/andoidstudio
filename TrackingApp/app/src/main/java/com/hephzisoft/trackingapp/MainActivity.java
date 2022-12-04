package com.hephzisoft.trackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.move_to_next).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TrackingPageActivity.class));
        });
    }
}