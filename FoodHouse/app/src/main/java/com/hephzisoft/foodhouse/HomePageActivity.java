package com.hephzisoft.foodhouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        String user = getIntent().getExtras().getString("name");
        ((Toolbar) findViewById(R.id.toolbar)).setTitle(String.format("Welcome %s", user));


        findViewById(R.id.add_menu_item).setOnClickListener(v -> {
            startActivity(new Intent(HomePageActivity.this, AddMenuItem.class));
            finish();
        });

        db = new DBHelper(HomePageActivity.this);

        pull_data();
        ((SwipeRefreshLayout) findViewById(R.id.refresh)).setColorSchemeColors(Color.parseColor("#F9B337"));
        ((SwipeRefreshLayout) findViewById(R.id.refresh)).setOnRefreshListener(() -> {
            ((SwipeRefreshLayout) findViewById(R.id.refresh)).setRefreshing(false);

            pull_data();
        });


    }

    public void pull_data() {
        ArrayList<Integer> ids_of_dishes = new ArrayList<>();
        ArrayList<String> names_of_dishes = new ArrayList<>();
        ArrayList<String> image_url_of_dishes = new ArrayList<>();
        ArrayList<String> ingredients_of_dishes = new ArrayList<>();
        ArrayList<String> process_of_making_dishes = new ArrayList<>();


        Cursor cursor = db.getDishes();

        while (cursor.moveToNext()) {
            ids_of_dishes.add(cursor.getInt(0));
            names_of_dishes.add(cursor.getString(1));
            image_url_of_dishes.add(cursor.getString(2));
            ingredients_of_dishes.add(cursor.getString(2));
            process_of_making_dishes.add(cursor.getString(3));


        }
        GridView grid = findViewById(R.id.grid);

        DishAdapter dishAdapter = new DishAdapter(this, ids_of_dishes, names_of_dishes, image_url_of_dishes, ingredients_of_dishes, process_of_making_dishes);
        grid.setAdapter(dishAdapter);
    }
}

class DishAdapter extends BaseAdapter {
    ArrayList<Integer> id;
    ArrayList<String> name, image_url, ingredients, process;
    Context context;
    LayoutInflater inflater;

    public DishAdapter(Context context, ArrayList<Integer> id, ArrayList<String> name, ArrayList<String> image_url, ArrayList<String> ingredients, ArrayList<String> process) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
        this.ingredients = ingredients;
        this.process = process;
        this.context = context;
        inflater = (LayoutInflater.from(context.getApplicationContext()));
    }

    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = inflater.inflate(R.layout.grid_card, null);

        ImageView imageView = view.findViewById(R.id.food_image);

        TextView textView = view.findViewById(R.id.food_text);

        Picasso.get().load(image_url.get(position)).placeholder(R.drawable.ic_baseline_image_24).error(R.drawable.ic_baseline_image_24).into(imageView);

        textView.setText(name.get(position));
        view.setOnClickListener(v -> {
            context.startActivity(new Intent(context.getApplicationContext(), DishActivity.class)
                    .putExtra("id", id.get(position))
                    .putExtra("name", name.get(position))
                    .putExtra("image", image_url.get(position))
                    .putExtra("ingredients", ingredients.get(position))
                    .putExtra("process", process.get(position)));

        });
        return view;
    }
}