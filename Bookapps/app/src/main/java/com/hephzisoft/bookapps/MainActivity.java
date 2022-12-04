package com.hephzisoft.bookapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView book_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        book_layout = findViewById(R.id.book_layouts);


        ArrayList<Book> bookArrayList = new ArrayList<Book>();

        bookArrayList.add(new Book(R.drawable.book1, "Mark Manson", "The Subtle Art Of Not Giving A Fuck", "Lorem ipsum dolor sit amet consectetur adipiscing elit ultrices fusce nascetur, curae per nam facilisi suscipit enim euismod cubilia vehicula pellentesque, a justo malesuada in metus rutrum quis nunc sociosqu."));
        bookArrayList.add(new Book(R.drawable.book2, "Colleen Hoover", "It Ends With Us","Lorem ipsum dolor sit amet consectetur adipiscing elit ultrices fusce nascetur, curae per nam facilisi suscipit enim euismod cubilia vehicula pellentesque, a justo malesuada in metus rutrum quis nunc sociosqu."));
        bookArrayList.add(new Book(R.drawable.book3, "James Clear", "Atomic Habits","Lorem ipsum dolor sit amet consectetur adipiscing elit ultrices fusce nascetur, curae per nam facilisi suscipit enim euismod cubilia vehicula pellentesque, a justo malesuada in metus rutrum quis nunc sociosqu."));
        bookArrayList.add(new Book(R.drawable.book4, "Robert Greene", "Power","Lorem ipsum dolor sit amet consectetur adipiscing elit ultrices fusce nascetur, curae per nam facilisi suscipit enim euismod cubilia vehicula pellentesque, a justo malesuada in metus rutrum quis nunc sociosqu."));
        bookArrayList.add(new Book(R.drawable.book5, "Colleen Hoover", "It Starts With Us","Lorem ipsum dolor sit amet consectetur adipiscing elit ultrices fusce nascetur, curae per nam facilisi suscipit enim euismod cubilia vehicula pellentesque, a justo malesuada in metus rutrum quis nunc sociosqu."));
        bookArrayList.add(new Book(R.drawable.book6, "Robert T. Kiyosaki", "Rich Dad, Poor Dad","Lorem ipsum dolor sit amet consectetur adipiscing elit ultrices fusce nascetur, curae per nam facilisi suscipit enim euismod cubilia vehicula pellentesque, a justo malesuada in metus rutrum quis nunc sociosqu."));


        Adapter adapter = new Adapter(this, bookArrayList);
        book_layout.setAdapter(adapter);

    }
}