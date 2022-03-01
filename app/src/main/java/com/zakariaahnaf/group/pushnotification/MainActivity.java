package com.zakariaahnaf.group.pushnotification;

import static com.zakariaahnaf.group.pushnotification.App.CHANNEL_1_ID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);

    }

    public void sendFromChannel1(View view) {

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID).setSmallIcon(R.drawable.ic_one)
                .setContentTitle(editTextTitle.getText().toString())
                .setContentText(editTextMessage.getText().toString())
                .setPriority(Notification.PRIORITY_HIGH)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1, notification);

    }

    public void sendFromChannel2(View view) {

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID).setSmallIcon(R.drawable.ic_two)
                .setContentTitle(editTextTitle.getText().toString())
                .setContentText(editTextMessage.getText().toString())
                .setPriority(Notification.PRIORITY_LOW)
                //.setCategory(Notification.CATEGORY_MESSAGE)
                .setCategory("My Custom CategoryName")
                .build();

        notificationManagerCompat.notify(2, notification);
    }
}