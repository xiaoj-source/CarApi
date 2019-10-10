package com.demo.platform.carapi.strategy.msm;

import android.car.Car;
import android.car.hardware.msm.CarMsmManager;
import android.util.Log;

import com.demo.platform.carapi.callback.MsmCallbackAdapter;
import com.demo.platform.carapi.strategy.BaseStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class MsmStrategy extends BaseStrategy implements IMsmStrategy {
    private static final String TAG = "MsmStrategy";
    private CarMsmManager mMsmManager;

    public MsmStrategy() {
        super();
    }

    @Override
    public String getServiceName() {
        return Car.XP_MSM_SERVICE;
    }

    @Override
    protected Integer[] getPropIds() {
        return MsmCallbackAdapter.PROP_IDS;
    }

    @Override
    public void register() {
        super.register();
        mMsmManager = (CarMsmManager) mManager;
    }

    @Override
    public void setDriverSeatHorizMove(int control, int direction) {
        if (mMsmManager == null) {
            Log.e(TAG, "setDriverSeatHorizMove error, Car not connected");
            return;
        }
        try {
            Log.d(TAG, "setDriverSeatHorizMove(), control:" + control + "  direction:" + direction);
            mMsmManager.setDriverSeatHorizMove(control, direction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setDriverSeatBackMove(int control, int direction) {
        if (mMsmManager == null) {
            Log.e(TAG, "setDriverSeatBackMove error, Car not connected");
            return;
        }
        try {
            Log.d(TAG, "setDriverSeatBackMove(), control:" + control + "  direction:" + direction);
            mMsmManager.setDriverSeatBackMove(control, direction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setDriverSeatVertiMove(int control, int direction) {
        if (mMsmManager == null) {
            Log.e(TAG, "setDriverSeatVertiMove error, Car not connected");
            return;
        }
        try {
            Log.d(TAG, "setDriverSeatVertiMove(), control:" + control + "  direction:" + direction);
            mMsmManager.setDriverSeatVertiMove(control, direction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setDriverSeatHorizPosition(int pos) {
        if (mMsmManager == null) {
            Log.e(TAG, "setDriverSeatHorizPosition error, Car not connected");
            return;
        }
        try {
            Log.d(TAG, "setDriverSeatHorizPosition(), pos:" + pos);
            mMsmManager.setDriverSeatHorizPosition(pos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getDriverSeatHorizPosition() {
        if (mMsmManager == null) {
            Log.e(TAG, "getDriverSeatHorizPosition() error, Car not connected");
            return -1;
        }
        try {
            int value = mMsmManager.getDriverSeatHorizPosition();
            Log.d(TAG, "getDriverSeatHorizPosition(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void setDriverSeatVertiPosition(int pos) {
        if (mMsmManager == null) {
            Log.e(TAG, "setDriverSeatVertiPosition error, Car not connected");
            return;
        }
        try {
            Log.d(TAG, "setDriverSeatVertiPosition(), pos:" + pos);
            mMsmManager.setDriverSeatVertiPosition(pos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getDriverSeatVertiPosition() {
        if (mMsmManager == null) {
            Log.e(TAG, "getDriverSeatVertiPosition() error, Car not connected");
            return -1;
        }
        try {
            int value = mMsmManager.getDriverSeatVertiPosition();
            Log.d(TAG, "getDriverSeatVertiPosition(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void setDriverSeatBackPosition(int pos) {
        if (mMsmManager == null) {
            Log.e(TAG, "setDriverSeatBackPosition error, Car not connected");
            return;
        }
        try {
            Log.d(TAG, "setDriverSeatBackPosition(), pos:" + pos);
            mMsmManager.setDriverSeatBackPosition(pos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getDriverSeatBackPosition() {
        if (mMsmManager == null) {
            Log.e(TAG, "getDriverSeatBackPosition() error, Car not connected");
            return -1;
        }
        try {
            int value = mMsmManager.getDriverSeatBackPosition();
            Log.d(TAG, "getDriverSeatBackPosition(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0-1;
    }
}
