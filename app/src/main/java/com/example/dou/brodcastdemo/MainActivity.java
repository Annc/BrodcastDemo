package com.example.dou.brodcastdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mSendbtn;
    private MyReciver reciver = new MyReciver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 动态注册广播,需要注销
         */
        //IntentFilter filter = new IntentFilter();
        //filter.addAction("android.provider.Telephony.SMS.RECEIVED");
        //registerReceiver(reciver, filter);


        mSendbtn = (Button)findViewById(R.id.send);
        mSendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.dou.brodcastdemo.MY_ACTION");
                //sendBroadcast(intent);
                //使用sendBroadcast发送的是无序广播
                //sendBroadcast(intent, "com.example.dou.brodcastdemo.MYPEMISSION");
                intent.putExtra("hello","world");
                //发送有序广播
                sendOrderedBroadcast(intent, null);
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁广播
        //unregisterReceiver(reciver);
    }


}
