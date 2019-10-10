package com.demo.platform.carapi.strategy.scu;

import android.car.Car;
import android.car.hardware.scu.CarScuManager;
import android.util.Log;

import com.demo.platform.carapi.callback.ScuCallbackAdapter;
import com.demo.platform.carapi.strategy.BaseStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class ScuStrategy extends BaseStrategy implements IScuStrategy {
    private static final String TAG = "ScuStrategy";
    private CarScuManager mScuManager;

    public ScuStrategy() {
        super();
    }

    @Override
    public String getServiceName() {
        return Car.XP_SCU_SERVICE;
    }

    @Override
    protected Integer[] getPropIds() {
        return ScuCallbackAdapter.PROP_IDS;
    }

    @Override
    public void register() {
        super.register();
        mScuManager = (CarScuManager) mManager;
    }

    @Override
    public int getFrontCollisionSecurity() {
        if (mScuManager == null) {
            Log.e(TAG, "getFrontCollisionSecurity() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getFrontCollisionSecurity() start.");
            int value = mScuManager.getFrontCollisionSecurity();
            Log.d(TAG, "getFrontCollisionSecurity(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setFrontCollisionSecurity(int type) {
        if (mScuManager == null) {
            Log.e(TAG, "setFrontCollisionSecurity() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setFrontCollisionSecurity(), type: " + type);
            mScuManager.setFrontCollisionSecurity(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getIntelligentSpeedLimit() {
        if (mScuManager == null) {
            Log.e(TAG, "getIntelligentSpeedLimit() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getIntelligentSpeedLimit() start.");
            int value = mScuManager.getIntelligentSpeedLimit();
            Log.d(TAG, "getIntelligentSpeedLimit(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setIntelligentSpeedLimit(int type) {
        if (mScuManager == null) {
            Log.e(TAG, "setIntelligentSpeedLimit() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setIntelligentSpeedLimit(), type: " + type);
            mScuManager.setIntelligentSpeedLimit(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setLaneChangeAssist(int type) {
        if (mScuManager == null) {
            Log.e(TAG, "setLaneChangeAssist() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setLaneChangeAssist(), type: " + type);
            mScuManager.setLaneChangeAssist(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSideReversingWarning() {
        if (mScuManager == null) {
            Log.e(TAG, "getSideReversingWarning() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getSideReversingWarning() start.");
            int value = mScuManager.getSideReversingWarning();
            Log.d(TAG, "getSideReversingWarning(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setSideReversingWarning(int type) {
        if (mScuManager == null) {
            Log.e(TAG, "setSideReversingWarning() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setSideReversingWarning(), type: " + type);
            mScuManager.setSideReversingWarning(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getLaneDepartureWarning() {
        if (mScuManager == null) {
            Log.e(TAG, "getLaneDepartureWarning() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getLaneDepartureWarning() start.");
            int value = mScuManager.getLaneDepartureWarning();
            Log.d(TAG, "getLaneDepartureWarning(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setLaneDepartureWarning(int type) {
        if (mScuManager == null) {
            Log.e(TAG, "setLaneDepartureWarning() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setLaneDepartureWarning(), type: " + type);
            mScuManager.setLaneDepartureWarning(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getBlindAreaDetectionWarning() {
        if (mScuManager == null) {
            Log.e(TAG, "getBlindAreaDetectionWarning() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getBlindAreaDetectionWarning() start.");
            int value = mScuManager.getBlindAreaDetectionWarning();
            Log.d(TAG, "getBlindAreaDetectionWarning(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setBlindAreaDetectionWarning(int type) {
        if (mScuManager == null) {
            Log.e(TAG, "setBlindAreaDetectionWarning() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setBlindAreaDetectionWarning(), type: " + type);
            mScuManager.setBlindAreaDetectionWarning(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setLaneMiddleAssist(int value) {
        if (mScuManager == null) {
            Log.e(TAG, "setLaneMiddleAssist() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setLaneMiddleAssist(), value:" + value);
            mScuManager.setLaneAlignmentAssist(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean getKeyPark() {
        if (mScuManager == null) {
            Log.e(TAG, "getKeyPark() error, Car not connected.");
            return false;
        }
        try {
            return mScuManager.getBooleanProperty(CarScuManager.ID_SCU_KEYPARK_SWST, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
