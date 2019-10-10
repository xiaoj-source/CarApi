package com.demo.platform.carapi.strategy.avas;

import android.car.Car;
import android.car.hardware.avas.CarAvasManager;
import android.util.Log;

import com.demo.platform.carapi.callback.AvasCallbackAdapter;
import com.demo.platform.carapi.strategy.BaseStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class AvasStrategy extends BaseStrategy implements IAvasStrategy {
    private static final String TAG = "AvasStrategy";
    private CarAvasManager mAvasManager;

    public AvasStrategy() {
        super();
    }

    @Override
    public String getServiceName() {
        return Car.XP_AVAS_SERVICE;
    }

    @Override
    protected Integer[] getPropIds() {
        return AvasCallbackAdapter.PROP_IDS;
    }

    @Override
    public void register() {
        super.register();
        mAvasManager = (CarAvasManager) mManager;
    }

    @Override
    public int getAvasLowSpeedSound() {
        if (mAvasManager == null) {
            Log.e(TAG, "getAvasLowSpeedSound() error, Car not connected.");
            return 0;
        }
        try {
            int sound = mAvasManager.getAvasLowSpeedSound();
            Log.d(TAG, "getAvasLowSpeedSound(), sound:" + sound);
            return sound;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setAvasLowSpeedSound(int sound) {
        if (mAvasManager == null) {
            Log.e(TAG, "setAnalogSoundEffect() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setAvasLowSpeedSound(), sound: " + sound);
            mAvasManager.setAvasLowSpeedSound(sound);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAvasLowSpeedSoundSwitch(int enable) {
        if (mAvasManager == null) {
            Log.e(TAG, "setAnalogSoundEnable() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setAnalogSoundEnable(), enable: " + enable);
            mAvasManager.setAvasLowSpeedSoundSwitch(enable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getAvasLowSpeedSoundSwitch() {
        if (mAvasManager == null) {
            Log.e(TAG, "getAvasLowSpeedSoundSwitch() error, Car not connected.");
            return 0;
        }
        try {
            int soundSwitch = mAvasManager.getAvasLowSpeedSoundSwitch();
            Log.d(TAG, "getAvasLowSpeedSoundSwitch(), soundSwitch:" + soundSwitch);
            return soundSwitch;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
