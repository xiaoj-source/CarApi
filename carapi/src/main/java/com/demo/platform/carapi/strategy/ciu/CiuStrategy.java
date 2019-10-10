package com.demo.platform.carapi.strategy.ciu;

import android.car.Car;
import android.car.hardware.ciu.CarCiuManager;
import android.util.Log;

import com.demo.platform.carapi.callback.CiuCallbackAdapter;
import com.demo.platform.carapi.strategy.BaseStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class CiuStrategy extends BaseStrategy implements ICiuStrategy {
    private static final String TAG = "CiuStrategy";
    private CarCiuManager mCiuManager;

    public CiuStrategy() {
        super();
    }

    @Override
    public String getServiceName() {
        return Car.XP_CIU_SERVICE;
    }

    @Override
    protected Integer[] getPropIds() {
        return CiuCallbackAdapter.PROP_IDS;
    }

    @Override
    public void register() {
        super.register();
        mCiuManager = (CarCiuManager) mManager;
    }

    @Override
    public int getDmsStatus() {
        if (mCiuManager != null) {
            Log.e(TAG, "getDmsStatus() error, Car not connected.");
            return 0;
        }
        try {
            int status = mCiuManager.getDmsStatus();
            Log.d(TAG, "getDmsStatus(): " + status);
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setDmsStatus(int status) {
        if (mCiuManager != null) {
            Log.e(TAG, "getDmsStatus() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setDmsStatus(), status: " + status);
            mCiuManager.setDmsStatus(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCiuValid() {
        if (mCiuManager != null) {
            Log.e(TAG, "getCiuValid() error, Car not connected.");
            return 0;
        }
        try {
            int value = mCiuManager.getCiuValid();
            Log.d(TAG, "getCiuValid(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getFaceIdSw() {
        if (mCiuManager != null) {
            Log.e(TAG, "getFaceIdSw() error, Car not connected.");
            return 0;
        }
        try {
            int value = mCiuManager.getFaceIdSw();
            Log.d(TAG, "getFaceIdSw(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setFaceIdSw(int value) {
        if (mCiuManager != null) {
            Log.e(TAG, "setFaceIdSw() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setFaceIdSw(), value:" + value);
            mCiuManager.setFaceIdSw(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getFatigueStatus() {
        if (mCiuManager != null) {
            Log.e(TAG, "setFatigueStatus() error, Car not connected.");
            return 0;
        }
        try {
            int status = mCiuManager.getFatigueStatus();
            Log.d(TAG, "getFatigueStatus(): " + status);
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setFatigueStatus(int status) {
        if (mCiuManager != null) {
            Log.e(TAG, "setFatigueStatus() error, Car not connected.");
            return;
        }
        Log.d(TAG, "setFatigueStatus() status:" + status);
        try {
            mCiuManager.setFatigueStatus(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getDistractionStatus() {
        if (mCiuManager != null) {
            Log.e(TAG, "getDistractionStatus() error, Car not connected.");
            return 0;
        }
        try {
            int status = mCiuManager.getDistractionStatus();
            Log.d(TAG, "getDistractionStatus(): " + status);
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setDistractionStatus(int status) {
        if (mCiuManager != null) {
            Log.e(TAG, "setDistractionStatus() error, Car not connected.");
            return;
        }
        Log.d(TAG, "setDistractionStatus() status:" + status);
        try {
            mCiuManager.setDistractionStatus(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
