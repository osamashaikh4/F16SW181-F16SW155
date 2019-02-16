package com.example.gareeb.servicesandroid;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Notification mNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view){
        startService(new Intent(getBaseContext(),MyServices.class));
    }

    public void stopService(View view){

        stopService(new Intent(getBaseContext(),MyServices.class));
        buildNotification();
        NotificationManager n=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        n.notify(1,mNotification);
    }

    public void buildNotification(){
        Intent notificationIntent  = new Intent(this,MyServices.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            CharSequence ChannelName = "PlayBack Channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("1", ChannelName, importance);
            nManager.createNotificationChannel(notificationChannel);
        }
        mNotification = new NotificationCompat.Builder(getBaseContext(),"1")
                .setContentTitle("service stopped")
                .setContentText("Service stopped")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setStyle(new NotificationCompat.BigTextStyle())
                .build();
    }

}
