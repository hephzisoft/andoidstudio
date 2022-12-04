package com.hephzisoft.bookapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ReadBooks extends AppCompatActivity {

    TextView textView;
    TextView names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_books);

        textView = findViewById(R.id.book_content);
        names = findViewById(R.id.book_names);

        String book_content = getIntent().getExtras().getString("bookContent");
        String book_name = getIntent().getExtras().getString("book_title");
        textView.setText(book_content);
        names.setText(book_name);


        findViewById(R.id.back_btn).setOnClickListener(v -> {
            onBackPressed();
        });

    }
}