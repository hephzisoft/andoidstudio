package com.example.foodi3;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(3000, 30) {

            int progress = 0;

            @Override
            public void onTick(long millisUntilFinished) {
                ++progress;
                ((ProgressBar) findViewById(R.id.progressBar)).setProgress(progress);
            }

            @Override
            public void onFinish() {
                String[] db_data = new DBHelper(MainActivity.this).getLoggedInUser();

                if (Integer.parseInt(db_data[0]) > 0){
                    startActivity(new Intent(MainActivity.this, HomePageActivity.class).putExtra("user", db_data[1]));
                }else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }

                finish();
            }
        }.start();

    }
}