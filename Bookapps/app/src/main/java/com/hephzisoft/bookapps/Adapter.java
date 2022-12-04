package com.hephzisoft.bookapps;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

import java.util.List;

public class Adapter extends ArrayAdapter<Book> {
    Context context;
    Button btn;
    public Adapter(@NonNull Context context, ArrayList<Book> bookArrayList) {
        super(context, 0, bookArrayList);
        this.context  = context;
        this.btn = btn;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View booksViews = convertView;
        if (booksViews == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            booksViews = LayoutInflater.from(getContext()).inflate(R.layout.book_layout, parent, false);
        }

        Book books = getItem(position);
        TextView author_name = booksViews.findViewById(R.id.author_name);
        TextView book_title = booksViews.findViewById(R.id.book_title);
        ImageView image = booksViews.findViewById(R.id.image);
        btn = booksViews.findViewById(R.id.read_button);

        author_name.setText(books.getAuthor_name());
        book_title.setText(books.getBook_title());
        image.setImageResource(books.getImage());

        btn.setOnClickListener(v -> {
            Intent intent = new Intent(context, ReadBooks.class).putExtra("bookContent",books.getBook_content()).putExtra("book_title", books.getBook_title());
            context.startActivity(intent);

        });

        return booksViews;
    }
}
