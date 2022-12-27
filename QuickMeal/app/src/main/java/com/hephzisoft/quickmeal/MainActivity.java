package com.hephzisoft.quickmeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.hephzisoft.quickmeal.Adapters.RandomRecipeAdapter;
import com.hephzisoft.quickmeal.Listeners.RandomRecipeResponseListener;
import com.hephzisoft.quickmeal.Models.RandomRecipeAPIResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
ProgressDialog dialog;
RequestManager manager;
RandomRecipeAdapter randomRecipeAdapter;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");

        manager = new RequestManager(this);
        manager.getRandomRecipe(randomRecipeResponseListener);
        dialog.show();



    }
    private final RandomRecipeResponseListener randomRecipeResponseListener = new RandomRecipeResponseListener() {
        @Override
        public void didFetch(RandomRecipeAPIResponse response, String message) {
        dialog.dismiss();
            recyclerView = findViewById(R.id.recycler_random);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,1));
        randomRecipeAdapter = new RandomRecipeAdapter(MainActivity.this, response.recipes);
        recyclerView.setAdapter(randomRecipeAdapter);
        }

        @Override
        public void didError(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };
}



