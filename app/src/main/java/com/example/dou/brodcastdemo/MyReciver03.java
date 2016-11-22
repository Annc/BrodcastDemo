package com.example.dou.brodcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Dou on 2016/11/22.
 */

public class MyReciver03 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("here","Third Broadcast onReceive");
        Log.v("here","Data03 " + getResultData());
        Log.v("here","ExtraData03 " + intent.getStringExtra("hello"));
    }
}
