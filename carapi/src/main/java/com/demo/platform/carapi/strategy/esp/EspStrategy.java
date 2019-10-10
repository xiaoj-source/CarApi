package com.demo.platform.carapi.strategy.esp;

import android.car.Car;
import android.car.hardware.esp.CarEspManager;
import android.util.Log;

import com.demo.platform.carapi.callback.EspCallbackAdapter;
import com.demo.platform.carapi.strategy.BaseStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class EspStrategy extends BaseStrategy implements IEspStrategy {
    private static final String TAG = "EspStrategy";
    private CarEspManager mEspManager;

    public EspStrategy() {
        super();
    }

    @Override
    public String getServiceName() {
        return Car.XP_ESP_SERVICE;
    }

    @Override
    protected Integer[] getPropIds() {
        return EspCallbackAdapter.PROP_IDS;
    }

    @Override
    public void register() {
        super.register();
        mEspManager = (CarEspManager) mManager;
    }

    @Override
    public int getHdc() {
        if (mEspManager == null) {
            Log.e(TAG, "getHdc() error, Car not connected.");
            return CarEspManager.HDC_STATUS_INACTIVE;
        }
        try {
            Log.d(TAG, "getHdc() start.");
            int value = mEspManager.getHdc();
            Log.d(TAG, "getHdc(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarEspManager.HDC_STATUS_INACTIVE;
    }

    @Override
    public void setHdc(int enable) {
        if (mEspManager == null) {
            Log.e(TAG, "setHdc() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setHdc(), enable: " + enable);
            mEspManager.setHdc(enable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getEsp() {
        if (mEspManager == null) {
            Log.e(TAG, "getEsp() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getEsp() start.");
            int value = mEspManager.getEsp();
            Log.d(TAG, "getEsp(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setEsp(int type) {
        if (mEspManager == null) {
            Log.e(TAG, "setEsp() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setEsp(), type: " + type);
            mEspManager.setEsp(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getAvh() {
        if (mEspManager == null) {
            Log.e(TAG, "getAvh() error, Car not connected.");
            return CarEspManager.ESP_STATUS_INACTIVE;
        }
        try {
            Log.d(TAG, "getAvh() start.");
            int status = mEspManager.getAvh();
            Log.d(TAG, "getAvh(): " + status);
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarEspManager.ESP_STATUS_INACTIVE;
    }

    @Override
    public void setAvh(int status) {
        if (mEspManager == null) {
            Log.e(TAG, "setAvh() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setAvh(), status: " + status);
            mEspManager.setAvh(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean getEspFault() {
        if (mEspManager == null) {
            Log.e(TAG, "getEspFault() error, Car not connected.");
            return false;
        }
        try {
            return mEspManager.getBooleanProperty(CarEspManager.ID_ESP_ESP_FAULT, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean getHdcFault() {
        if (mEspManager == null) {
            Log.e(TAG, "getHdcFault() error, Car not connected.");
            return false;
        }
        try {
            return mEspManager.getBooleanProperty(CarEspManager.ID_ESP_HDC_FAULT, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean getAvhFault() {
        if (mEspManager == null) {
            Log.e(TAG, "getAvhFault() error, Car not connected.");
            return false;
        }
        try {
            return mEspManager.getBooleanProperty(CarEspManager.ID_ESP_AVH_FAULT, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
