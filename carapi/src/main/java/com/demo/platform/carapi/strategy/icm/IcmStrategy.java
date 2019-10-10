package com.demo.platform.carapi.strategy.icm;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.CarPropertyValue;
import android.car.hardware.icm.CarIcmManager;
import android.util.Log;

import com.demo.platform.carapi.callback.IcmCallbackAdapter;
import com.demo.platform.carapi.strategy.BaseStrategy;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class IcmStrategy extends BaseStrategy implements IIcmStrategy {
    private static final String TAG = "IcmStrategy";
    private CarIcmManager mIcmManager;

    public IcmStrategy() {
        super();
    }

    @Override
    public String getServiceName() {
        return Car.XP_ICM_SERVICE;
    }

    @Override
    protected Integer[] getPropIds() {
        return IcmCallbackAdapter.PROP_IDS;
    }

    @Override
    public void register() {
        super.register();
        mIcmManager = (CarIcmManager) mManager;
    }

    private boolean checkManager() {
        if (mIcmManager == null) {
            Log.e(TAG, "checkManager() error, Car not connected.");
            return false;
        }
        return true;
    }

    @Override
    public void resetMeterMileageA() {
        if (mIcmManager == null) {
            Log.e(TAG, "resetMeterMileageA() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "resetMeterMileageA()");
            mIcmManager.resetMeterMileageA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void resetMeterMileageB() {
        if (mIcmManager == null) {
            Log.e(TAG, "resetMeterMileageB() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "resetMeterMileageB()");
            mIcmManager.resetMeterMileageB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getIcmAlarmVolume() {
        if (mIcmManager == null) {
            Log.e(TAG, "getIcmAlarmVolume() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getIcmAlarmVolume() start.");
            int value = mIcmManager.getIcmAlarmVolume();
            Log.d(TAG, "getIcmAlarmVolume() : " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setIcmAlarmVolume(int volumeLevel) {
        if (mIcmManager == null) {
            Log.e(TAG, "setIcmAlarmVolume() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setIcmAlarmVolume(), volumeLevel:" + volumeLevel);
            mIcmManager.setIcmAlarmVolume(volumeLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setIcmTimeFormat(int index) {
        if (mIcmManager == null) {
            Log.e(TAG, "setIcmTimeFormat() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setIcmTimeFormat(), index:" + index);
            mIcmManager.setIcmTimeFormat(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getIcmTemperature() {
        if (mIcmManager == null) {
            Log.e(TAG, "getIcmTemperature() error, Car not connected.");
            return CarIcmManager.ICM_SWITCH_CLOSE;
        }
        try {
            Log.d(TAG, "getIcmTemperature() start.");
            int value = mIcmManager.getIcmTemperature();
            Log.d(TAG, "getIcmTemperature() : " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarIcmManager.ICM_SWITCH_CLOSE;
    }

    @Override
    public void setIcmTemperature(int value) {
        if (mIcmManager == null) {
            Log.e(TAG, "setIcmTemperature() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setIcmTemperature(), value:" + value);
            mIcmManager.setIcmTemperature(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getIcmWindPower() {
        if (mIcmManager == null) {
            Log.e(TAG, "getIcmWindPower() error, Car not connected.");
            return CarIcmManager.ICM_SWITCH_CLOSE;
        }
        try {
            Log.d(TAG, "getIcmWindPower() start.");
            int value = mIcmManager.getIcmWindPower();
            Log.d(TAG, "getIcmWindPower() : " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarIcmManager.ICM_SWITCH_CLOSE;
    }

    @Override
    public void setIcmWindPower(int value) {
        if (mIcmManager == null) {
            Log.e(TAG, "setIcmWindPower() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setIcmWindPower(), value:" + value);
            mIcmManager.setIcmWindPower(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getIcmWindMode() {
        if (mIcmManager == null) {
            Log.e(TAG, "getIcmWindMode() error, Car not connected.");
            return CarIcmManager.ICM_SWITCH_CLOSE;
        }
        try {
            Log.d(TAG, "getIcmWindMode() start.");
            int value = mIcmManager.getIcmWindMode();
            Log.d(TAG, "getIcmWindMode() : " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarIcmManager.ICM_SWITCH_CLOSE;
    }

    @Override
    public void setIcmWindMode(int value) {
        if (mIcmManager == null) {
            Log.e(TAG, "setIcmWindMode() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setIcmWindMode(), value:" + value);
            mIcmManager.setIcmWindMode(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getIcmMediaSource() {
        if (mIcmManager == null) {
            Log.e(TAG, "getIcmMediaSource() error, Car not connected.");
            return CarIcmManager.ICM_SWITCH_CLOSE;
        }
        try {
            Log.d(TAG, "getIcmMediaSource() start.");
            int value = mIcmManager.getIcmMediaSource();
            Log.d(TAG, "getIcmMediaSource() : " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarIcmManager.ICM_SWITCH_CLOSE;
    }

    @Override
    public void setIcmMediaSource(int value) {
        if (mIcmManager == null) {
            Log.e(TAG, "setIcmMediaSource() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setIcmMediaSource(), value:" + value);
            mIcmManager.setIcmMediaSource(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getIcmScreenLight() {
        if (mIcmManager == null) {
            Log.e(TAG, "getIcmScreenLight() error, Car not connected.");
            return CarIcmManager.ICM_SWITCH_CLOSE;
        }
        try {
            Log.d(TAG, "getIcmScreenLight() start.");
            int value = mIcmManager.getIcmScreenLight();
            Log.d(TAG, "getIcmScreenLight() : " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarIcmManager.ICM_SWITCH_CLOSE;
    }

    @Override
    public void setIcmScreenLight(int value) {
        if (mIcmManager == null) {
            Log.e(TAG, "setIcmScreenLight() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setIcmScreenLight(), value:" + value);
            mIcmManager.setIcmScreenLight(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setIcmNavigation(int value) {
        if (mIcmManager == null) {
            Log.e(TAG, "setIcmNavigation() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setIcmNavigation(), value:" + value);
            mIcmManager.setIcmNavigation(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setIcmDayNightSwitch(int value) {
        if (mIcmManager == null) {
            Log.e(TAG, "setIcmDayNightSwitch() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setIcmDayNightSwitch(), value:" + value);
            mIcmManager.setIcmDayNightSwitch(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSpeedLimitWarningSwitch() {
        if (mIcmManager == null) {
            Log.e(TAG, "getSpeedLimitWarningSwitch() error, Car not connected.");
            return CarIcmManager.ICM_SWITCH_CLOSE;
        }
        try {
            Log.d(TAG, "getSpeedLimitWarningSwitch() start.");
            int value = mIcmManager.getSpeedLimitWarningSwitch();
            Log.d(TAG, "getSpeedLimitWarningSwitch() : " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarIcmManager.ICM_SWITCH_CLOSE;
    }

    @Override
    public void setSpeedLimitWarningSwitch(int value) {
        if (mIcmManager == null) {
            Log.e(TAG, "setSpeedLimitWarningSwitch() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setSpeedLimitWarningSwitch(), enable:" + value);
            mIcmManager.setSpeedLimitWarningSwitch(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSpeedLimitWarningValue() {
        if (mIcmManager == null) {
            Log.e(TAG, "getSpeedLimitWarningValue() error, Car not connected.");
            return 80;
        }
        try {
            Log.d(TAG, "getSpeedLimitWarningValue() start.");
            int value = mIcmManager.getSpeedLimitWarningValue();
            Log.d(TAG, "getSpeedLimitWarningValue() : " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 80;
    }

    @Override
    public void setSpeedLimitWarningValue(int value) {
        if (mIcmManager == null) {
            Log.e(TAG, "setSpeedLimitWarningValue() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setSpeedLimitWarningValue(), value:" + value);
            mIcmManager.setSpeedLimitWarningValue(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setIcmWindBlowMode(int mode) {
        Log.d(TAG, "setIcmWindBlowMode(), mode:" + mode);
        if (checkManager()) {
            try {
                mIcmManager.setIcmWindBlowMode(mode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setIcmWindLevel(int level) {
        Log.d(TAG, "setIcmWindLevel(), level:" + level);
        if (checkManager()) {
            try {
                mIcmManager.setIcmWindLevel(level);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setIcmDriverTempValue(float value) {
        Log.d(TAG, "setIcmDriverTempValue(), value:" + value);
        if (checkManager()) {
            try {
                mIcmManager.setIcmDriverTempValue(value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setIcmSystemTimeValue(int hour, int minutes) {
        Calendar calendar = Calendar.getInstance();
        Log.d(TAG, "setIcmSystemTimeValue hour=" + calendar.get(Calendar.HOUR_OF_DAY) + "minute=" + calendar.get(Calendar.MINUTE));
        if (checkManager()) {
            try {
                mIcmManager.setIcmSystemTimeValue(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setIcmMultiProperty(LinkedList<HashMap<Integer, Object>> list) {
        if (list == null) {
            Log.e(TAG, "params linkedList is null");
            return;
        }
        LinkedList<CarPropertyValue> paramLinkedList = new LinkedList<>();
        for (HashMap<Integer, Object> keyValue : list) {
            for (Map.Entry<Integer, Object> entry : keyValue.entrySet()) {
                CarPropertyValue<Integer> value = new CarPropertyValue(entry.getKey(), entry.getValue());
                paramLinkedList.add(value);
                Log.d(TAG, "SetIcmMultiProperty Add Property = " + value.toString());
            }
        }
        Log.d(TAG, "SetIcmMultiProperty, linkedList size = " + list.size() + ", paramLinkedList size = " + paramLinkedList.size());
        if (mIcmManager == null) {
            Log.e(TAG, "setIcmMultiProperty() error, Car not connected.");
            return;
        }
        try {
            mIcmManager.setMultiProperty(paramLinkedList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setIntProperty(int propertyId, int val) {
        if (mIcmManager == null) {
            Log.e(TAG, "setIntProperty() error, Car not connected.");
            return;
        }
        try {
            mIcmManager.setIntProperty(propertyId, 0, val);
        } catch (CarNotConnectedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public float getMeterMileageA() {
        if (mIcmManager == null) {
            Log.e(TAG, "getMeterMileageA() error, Car not connected.");
            return 0;
        }
        try {
            float value = mIcmManager.getMeterMileageA();
            Log.d(TAG, "getMeterMileageA(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public float getMeterMileageB() {
        if (mIcmManager == null) {
            Log.e(TAG, "getMeterMileageB() error, Car not connected.");
            return 0;
        }
        try {
            float value = mIcmManager.getMeterMileageB();
            Log.d(TAG, "getMeterMileageB(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public float getDriveTotalMileage() {
        if (mIcmManager == null) {
            Log.e(TAG, "getDriveTotalMileage() error, Car not connected.");
            return 0;
        }
        try {
            float value = mIcmManager.getDriveTotalMileage();
            Log.d(TAG, "getDriveTotalMileage(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public float getLastChargeMileage() {
        if (mIcmManager == null) {
            Log.e(TAG, "getLastChargeMileage() error, Car not connected.");
            return 0;
        }
        try {
            float value = mIcmManager.getLastChargeMileage();
            Log.d(TAG, "getLastChargeMileage(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public float getLastStartUpMileage() {
        if (mIcmManager == null) {
            Log.e(TAG, "getLastStartUpMileage() error, Car not connected.");
            return 0;
        }
        try {
            float value = mIcmManager.getLastStartUpMileage();
            Log.d(TAG, "getLastStartUpMileage(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
