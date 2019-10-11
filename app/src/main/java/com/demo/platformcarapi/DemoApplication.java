package com.demo.platformcarapi;

import android.app.Application;
import android.support.multidex.MultiDex;
import android.content.Context;
import android.util.Log;

import com.demo.platform.carapi.CarApi;

/**
 * Created by xiaojun
 *
 * @date 19-7-10
 */
public class DemoApplication extends Application {
    private static final String TAG = "DemoApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate()");
        CarApi.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
