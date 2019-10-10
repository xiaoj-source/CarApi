package com.demo.platform.carapi.strategy.hvac;

import android.car.Car;
import android.car.hardware.hvac.CarHvacManager;
import android.util.Log;

import com.demo.platform.carapi.callback.HvacCallbackAdapter;
import com.demo.platform.carapi.strategy.BaseStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class HvacStrategy extends BaseStrategy implements IHvacStrategy {
    private static final String TAG = "HvacStrategy";
    private CarHvacManager mHvacManager;

    public HvacStrategy() {
        super();
    }

    @Override
    public String getServiceName() {
        return Car.HVAC_SERVICE;
    }

    @Override
    protected Integer[] getPropIds() {
        return HvacCallbackAdapter.PROP_IDS;
    }

    @Override
    public void register() {
        super.register();
        mHvacManager = (CarHvacManager) mManager;
    }

    private boolean checkManager() {
        if (mHvacManager == null) {
            Log.e(TAG, "checkManager() error, Car not connected.");
            return false;
        }
        return true;
    }

    @Override
    public void setHvacPowerMode(int enable) {
        Log.d(TAG, "setSeatHeatLevel() enable: " + enable);
        if (checkManager()) {
            try {
                mHvacManager.setHvacPowerMode(enable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setHvacTempAcMode(int enable) {
        Log.d(TAG, "setHvacTempAcMode() enable: " + enable);
        if (checkManager()) {
            try {
                mHvacManager.setHvacTempAcMode(enable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setHvacTempLeftSyncMode(int enable) {
        Log.d(TAG, "setSeatHeatLevel() mode: " + enable);
        if (checkManager()) {
            try {
                mHvacManager.setHvacTempLeftSyncMode(enable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setHvacTempDriverValue(float level) {
        Log.d(TAG, "setHvacTempDriverValue() level: " + level);
        if (checkManager()) {
            try {
                mHvacManager.setHvacTempDriverValue(level);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setHvacTempPsnValue(float level) {
        Log.d(TAG, "setHvacTempPsnValue() level: " + level);
        if (checkManager()) {
            try {
                mHvacManager.setHvacTempPsnValue(level);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setHvacAutoMode(int enable) {
        Log.d(TAG, "setSeatHeatLevel() enable: " + enable);
        if (checkManager()) {
            try {
                mHvacManager.setHvacAutoMode(enable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setHvacCirculatisetMode(int enable) {
        Log.d(TAG, "setSeatHeatLevel() enable: " + enable);
        if (checkManager()) {
            try {
                mHvacManager.setHvacPowerMode(enable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setHvacFrontDefrostMode(int enable) {
        Log.d(TAG, "setHvacFrontDefrostMode() enable: " + enable);
        if (checkManager()) {
            try {
                mHvacManager.setHvacFrontDefrostMode(enable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setHvacWindBlowMode(int mode) {
        Log.d(TAG, "setSeatHeatLevel() mode: " + mode);
        if (checkManager()) {
            try {
                mHvacManager.setHvacWindBlowMode(mode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setHvacWindSpeedLevel(int level) {
        Log.d(TAG, "setHvacWindSpeedLevel() level: " + level);
        if (checkManager()) {
            try {
                mHvacManager.setHvacWindSpeedLevel(level);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setHvacQualityPurgeMode(int enable) {
        Log.d(TAG, "setHvacQualityPurgeMode() enable: " + enable);
        if (checkManager()) {
            try {
                mHvacManager.setHvacQualityPurgeMode(enable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setEconMode(int enable) {
        Log.d(TAG, "setEconMode() enable: " + enable);
        if (checkManager()) {
            try {
                mHvacManager.setEconMode(enable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
