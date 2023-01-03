package com.example.foodi3;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {

    DBHelper db;

    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        String user = getIntent().getExtras().getString("user");
        search = findViewById(R.id.search);

        ((Toolbar) findViewById(R.id.toolbar)).setTitle(String.format("Welcome %s", user));

        findViewById(R.id.add_menu_item).setOnClickListener(v -> {
            startActivity(new Intent(HomePageActivity.this, AddMenuItem.class));
        });

        db = new DBHelper(HomePageActivity.this);

        pull_data();

        ((SwipeRefreshLayout) findViewById(R.id.refresh)).setColorSchemeColors(Color.parseColor("#3e8a0c"));
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
        ArrayList<String> drinkTypes_of_dish = new ArrayList<>();

        Cursor cursor = db.getDishes();
        while (cursor.moveToNext()) {
            ids_of_dishes.add(cursor.getInt(0));
            names_of_dishes.add(cursor.getString(1));
            image_url_of_dishes.add(cursor.getString(2));
            ingredients_of_dishes.add(cursor.getString(3));
            process_of_making_dishes.add(cursor.getString(4));
            drinkTypes_of_dish.add(cursor.getString(5));
        }

        GridView grid = findViewById(R.id.grid);

        DishAdapter dishAdapter = new DishAdapter(this, ids_of_dishes, names_of_dishes, image_url_of_dishes, ingredients_of_dishes, process_of_making_dishes, drinkTypes_of_dish);

        grid.setAdapter(dishAdapter);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<Integer> ids = new ArrayList<>();
                ArrayList<String> names = new ArrayList<>();
                ArrayList<String> images = new ArrayList<>();
                ArrayList<String> ingredients = new ArrayList<>();
                ArrayList<String> processes = new ArrayList<>();
                ArrayList<String> drinkType = new ArrayList<>();

                for (int i = 0; i < names_of_dishes.size(); i++) {
                    if (names_of_dishes.get(i).toLowerCase().contains(s.toString().toLowerCase())) {
                        ids.add(ids_of_dishes.get(i));
                        names.add(names_of_dishes.get(i));
                        images.add(image_url_of_dishes.get(i));
                        ingredients.add(ingredients_of_dishes.get(i));
                        processes.add(process_of_making_dishes.get(i));
                        drinkType.add(drinkTypes_of_dish.get(i));

                        DishAdapter dishAdapter = new DishAdapter(HomePageActivity.this, ids, names, images, ingredients, processes, drinkType);
                        grid.setAdapter(dishAdapter);
                    }



                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}

class DishAdapter extends BaseAdapter {


    ArrayList<Integer> id;
    ArrayList<String> name, image_url, ingredients, process,drinkTypes;
    Context context;
    LayoutInflater inflater;

    public DishAdapter(Context context, ArrayList<Integer> id, ArrayList<String> name, ArrayList<String> image_url, ArrayList<String> ingredients, ArrayList<String> process, ArrayList<String> drinkTypes) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
        this.ingredients = ingredients;
        this.process = process;
        this.context = context;
        this.drinkTypes = drinkTypes;

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

        ImageView imageview = view.findViewById(R.id.item_image);
        TextView textView = view.findViewById(R.id.item_name);

        Picasso.get().load(image_url.get(position)).placeholder(R.drawable.ic_baseline_image_24).error(R.drawable.ic_baseline_image_24).into(imageview);

        textView.setText(name.get(position));

        view.setOnClickListener(v -> {
            context.startActivity(new Intent(context.getApplicationContext(), DishActivity.class)
                    .putExtra("id", id.get(position))
                    .putExtra("name", name.get(position))
                    .putExtra("image", image_url.get(position))
                    .putExtra("ingredients", ingredients.get(position))
                    .putExtra("process", process.get(position)).putExtra("drinktype",drinkTypes.get(position)));

        });

        return view;
    }
}