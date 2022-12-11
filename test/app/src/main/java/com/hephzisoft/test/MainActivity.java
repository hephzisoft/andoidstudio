package com.hephzisoft.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

import com.hephzisoft.test.DBHelper;
import com.hephzisoft.test.LoginActivity;
import com.hephzisoft.test.MovieActivity;
import com.hephzisoft.test.R;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);


        new CountDownTimer(5000, 1) {
            int progress = 0;
            int count = 0;

            @Override
            public void onTick(long l) {
                ++count;
                if (count % 30 == 0) {
                    progress++;
                }

                progressBar.setProgress(progress);
            }

            @Override
            public void onFinish() {
                String[] db_data = new DBHelper(MainActivity.this).getLoggedInUser();
                if(Integer.parseInt(db_data[0]) > 0){
                    startActivity(new Intent(MainActivity.this, MovieActivity.class).putExtra("name", db_data[1]));

                }else{
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
                finish();
            }
        }.start();
    }
}