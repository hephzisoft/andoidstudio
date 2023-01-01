package com.hephzisoft.quickmeal;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hephzisoft.quickmeal.Adapters.IngredientsAdapter;
import com.hephzisoft.quickmeal.Listeners.RecipeDetailsListener;
import com.hephzisoft.quickmeal.Listeners.SimilarRecipesListener;
import com.hephzisoft.quickmeal.Models.RecipeDetailsResponse;
import com.hephzisoft.quickmeal.Models.SimilarRecipeResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecipeDetailsActivity extends AppCompatActivity {
    int id;
    TextView mealName, mealSource, mealSummary;
    ImageView mealImage;
    RecyclerView mealIngredients, recycler_meal_similar;
    RequestManager manager;
    ProgressDialog dialog;
    IngredientsAdapter ingredientsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        findViews();
        id = Integer.parseInt(getIntent().getStringExtra("id"));
        manager = new RequestManager(this);
        manager.getRecipeDetails(recipeDetailsListener, id);
        manager.getSimilarRecipe(similarRecipesListener, id);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading Details...");
        dialog.show();


    }

    private void findViews() {
        mealName = findViewById(R.id.textView_meal_Name);
        mealIngredients = findViewById(R.id.recycler_meal_ingredients);
        mealImage = findViewById(R.id.imageView_meal_image);
        mealSource = findViewById(R.id.textView_meal_source);
        mealSummary = findViewById(R.id.textView_meal_summary);
        recycler_meal_similar = findViewById(R.id.recycler_meal_similar);
    }

    private final RecipeDetailsListener recipeDetailsListener = new RecipeDetailsListener() {
        @Override
        public void didFetch(RecipeDetailsResponse response, String message) {
            dialog.dismiss();
            mealName.setText(response.title);
            mealSource.setText(response.sourceName);
            mealSummary.setText(response.summary);
            Picasso.get().load(response.image).into(mealImage);

            mealIngredients.setHasFixedSize(true);
            mealIngredients.setLayoutManager(new LinearLayoutManager(RecipeDetailsActivity.this, LinearLayoutManager.HORIZONTAL, false));

            ingredientsAdapter = new IngredientsAdapter(RecipeDetailsActivity.this, response.extendedIngredients);

            mealIngredients.setAdapter(ingredientsAdapter);

        }

        @Override
        public void didError(String message) {
            Toast.makeText(RecipeDetailsActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };
    private final SimilarRecipesListener similarRecipesListener = new SimilarRecipesListener() {
        @Override
        public void didFetch(List<SimilarRecipeResponse> response, String message) {

        }

        @Override
        public void didError(String message) {

        }
    };
}