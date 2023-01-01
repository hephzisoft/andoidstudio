package com.example.foodi3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

public class SignUpActivity extends AppCompatActivity {

    EditText username, email, password, password2;
    ConstraintLayout constraintLayout;
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
        constraintLayout = findViewById(R.id.signup_body);
        username = findViewById(R.id.reg_username);
        email = findViewById(R.id.reg_email);
        password = findViewById(R.id.reg_password);
        password2 = findViewById(R.id.reg_password2);

        findViewById(R.id.sign_up).setOnClickListener(v -> {
            if (username.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                Snackbar.make(constraintLayout, "Please Fill In The Fields Provided.", Snackbar.LENGTH_SHORT).show();
            }else {
                if (password.getText().toString().equals(password2.getText().toString())){
                    try {
                        dbHelper.createUser(username.getText().toString(), email.getText().toString(), password.getText().toString());
                        startActivity(new Intent(SignUpActivity.this, HomePageActivity.class).putExtra("user", username.getText().toString()));
                        finish();
                    }catch (Exception e){
                        Snackbar.make(constraintLayout, "There was an error while inserting data", Snackbar.LENGTH_SHORT).show();
                    }
                }else Snackbar.make(constraintLayout, "Passwords Do Not Match.", Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        finish();
    }
}