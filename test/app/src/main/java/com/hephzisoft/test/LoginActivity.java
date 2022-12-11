package com.hephzisoft.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    DBHelper dbHelper;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.go_to_sign_up).setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            finish();
        });

//        Login
        relativeLayout = findViewById(R.id.login_body);
        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        dbHelper = new DBHelper(LoginActivity.this);


        findViewById(R.id.loginBtn).setOnClickListener(v -> {
            String username_text = username.getText().toString();
            String password_text = password.getText().toString();

            if (username_text.isEmpty() || password_text.isEmpty()) {
                Snackbar.make(relativeLayout, String.format("Please Fill In The Fields Provided."), Snackbar.LENGTH_SHORT).show();
            } else {
                boolean users_count = dbHelper.verifyUser(username_text, password_text);
                if (!users_count) {
                    Snackbar.make(relativeLayout, String.format("User does not Exists ."), Snackbar.LENGTH_SHORT).show();

                } else {
                    startActivity(new Intent(LoginActivity.this, MovieActivity.class).putExtra("username", username_text));
                    finish();
                }
            }
        });


    }
}