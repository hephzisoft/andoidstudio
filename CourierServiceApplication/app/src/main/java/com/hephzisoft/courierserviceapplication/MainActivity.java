package com.hephzisoft.courierserviceapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(v->{


            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel notificationChannel = new NotificationChannel("Notification", "Notification",NotificationManager.IMPORTANCE_DEFAULT);
                notificationChannel.setDescription("Learning the basics of implementing notifications");

                NotificationManager manager = getSystemService(NotificationManager.class);
                manager.createNotificationChannel(notificationChannel);
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),"Notification")
                    .setSmallIcon(R.drawable.notification)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
                    .setContentTitle("Learn Notification Setup")
                    .setContentText("Learning the basic of using Notification")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
            managerCompat.notify(01,builder.build());


        });
    }
}