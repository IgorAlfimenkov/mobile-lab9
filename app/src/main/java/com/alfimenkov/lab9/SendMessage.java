package com.alfimenkov.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SendMessage extends AppCompatActivity {

    public static final String MY_ACTION = "com.alfimenkov.lab9.action.ACTION";
    public static final String ACTION_MESSAGE = "Hello World!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_message_activity);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent();
        intent.setAction(MY_ACTION);
        intent.putExtra("com.alfimenkov.lab9.broadcast.Message", ACTION_MESSAGE);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }

    public void leave(View view) {
        this.finish();
    }
}