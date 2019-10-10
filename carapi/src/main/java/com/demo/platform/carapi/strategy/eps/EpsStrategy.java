package com.demo.platform.carapi.strategy.eps;

import android.car.Car;
import android.car.hardware.eps.CarEpsManager;
import android.util.Log;

import com.demo.platform.carapi.callback.EpsCallbackAdapter;
import com.demo.platform.carapi.strategy.BaseStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class EpsStrategy extends BaseStrategy implements IEpsStrategy {
    private static final String TAG = "EpsStrategy";
    private CarEpsManager mEpsManager;

    public EpsStrategy() {
        super();
    }

    @Override
    public String getServiceName() {
        return Car.XP_EPS_SERVICE;
    }

    @Override
    protected Integer[] getPropIds() {
        return EpsCallbackAdapter.PROP_IDS;
    }

    @Override
    public void register() {
        super.register();
        mEpsManager = (CarEpsManager) mManager;
    }

    @Override
    public int getSteeringWheelEPS() {
        if (mEpsManager == null) {
            Log.e(TAG, "getSteeringWheelEPS() error, Car not connected.");
            return CarEpsManager.EPS_POWER_ASSISTED_STANDARD;
        }
        try {
            Log.d(TAG, "getSteeringWheelEPS() start.");
            int value = mEpsManager.getSteeringWheelEPS();
            Log.d(TAG, "getSteeringWheelEPS(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarEpsManager.EPS_POWER_ASSISTED_STANDARD;
    }

    @Override
    public void setSteeringWheelEPS(int type) {
        if (mEpsManager == null) {
            Log.e(TAG, "setSteeringWheelEPS() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setSteeringWheelEPS(), type: " + type);
            mEpsManager.setSteeringWheelEPS(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
