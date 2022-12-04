package com.hephzisoft.hephzi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText firstname;
    private EditText lastname;
    private EditText password;
    private Button register;
    private TextView warnings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        password = findViewById(R.id.password);
        register = findViewById(R.id.button);
        warnings = findViewById(R.id.caution);
        warnings.setVisibility(View.INVISIBLE);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked(password.getText().toString(), firstname.getText().toString(),lastname.getText().toString(), username.getText().toString());
            }
        });
    }

    private void clicked(String user_password, String user_firstname, String user_lastname, String user_username){
        if(!user_firstname.equals("")&&!user_lastname.equals("")&&!user_username.equals("")&&!user_password.equals("") ){
            Intent login_page = new Intent(MainActivity.this, loginActivity.class);
            startActivity(login_page);
        }else{
            warnings.setVisibility(View.VISIBLE);
        }
    }
}