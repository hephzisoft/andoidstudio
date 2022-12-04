package com.hephzisoft.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView greet;
    Button change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greet = findViewById(R.id.greeting);
        change = findViewById(R.id.changer);


        change.setOnClickListener(v -> {
            String[] names  = new String[]{"Hephzibah", "Thompson ", "David", "Emmanuel"};
            Random random = new Random();
            int name =  random.nextInt(names.length);
            String option  = names[name];
            greet.setText(option);
        });

    }
}