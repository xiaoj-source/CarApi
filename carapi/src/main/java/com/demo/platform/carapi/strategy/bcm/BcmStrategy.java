package com.demo.platform.carapi.strategy.bcm;

import android.car.Car;
import android.car.hardware.bcm.CarBcmManager;
import android.util.Log;

import com.demo.platform.carapi.CarApiThreadPool;
import com.demo.platform.carapi.callback.BcmCallbackAdapter;
import com.demo.platform.carapi.strategy.BaseStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class BcmStrategy extends BaseStrategy implements IBcmStrategy {
    private static final String TAG = "BcmStrategy";
    private CarBcmManager mBcmManager;

    public BcmStrategy() {
        super();
    }

    @Override
    public String getServiceName() {
        return Car.XP_BCM_SERVICE;
    }

    @Override
    protected Integer[] getPropIds() {
        return BcmCallbackAdapter.PROP_IDS;
    }

    @Override
    public void register() {
        super.register();
        mBcmManager = (CarBcmManager) mManager;
    }

    @Override
    public void setLightMeHome(int value) {
        if (mBcmManager == null) {
            Log.e(TAG, "setLightMeHome() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setLightMeHome(), value: " + value);
            mBcmManager.setLightMeHome(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getLightMeHome() {
        if (mBcmManager == null) {
            Log.e(TAG, "getLightMeHome() error, Car not connected.");
            return -1;
        }
        try {
            Log.d(TAG, "getLightMeHome() start.");
            int value = mBcmManager.getLightMeHome();
            Log.d(TAG, "getLightMeHome() : " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getRearFogLamp() {
        if (mBcmManager == null) {
            Log.e(TAG, "getRearFogLamp() error, Car not connected.");
            return CarBcmManager.BCM_STATUS_OFF;
        }
        try {
            Log.d(TAG, "getRearFogLamp() start.");
            int value = mBcmManager.getRearFogLamp();
            Log.d(TAG, "getRearFogLamp(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarBcmManager.BCM_STATUS_OFF;
    }

    @Override
    public void setRearFogLamp(int value) {
        if (mBcmManager == null) {
            Log.e(TAG, "setRearFogLamp() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setRearFogLamp(), value:" + value);
            mBcmManager.setRearFogLamp(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setRearViewMirror(int type) {
        if (mBcmManager == null) {
            Log.e(TAG, "setRearViewMirror() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setRearViewMirror(), type: " + type);
            mBcmManager.setRearViewMirror(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setHeadLampGroup(int groupId) {
        if (mBcmManager == null) {
            Log.e(TAG, "setHeadLampGroup() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setHeadLampGroup() groupId: " + groupId);
            mBcmManager.setHeadLampGroup(groupId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getHeadLampGroup() {
        if (mBcmManager == null) {
            Log.e(TAG, "getHeadLampGroup() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getHeadLampGroup() start.");
            int value = mBcmManager.getHeadLampGroup();
            Log.d(TAG, "getHeadLampGroup(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public void setInternalLight(int value) {
        if (mBcmManager == null) {
            Log.e(TAG, "setInternalLight() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setInternalLight(), value:" + value);
            mBcmManager.setInternalLight(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getInternalLight() {
        if (mBcmManager == null) {
            Log.e(TAG, "getInternalLight() error, Car not connected.");
            return CarBcmManager.BCM_STATUS_OFF;
        }
        try {
            Log.d(TAG, "getInternalLight() start.");
            int value = mBcmManager.getInternalLight();
            Log.d(TAG, "getInternalLight(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarBcmManager.BCM_STATUS_OFF;
    }

    @Override
    public void setEmergencyBrakeWarning(int value) {
        if (mBcmManager == null) {
            Log.e(TAG, "setEmergencyBrakeWarning() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setEmergencyBrakeWarning(), value:" + value);
            mBcmManager.setEmergencyBrakeWarning(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getEmergencyBrakeWarning() {
        if (mBcmManager == null) {
            Log.e(TAG, "getEmergencyBrakeWarning() error, Car not connected.");
            return CarBcmManager.BCM_STATUS_OFF;
        }
        try {
            Log.d(TAG, "getEmergencyBrakeWarning() start.");
            int value = mBcmManager.getEmergencyBrakeWarning();
            Log.d(TAG, "getEmergencyBrakeWarning(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarBcmManager.BCM_STATUS_OFF;
    }

    @Override
    public void setAllWindowManualOrAuto(int type) {
        if (mBcmManager == null) {
            Log.e(TAG, "setAllWindowManualOrAuto() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setAllWindowManualOrAuto(), type: " + type);
            mBcmManager.setAllWindowManualOrAuto(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getAtwsState() {
        if (mBcmManager == null) {
            Log.e(TAG, "getATWSState() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getATWSState() start.");
            int value = mBcmManager.getAtwsState();
            Log.d(TAG, "getATWSState(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setWindowMoveCmd(int window, int cmd) {
        if (mBcmManager == null) {
            Log.e(TAG, "setWindowMoveCmd() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setWindowMoveCmd(), window:" + window + " cmd:" + cmd);
            mBcmManager.setWindowMoveCmd(window, cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setDriveAutoLock(int value) {
        if (mBcmManager == null) {
            Log.e(TAG, "setDriveAutoLock() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setDriveAutoLock(), value:" + value);
            mBcmManager.setDriveAutoLock(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getDriveAutoLock() {
        if (mBcmManager == null) {
            Log.e(TAG, "getDriveAutoLock() error, Car not connected.");
            return CarBcmManager.BCM_STATUS_OFF;
        }
        try {
            Log.d(TAG, "getDriveAutoLock() start.");
            int value = mBcmManager.getDriveAutoLock();
            Log.d(TAG, "getDriveAutoLock(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarBcmManager.BCM_STATUS_OFF;
    }

    @Override
    public void setParkingAutoUnlock(int value) {
        if (mBcmManager == null) {
            Log.e(TAG, "setParkingAutoUnlock() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setParkingAutoUnlock(), value: " + value);
            mBcmManager.setParkingAutoUnlock(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getParkingAutoUnlock() {
        if (mBcmManager == null) {
            Log.e(TAG, "getParkingAutoUnlock() error, Car not connected.");
            return CarBcmManager.BCM_STATUS_OFF;
        }
        try {
            Log.d(TAG, "getParkingAutoUnlock() start.");
            int value = mBcmManager.getParkingAutoUnlock();
            Log.d(TAG, "getParkingAutoUnlock() : " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarBcmManager.BCM_STATUS_OFF;
    }

    @Override
    public void setHazardLight(int value) {
        if (mBcmManager == null) {
            Log.e(TAG, "setHazardLight() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setHazardLight(), value: " + value);
            mBcmManager.setHazardLight(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setDoorLock(int value) {
        if (mBcmManager == null) {
            Log.e(TAG, "setDoorLock() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setDoorLock(), value: " + value);
            mBcmManager.setDoorLock(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setTrunk(int controlType) {
        if (mBcmManager == null) {
            Log.e(TAG, "setTrunk() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setTrunk(), controlType: " + controlType);
            mBcmManager.setTrunk(controlType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getTrunk() {
        if (mBcmManager == null) {
            Log.e(TAG, "getTrunk() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getTrunk() start.");
            int value = mBcmManager.getTrunk();
            Log.d(TAG, "getTrunk(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setWiperInterval(int level) {
        if (mBcmManager == null) {
            Log.e(TAG, "setWiperInterval() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setWiperInterval(), level: " + level);
            mBcmManager.setWiperInterval(level);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getChairWelcomeMode() {
        if (mBcmManager == null) {
            Log.e(TAG, "getChairWelcomeMode() error, Car not connected.");
            return CarBcmManager.BCM_STATUS_OFF;
        }
        try {
            Log.d(TAG, "getChairWelcomeMode() start.");
            int value = mBcmManager.getChairWelcomeMode();
            Log.d(TAG, "getChairWelcomeMode(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarBcmManager.BCM_STATUS_OFF;
    }

    @Override
    public void setChairWelcomeMode(int value) {
        if (mBcmManager == null) {
            Log.e(TAG, "setChairWelcomeMode() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setChairWelcomeMode(), value: " + value);
            mBcmManager.setChairWelcomeMode(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getElectricSeatBelt() {
        if (mBcmManager == null) {
            Log.e(TAG, "getElectricSeatBelt() error, Car not connected.");
            return CarBcmManager.BCM_STATUS_OFF;
        }
        try {
            Log.d(TAG, "getElectricSeatBelt() start.");
            int value = mBcmManager.getElectricSeatBelt();
            Log.d(TAG, "getElectricSeatBelt(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarBcmManager.BCM_STATUS_OFF;
    }

    @Override
    public void setElectricSeatBelt(int value) {
        if (mBcmManager == null) {
            Log.e(TAG, "setElectricSeatBelt() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setElectricSeatBelt(), value: " + value);
            mBcmManager.setElectricSeatBelt(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRearSeatBeltWarning() {
        if (mBcmManager == null) {
            Log.e(TAG, "getRearSeatBeltWarning() error, Car not connected.");
            return CarBcmManager.BCM_STATUS_OFF;
        }
        try {
            Log.d(TAG, "getRearSeatBeltWarning() start.");
            int value = mBcmManager.getRearSeatBeltWarning();
            Log.d(TAG, "getRearSeatBeltWarning() : " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarBcmManager.BCM_STATUS_OFF;
    }

    @Override
    public void setRearSeatBeltWarning(int value) {
        if (mBcmManager == null) {
            Log.e(TAG, "setRearSeatBeltWarning() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setRearSeatBeltWarning(), value:" + value);
            mBcmManager.setRearSeatBeltWarning(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setUnlockResponse(int type) {
        if (mBcmManager == null) {
            Log.e(TAG, "setUnlockResponse() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setUnlockResponse(), type:" + type);
            mBcmManager.setUnlockResponse(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getUnlockResponse() {
        if (mBcmManager == null) {
            Log.e(TAG, "getUnlockResponse() error, Car not connected.");
            return 0;
        }
        try {
            Log.d(TAG, "getUnlockResponse() start.");
            int value = mBcmManager.getUnlockResponse();
            Log.d(TAG, "getUnlockResponse(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int[] getDoorsState() {
        if (mBcmManager == null) {
            Log.e(TAG, "getDoorsState() error, Car not connected.");
            return new int[2];
        }
        try {
            Log.d(TAG, "getDoorsState() start.");
            int[] value = mBcmManager.getDoorsState();
            for (int i = 0; i < value.length; i++) {
                Log.d(TAG, "getDoorsState(), value[" + i + "]: " + value[i]);
            }
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new int[2];
    }

    @Override
    public float[] getWindowsState() {
        if (mBcmManager == null) {
            Log.e(TAG, "getWindowsState() error, Car not connected.");
            return new float[0];
        }
        try {
            Log.d(TAG, "getWindowsState() start.");
            float[] value = mBcmManager.getWindowsState();
            for (int i = 0; i < value.length; i++) {
                Log.d(TAG, "getWindowsState(), value[" + i + "]: " + value[i]);
            }
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new float[0];
    }

    @Override
    public int getSeatErrorState() {
        if (mBcmManager == null) {
            Log.e(TAG, "getSeatErrorState() error, Car not connected.");
            return CarBcmManager.BCM_SEAT_ERROR_NONE;
        }
        try {
            Log.d(TAG, "getSeatErrorState() start.");
            int value = mBcmManager.getSeatErrorState();
            Log.d(TAG, "getSeatErrorState(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarBcmManager.BCM_SEAT_ERROR_NONE;
    }

    @Override
    public void setVentilate() {
        if (mBcmManager == null) {
            Log.e(TAG, "setVentilate() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setVentilate()");
            mBcmManager.setVentilate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBackRightRowWindow(boolean open) {
        if (mBcmManager == null) {
            Log.e(TAG, "setBackRightRowWindow() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setBackRightRowWindow(), open: " + open);
            int cmd = open ? CarBcmManager.BCM_WINDOW_TYPE_DOWN_AUTO : CarBcmManager.BCM_WINDOW_TYPE_UP_AUTO;
            setWindowMoveCmd(CarBcmManager.WINDOW_BACK_RIGHT, cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBackLeftRowWindow(boolean open) {
        if (mBcmManager == null) {
            Log.e(TAG, "setBackLeftRowWindow() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setBackLeftRowWindow(), open: " + open);
            int cmd = open ? CarBcmManager.BCM_WINDOW_TYPE_DOWN_AUTO : CarBcmManager.BCM_WINDOW_TYPE_UP_AUTO;
            setWindowMoveCmd(CarBcmManager.WINDOW_BACK_LEFT, cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBackWindows(final boolean open) {
        CarApiThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                if (mBcmManager == null) {
                    Log.e(TAG, "setBackWindows() error, Car not connected.");
                    return;
                }
                try {
                    Log.d(TAG, "setBackWindows(), open: " + open);
                    setBackRightRowWindow(open);
                    Thread.sleep(300);
                    setBackLeftRowWindow(open);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void setFrontLeftRowWindow(boolean open) {
        if (mBcmManager == null) {
            Log.e(TAG, "setFrontLeftRowWindow() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setFrontLeftRowWindow(), open: " + open);
            int cmd = open ? CarBcmManager.BCM_WINDOW_TYPE_DOWN_AUTO : CarBcmManager.BCM_WINDOW_TYPE_UP_AUTO;
            setWindowMoveCmd(CarBcmManager.WINDOW_FRONT_LEFT, cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setFrontRightRowWindow(boolean open) {
        if (mBcmManager == null) {
            Log.e(TAG, "setFrontRightRowWindow() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setFrontRightRowWindow(), open: " + open);
            int cmd = open ? CarBcmManager.BCM_WINDOW_TYPE_DOWN_AUTO : CarBcmManager.BCM_WINDOW_TYPE_UP_AUTO;
            setWindowMoveCmd(CarBcmManager.WINDOW_FRONT_RIGHT, cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setFrontWindows(final boolean open) {
        CarApiThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                if (mBcmManager == null) {
                    Log.e(TAG, "setFrontWindows() error, Car not connected.");
                    return;
                }
                try {
                    Log.d(TAG, "setFrontWindows(), open: " + open);
                    setFrontRightRowWindow(open);
                    Thread.sleep(300);
                    setFrontLeftRowWindow(open);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void setPollingOpenCfg(int value) {
        if (mBcmManager == null) {
            Log.e(TAG, "setPollingOpenCfg() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setPollingOpenCfg(), value: " + value);
            mBcmManager.setIntProperty(CarBcmManager.ID_BCM_POLLING_OPEN_CFG, 0, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getPollingOpenCfg() {
        if (mBcmManager == null) {
            Log.e(TAG, "getPollingOpenCfg() error, Car not connected.");
            return CarBcmManager.BCM_STATUS_OFF;
        }
        try {
            return mBcmManager.getIntProperty(CarBcmManager.ID_BCM_POLLING_OPEN_CFG, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CarBcmManager.BCM_STATUS_OFF;
    }

    @Override
    public boolean getDriverBeltWarning() {
        if (mBcmManager == null) {
            Log.e(TAG, "getDriverBeltWarning() error, Car not connected.");
            return false;
        }
        try {
            return mBcmManager.getBooleanProperty(CarBcmManager.ID_BCM_DRIVER_SBLT_WARNING, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getDriveOnSeat() {
        if (mBcmManager == null) {
            Log.e(TAG, "getDriverOnSeat() error, Car not connected.");
            return 0;
        }
        try {
            int status = mBcmManager.getDriverOnSeat();
            Log.d(TAG, "getDriverOnSeat(), status:" + status);
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setRearViewAutoDownCfg(int cfg) {
        if (mBcmManager == null) {
            Log.e(TAG, "setRearViewAutoDownCfg() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setRearViewAutoDownCfg() cfg: " + cfg);
            mBcmManager.setRearViewAutoDownCfg(cfg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRearViewAutoDownCfg() {
        if (mBcmManager == null) {
            Log.e(TAG, "getRearViewAutoDownCfg() error, Car not connected.");
            return 0;
        }
        try {
            int value = mBcmManager.getRearViewAutoDownCfg();
            Log.d(TAG, "getRearViewAutoDownCfg(): " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setSeatHeatLevel(int level) {
        if (mBcmManager == null) {
            Log.e(TAG, "setSeatHeatLevel() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setSeatHeatLevel() level: " + level);
            mBcmManager.setBcmSeatHeatLevel(level);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setSeatBlowLevel(int level) {
        if (mBcmManager == null) {
            Log.e(TAG, "setSeatBlowLevel() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setSeatBlowLevel() level: " + level);
            mBcmManager.setBcmSeatHeatLevel(level);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setPsnSeatHeatLevel(int level) {
        if (mBcmManager == null) {
            Log.e(TAG, "setPsnSeatHeatLevel() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setPsnSeatHeatLevel() level: " + level);
            mBcmManager.setBcmPsnSeatHeatLevel(level);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBackDefrostMode(int status) {
        if (mBcmManager == null) {
            Log.e(TAG, "setBackDefrostMode() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setBackDefrostMode() status: " + status);
            mBcmManager.setBcmBackDefrostMode(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBackMirrorHeatMode(int status) {
        if (mBcmManager == null) {
            Log.e(TAG, "setBackMirrorHeatMode() error, Car not connected.");
            return;
        }
        try {
            Log.d(TAG, "setBackMirrorHeatMode() status: " + status);
            mBcmManager.setBcmBackMirrorHeatMode(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
