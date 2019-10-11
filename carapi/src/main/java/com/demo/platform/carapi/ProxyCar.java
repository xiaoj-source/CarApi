package com.demo.platform.carapi;

import android.car.Car;
import android.car.hardware.mcu.CarMcuManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.demo.platform.carapi.callback.ICarConnect;

/**
 * Created by xiaojun
 *
 * @date 19-4-25
 */
public class ProxyCar {
    private static final String TAG = "ProxyCar";
    private Context mContext;
    private Car mCar;
    private boolean mConnected;
    private ICarConnect mConnectCallback;

    ProxyCar(Context context) {
        mContext = context;
    }

    void register(ICarConnect connectCallback) {
        mConnectCallback = connectCallback;
    }

    void connect() {
        String carVersion = CarApi.getCarVersion();
        switch (carVersion) {
            case CarMcuManager.CAR_TYPE_D21:
                mCar = Car.createCar(mContext, new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        onCarConnected();
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        onCarDisConnected();
                    }
                });
                mCar.connect();
                break;

            case CarMcuManager.CAR_TYPE_D25:
                break;
        }
    }

    private void onCarConnected() {
        Log.i(TAG, "Car connected!");
        mConnected = true;
        if (mConnectCallback != null) {
            mConnectCallback.onConnected();
        }
    }

    private void onCarDisConnected() {
        Log.e(TAG, "Car disConnected!");
        mConnected = false;
        if (mConnectCallback != null) {
            mConnectCallback.onDisconnected();
        }
    }

    Object getCar() {
        Object car = null;
        String carVersion = CarApi.getCarVersion();
        switch (carVersion) {
            case CarMcuManager.CAR_TYPE_D21:
                car = mCar;
                break;
        }
        return car;
    }

    boolean isConnected() {
        return mConnected;
    }
}
