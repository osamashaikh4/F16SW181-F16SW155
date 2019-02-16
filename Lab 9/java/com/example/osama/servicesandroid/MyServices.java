package com.example.gareeb.servicesandroid;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyServices extends Service {

    Notification mNotification;
    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yed Implemented");
    }

    public int onStartCommand(Intent intent, int flags, int started){
        Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show();
        buildNotification();
        startForeground(1,mNotification);
        return START_STICKY;
    }

    public void onDestroy(){

        Toast.makeText(this,"Service Destroyed",Toast.LENGTH_LONG).show();


        super.onDestroy();

    }

    public void buildNotification(){
        Intent notificationIntent  = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            CharSequence ChannelName = "PlayBack Channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("1", ChannelName, importance);
            nManager.createNotificationChannel(notificationChannel);
        }
        mNotification = new NotificationCompat.Builder(getBaseContext(),"1")
                .setContentTitle("ON GOING")
                .setContentText("Service started")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setStyle(new NotificationCompat.BigTextStyle())
                .build();
    }
    }

