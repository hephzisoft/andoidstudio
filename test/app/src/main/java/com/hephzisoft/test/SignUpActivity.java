package com.hephzisoft.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.Snackbar;

public class SignUpActivity extends AppCompatActivity {
    DBHelper dbHelper;
    RelativeLayout relativeLayout;
    EditText username,email, password1, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


//        BAck to login

        findViewById(R.id.go_to_login).setOnClickListener(v ->{
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            finish();
        });

        dbHelper = new DBHelper(SignUpActivity.this);
        relativeLayout = findViewById(R.id.sign_up_body);
        username = findViewById(R.id.signup_username);
        email = findViewById(R.id.reg_email);
        password1 = findViewById(R.id.reg_password);
        password2 = findViewById(R.id.reg_rewritepassword);

        findViewById(R.id.sign_up).setOnClickListener(v ->{
            if(username.getText().toString().isEmpty()|| email.getText().toString().isEmpty()|| password1.getText().toString().isEmpty()){
                Snackbar.make(relativeLayout, String.format("Please Fill In The Fields Provided."), Snackbar.LENGTH_SHORT).show();
            }else{
                if(password1.getText().toString().equals(password2.getText().toString())){
                    try{
                        dbHelper.createUser(relativeLayout, username.getText().toString(), email.getText().toString(), password1.getText().toString());
                        startActivity(new Intent(SignUpActivity.this, MovieActivity.class).putExtra("name", username.getText().toString()));
                        finish();
                    }catch (Exception e){
                        Snackbar.make(relativeLayout, String.format("There was an error while inserting data. "), Snackbar.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }else{
                    Snackbar.make(relativeLayout, String.format("Password do not match "), Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}