package com.hephzisoft.semester3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class SignUpActivity extends AppCompatActivity {

    EditText username, email, password, password2;
    RelativeLayout relativeLayout;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        BACK TO LOGIN ACTIVITY
        findViewById(R.id.go_to_login).setOnClickListener(v -> {
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            finish();
        });


//        SIGN UP FUNCTION
        dbHelper = new DBHelper(SignUpActivity.this);
        relativeLayout = findViewById(R.id.signup_body);
        username = findViewById(R.id.signup_username);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);


        findViewById(R.id.signup).setOnClickListener(v -> {
            if (username.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                Snackbar.make(relativeLayout, "Please Fill In The Fields Provided.", Snackbar.LENGTH_SHORT).show();
            } else {

                try {
                    dbHelper.createUser(username.getText().toString(), email.getText().toString(), password.getText().toString());
                    startActivity(new Intent(SignUpActivity.this, HomePageActivity.class).putExtra("user", username.getText().toString()));
                    finish();
                } catch (Exception e) {
                    Snackbar.make(relativeLayout, "There was an error while inserting data", Snackbar.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        finish();
    }
}