package com.demo.platformcarapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String ACTION_TEST = "com.demo.test";

    private TestClient mTestClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestClient = new TestClient();
        mTestClient.init();

        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_TEST);
        registerReceiver(mReceiver, filter);
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive action: " + intent.getAction());
            if (ACTION_TEST.equals(intent.getAction())) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mTestClient.test();
                    }
                }).start();
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}
