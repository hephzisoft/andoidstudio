package com.hephzisoft.semester3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    BottomSheetBehavior<View> bottomSheetBehavior;
    EditText username, password;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        BOTTOM SHEET BEHAVIOR
        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheet));

        findViewById(R.id.open).setOnClickListener(v -> {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        });

        findViewById(R.id.close).setOnClickListener(v -> {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        });

        findViewById(R.id.go_to_signup).setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            finish();
        });


//        LOGIN FUNCTION
        constraintLayout = findViewById(R.id.login_body);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        dbHelper = new DBHelper(LoginActivity.this);

        findViewById(R.id.log_in).setOnClickListener(v -> {
            String username_text = username.getText().toString();
            String password_text = password.getText().toString();

            if (username_text.isEmpty() || password_text.isEmpty()){
                Snackbar.make(constraintLayout, String.format("Please Fill In The Fields Provided."), Snackbar.LENGTH_SHORT).show();
            }else {
                Boolean user_exists = dbHelper.verifyUser(username_text, password_text);
                if (!user_exists){
                    Snackbar.make(constraintLayout, String.format("User Does Not Exist"), Snackbar.LENGTH_SHORT).show();
                }else {
                    startActivity(new Intent(LoginActivity.this, HomePageActivity.class).putExtra("user", username_text));
                    finish();
                }
            }
        });

    }
}