package com.example.danielelvis.piefv6drawer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;

public class GerenciadorDeNotificacao extends AppCompatActivity {

    private static final GerenciadorDeNotificacao ourInstance = new GerenciadorDeNotificacao();
    public static GerenciadorDeNotificacao getInstance() {
        return ourInstance;
    }
    private GerenciadorDeNotificacao() {}

}
