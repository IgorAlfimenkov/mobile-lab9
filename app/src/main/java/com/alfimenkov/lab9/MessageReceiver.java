package com.alfimenkov.lab9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Получено сообщение: " + intent.getStringExtra("com.alfimenkov.lab9.broadcast.Message"),
                Toast.LENGTH_LONG).show();
    }
}