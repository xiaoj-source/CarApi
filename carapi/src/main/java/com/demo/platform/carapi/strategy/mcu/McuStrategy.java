package com.demo.platform.carapi.strategy.mcu;

import android.car.Car;
import android.car.hardware.mcu.CarMcuManager;
import android.util.Log;

import com.demo.platform.carapi.callback.McuCallbackAdapter;
import com.demo.platform.carapi.strategy.BaseStrategy;

import java.util.Arrays;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class McuStrategy extends BaseStrategy implements IMcuStrategy {
    private static final String TAG = "McuStrategy";
    private CarMcuManager mMcuManager;

    public McuStrategy() {
        super();
    }

    @Override
    public String getServiceName() {
        return Car.XP_MCU_SERVICE;
    }

    @Override
    protected Integer[] getPropIds() {
        return McuCallbackAdapter.PROP_IDS;
    }

    @Override
    public void register() {
        super.register();
        mMcuManager = (CarMcuManager) mManager;
    }

    @Override
    public void setDriveMode(int mode) {
        if (mMcuManager == null) {
            Log.e(TAG, "setDriveMode() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setDriveMode(), mode: " + mode);
            mMcuManager.setDriveMode(mode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getHardwareVersion() {
        if (mMcuManager == null) {
            Log.e(TAG, "getHardwareVersion() error, Car not connected.");
            return 0;
        }
        try {
            int value = mMcuManager.getHardwareVersion();
            Log.d(TAG, "getHardwareVersion(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setHorn(boolean on) {
        if (mMcuManager == null) {
            Log.e(TAG, "setHorn() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setHorn(), on: " + on);
            mMcuManager.setHorn(on ? CarMcuManager.MCU_STATUS_ON : CarMcuManager.MCU_STATUS_OFF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setFlash(boolean on) {
        if (mMcuManager == null) {
            Log.e(TAG, "setFlash() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setFlash(), on: " + on);
            mMcuManager.setFlash(on ? CarMcuManager.MCU_STATUS_ON : CarMcuManager.MCU_STATUS_OFF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getHardwareCarType() {
        if (mMcuManager == null) {
            Log.e(TAG, "getHardwareCarType() error, Car not connected.");
            return "";
        }
        try {
            String value = mMcuManager.getHardwareCarType();
            Log.d(TAG, "getHardwareCarType(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String getHardwareCarStage() {
        if (mMcuManager == null) {
            Log.e(TAG, "getHardwareCarStage() error, Car not connected.");
            return "";
        }
        try {
            String value = mMcuManager.getHardwareCarStage();
            Log.d(TAG, "getHardwareCarStage(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void setShockValue2Mcu(int shockValue2Mcu) {
        if (mMcuManager == null) {
            Log.e(TAG, "setShockValue2Mcu() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setShockValue2Mcu(), shockValue2Mcu:" + shockValue2Mcu);
            mMcuManager.setIntProperty(CarMcuManager.ID_MCU_SHOCK_VALUE, 0, shockValue2Mcu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int[] getDtcReportEV() {
        if (mMcuManager == null) {
            Log.e(TAG, "getDtcReportEV() error, Car not connected.");
            return new int[2];
        }
        try {
            Log.d(TAG, "getDtcReportEV() start.");
            int[] value = mMcuManager.getDtcReportEv();
            Log.d(TAG, "getDtcReportEV():  " + Arrays.toString(value));
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new int[2];
    }

    @Override
    public int[] getIgStatus() {
        if (mMcuManager == null) {
            Log.e(TAG, "getDtcReportEV() error, Car not connected.");
            return new int[2];
        }
        try {
            int[] value = mMcuManager.getIgStatus();
            Log.d(TAG, "getIgStatus(), value:" + Arrays.toString(value));
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new int[2];
    }
}
