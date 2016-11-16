package com.example.dou.brodcastdemo;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MyReciver reciver = new MyReciver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 动态注册广播,需要注销
         */
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.provider.Telephony.SMS.RECEIVED");
        registerReceiver(reciver, filter);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁广播
        unregisterReceiver(reciver);
    }


}
