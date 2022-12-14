package com.hephzisoft.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Movie> {
    Context context;

    public Adapter(@NonNull Context context, ArrayList<Movie> movieArrayList) {
        super(context, 0, movieArrayList);
        this.context = context;

    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View movieView = convertView;
        if (movieView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            movieView = LayoutInflater.from(getContext()).inflate(R.layout.movie_layout, parent, false);
        }

        Movie books = getItem(position);
        ImageView image = movieView.findViewById(R.id.image);


        image.setImageResource(books.getImage());


        return movieView;
    }
}


