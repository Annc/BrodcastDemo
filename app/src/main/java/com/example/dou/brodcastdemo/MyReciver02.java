package com.example.dou.brodcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Dou on 2016/11/22.
 */

public class MyReciver02 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("here","Second Broadcast onReceive");
        Log.v("here","Data02 " + getResultData());
        Log.v("here","ExtraData02 " + intent.getStringExtra("hello"));
        setResultData("7654321");
    }
}
