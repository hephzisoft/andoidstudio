package com.hephzisoft.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {
    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        grid = findViewById(R.id.grid);
        ArrayList<Movie> movieArrayList = new ArrayList<>();

        movieArrayList.add(new Movie(R.drawable.logo));
        Adapter adapter =  new Adapter(this, movieArrayList);
        grid.setAdapter(adapter);
    }
}