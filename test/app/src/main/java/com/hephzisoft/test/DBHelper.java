package com.hephzisoft.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

public class DBHelper extends SQLiteOpenHelper {

    private final static String db_name = "foodie.db";
    private final static int version = 1;


    Context context;

    public DBHelper(@Nullable Context context) {
        super(context, db_name, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users (id integer  primary key autoincrement , username text unique , email text , password text, is_loggedin boolean)");
        db.execSQL("create table dishes (id integer primary key autoincrement, name text, ingredients text, process text, image_url text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists dishes");
        onCreate(db);
    }

//    CREATE USER

    public void createUser(View view, String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("is_loggedin", true);

        long result = db.insert("users", null, contentValues);


    }

    //        VERIFY USER\
    public boolean verifyUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id from users where username  = ? and password = ?", new String[]{username, password});


        if (cursor.getCount() > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_loggedin", true);

            long result = db.update("users", contentValues, "username = ? and password = ?", new String[]{username, password});

            if (result == -1)
                Toast.makeText(context, "An error occurred while fetching data", Toast.LENGTH_SHORT).show();

            return true;
        } else {
            return false;
        }

    }

    public String[] getLoggedInUser() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select username from users where is_loggedin = 1", new String[]{});
        int count = cursor.getCount();
        String loggedin_user = "";
        if (count > 0) {
            while (cursor.moveToNext()) {
                loggedin_user = cursor.getString(0);
            }
        }

        return new String[]{String.valueOf(count), loggedin_user};
    }
}