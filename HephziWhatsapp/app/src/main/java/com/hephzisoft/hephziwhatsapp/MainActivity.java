package com.hephzisoft.hephziwhatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView chats;
    TextView status;
    TextView calls;
    ImageButton camera;
    ImageButton more;
    ImageButton search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chats = findViewById(R.id.chats);
        status = findViewById(R.id.status);
        calls = findViewById(R.id.calls);
        camera = findViewById(R.id.cameras);
        more = findViewById(R.id.more);
        search = findViewById(R.id.search);
        homepage();
        chats.setOnClickListener(view -> {
            homepage();
        });
        calls.setOnClickListener(view -> {
            call_page();
        });
        status.setOnClickListener(view -> {
            status_page();
        });


    }


    public void status_page() {
        getSupportFragmentManager().beginTransaction().replace(R.id.pages, new Status()).commit();
    }

    public void call_page() {
        getSupportFragmentManager().beginTransaction().replace(R.id.pages, new Calls()).commit();
    }

    public void homepage() {
        getSupportFragmentManager().beginTransaction().replace(R.id.pages, new Chats()).commit();
    }
}