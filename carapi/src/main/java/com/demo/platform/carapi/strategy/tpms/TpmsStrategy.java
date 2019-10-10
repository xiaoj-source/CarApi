package com.demo.platform.carapi.strategy.tpms;

import android.car.Car;
import android.car.hardware.tpms.CarTpmsManager;
import android.util.Log;

import com.demo.platform.carapi.CarApiConstant;
import com.demo.platform.carapi.callback.TpmsCallbackAdapter;
import com.demo.platform.carapi.strategy.BaseStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class TpmsStrategy extends BaseStrategy implements ITpmsStrategy {
    private static final String TAG = "TpmsStrategy";
    private CarTpmsManager mTpmsManager;

    public TpmsStrategy() {
        super();
    }

    @Override
    public String getServiceName() {
        return Car.XP_TPMS_SERVICE;
    }

    @Override
    protected Integer[] getPropIds() {
        return TpmsCallbackAdapter.PROP_IDS;
    }

    @Override
    public void register() {
        super.register();
        mTpmsManager = (CarTpmsManager) mManager;
    }

    @Override
    public void calibrateTirePressure() {
        if (mTpmsManager == null) {
            Log.e(TAG, "calibrateTirePressure() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "calibrateTirePressure()");
            mTpmsManager.calibrateTirePressure();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getTirePressure() {
        if (mTpmsManager == null) {
            Log.e(TAG, "getTirePressure() error, Car not connected.");
            return CarApiConstant.Tpms.TYRE_FIXED;
        }
        try {
            Log.d(TAG, "getTirePressure() start.");
            int value = mTpmsManager.getTirePressureStatus();
            Log.d(TAG, "getTirePressure(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarApiConstant.Tpms.TYRE_FIXED;
    }
}
