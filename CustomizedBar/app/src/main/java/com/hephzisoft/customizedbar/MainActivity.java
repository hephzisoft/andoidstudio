package com.hephzisoft.customizedbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        ImageView rightIcon = findViewById(R.id.right_icon);
        TextView title = findViewById(R.id.toolbar_title);

        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You clicked on the right icon", Toast.LENGTH_SHORT).show();
            }
        });
        title.setText("Whatsapp Business");

    }
}