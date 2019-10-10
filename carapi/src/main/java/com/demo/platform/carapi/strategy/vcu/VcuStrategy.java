package com.demo.platform.carapi.strategy.vcu;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.vcu.CarVcuManager;
import android.util.Log;

import com.demo.platform.carapi.callback.VcuCallbackAdapter;
import com.demo.platform.carapi.strategy.BaseStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class VcuStrategy extends BaseStrategy implements IVcuStrategy {
    private static final String TAG = "VcuStrategy";
    private CarVcuManager mVcuManager;

    public VcuStrategy() {
        super();
    }

    @Override
    public String getServiceName() {
        return Car.XP_VCU_SERVICE;
    }

    @Override
    protected Integer[] getPropIds() {
        return VcuCallbackAdapter.PROP_IDS;
    }

    @Override
    public void register() {
        super.register();
        mVcuManager = (CarVcuManager) mManager;
    }

    @Override
    public int getDriveMode() {
        if (mVcuManager == null) {
            Log.e(TAG, "getDriveMode() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getDriveMode() start.");
            int value = mVcuManager.getDrivingMode();
            Log.d(TAG, "getDriveMode(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setEnergyRecycle(int level) {
        if (mVcuManager == null) {
            Log.e(TAG, "setEnergyRecycle() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setEnergyRecycle(), level:" + level);
            mVcuManager.setEnergyRecycleLevel(level);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public float getElectricityPercent() {
        if (mVcuManager == null) {
            Log.e(TAG, "getElectricityPercent() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getElectricityPercent() start.");
            float value = mVcuManager.getElectricityPercent();
            Log.d(TAG, "getElectricityPercent(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public float getCarSpeed() {
        if (mVcuManager == null) {
            Log.e(TAG, "getCarSpeed() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getCarSpeed() start.");
            float value = mVcuManager.getRawCarSpeed();
            Log.d(TAG, "getCarSpeed(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getSystemReady() {
        if (mVcuManager == null) {
            Log.e(TAG, "getSystemReady() error, Car not connected.");
            return 0;
        }
        try {
            int status = mVcuManager.getEvSysReady();
            Log.d(TAG, "getSystemReady(): " + status);
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public float getRawCarSpeed() {
        if (mVcuManager == null) {
            Log.e(TAG, "getRawCarSpeed() error, Car not connected.");
            return 0;
        }
        try {
            return mVcuManager.getFloatProperty(CarVcuManager.ID_VCU_RAW_CAR_SPEED, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getIntProperty(int propertyId, int area) {
        if (mVcuManager == null) {
            Log.e(TAG, "getIntProperty error, Car not connected.");
            return 0;
        }
        try {
            return mVcuManager.getIntProperty(propertyId, area);
        } catch (CarNotConnectedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
