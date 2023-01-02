package com.hephzisoft.semester3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    BottomSheetBehavior<View> bottomSheetBehavior;
    EditText loginEmail, loginPassword;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


     findViewById(R.id.go_to_signup).setOnClickListener(view -> {
         startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
     });


//        LOGIN FUNCTION
        relativeLayout = findViewById(R.id.login_body);
        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        dbHelper = new DBHelper(LoginActivity.this);

        findViewById(R.id.login).setOnClickListener(v -> {
            String username_text = loginEmail.getText().toString();
            String password_text = loginPassword.getText().toString();

            if (username_text.isEmpty() || password_text.isEmpty()){
                Snackbar.make(relativeLayout, String.format("Please Fill In The Fields Provided."), Snackbar.LENGTH_SHORT).show();
            }else {
                Boolean user_exists = dbHelper.verifyUser(username_text, password_text);
                if (!user_exists){
                    Snackbar.make(relativeLayout, String.format("User Does Not Exist"), Snackbar.LENGTH_SHORT).show();
                }else {
                    startActivity(new Intent(LoginActivity.this, HomePageActivity.class).putExtra("user", username_text));
                    finish();
                }
            }
        });

    }
}