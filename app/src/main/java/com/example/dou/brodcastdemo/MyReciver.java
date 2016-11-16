package com.example.dou.brodcastdemo;

import android.content.BroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by Dou on 2016/11/14.
 */

public class MyReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("here","Broadcast onReceive");
        //取出intent数据
        Bundle bundle = intent.getExtras();
        //得到短信实体，一个SmsMessage对象可以保存140字节，号码在第0个
        //如果内容太多那么SmsMessage数组长度会很大
        Object[] objects = (Object[])bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[objects.length];
        String format = intent.getStringExtra("format");
        for(int i = 0; i < messages.length; i++){
            byte[] pdu = (byte[])objects[i];
            //api23以上可用
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                messages[i] = SmsMessage.createFromPdu(pdu,format);
            }
            else {
                messages[i] = SmsMessage.createFromPdu(pdu);
            }
            //得到短信的内容
            Log.v("here",messages[i].getMessageBody());
        }
        //电话号码
       Log.v("here", "电话号码" + messages[0].getDisplayOriginatingAddress());
    }
}
