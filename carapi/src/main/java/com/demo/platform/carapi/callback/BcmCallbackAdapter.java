package com.demo.platform.carapi.callback;

import android.car.hardware.bcm.CarBcmManager;

import com.demo.platform.utils.ArrayUtils;

/**
 * Created by xiaojun
 *
 * @date 19-3-22
 */
public class BcmCallbackAdapter extends BaseCallbackAdapter {
    private static final String TAG = "BcmCallbackAdapter";
    public static final Integer[] PROP_IDS = {
            CarBcmManager.ID_BCM_LIGHT_ME_HOME,
            CarBcmManager.ID_BCM_REAR_FOG_LAMP_ON,
            CarBcmManager.ID_BCM_HEAD_BEAM,
            CarBcmManager.ID_BCM_FRONT_LIGHT_GROUP_MODE,
            CarBcmManager.ID_BCM_INTERNAL_LIGHT_ON,
            CarBcmManager.ID_BCM_EMERGENCY_BRAKE_WARNING,
            CarBcmManager.ID_BCM_ATWS,
            CarBcmManager.ID_BCM_DRIVE_AUTO_LOCK,
            CarBcmManager.ID_BCM_PARKING_AUTO_UNLOCK,
            CarBcmManager.ID_BCM_TRUNK,
            CarBcmManager.ID_BCM_CHAIR_WELCOME_MODE_ON,
            CarBcmManager.ID_BCM_ELECTRIC_SEAT_BELT,
            CarBcmManager.ID_BCM_REAR_SEAT_BELT_WARNING_ON,
            CarBcmManager.ID_BCM_UNLOCK_RESPONSE,
            CarBcmManager.ID_BCM_DOOR_STATE,
            CarBcmManager.ID_BCM_WINDOW_POSITION,
            CarBcmManager.ID_BCM_LOW_BEAM,
            CarBcmManager.ID_BCM_PARKING_LAMP,
            CarBcmManager.ID_BCM_POWERMODE,
            CarBcmManager.ID_BCM_WELCOME_ST,
            CarBcmManager.ID_BCM_POLLING_OPEN_CFG,
            CarBcmManager.ID_BCM_DRIVER_SBLT_WARNING,
            CarBcmManager.ID_BCM_RAUTODOWN_CFG,
            CarBcmManager.ID_BCM_SEAT_VENT_LEVEL,
            CarBcmManager.ID_BCM_SEAT_HEAT_LEVEL,
            CarBcmManager.ID_BCM_PSN_SEAT_HEAT_LEVEL,
            CarBcmManager.ID_BCM_BACK_MIRROR_HEAT,
            CarBcmManager.ID_BCM_REAR_DEFROST_ON,
    };

    @Override
    final protected void onChangeEvent(int propertyId, Object data) {
        switch (propertyId) {
            case CarBcmManager.ID_BCM_LIGHT_ME_HOME:
                onLightMeHome((int) data);
                break;

            case CarBcmManager.ID_BCM_REAR_FOG_LAMP_ON:
                onRearFogLampOn((int) data);
                break;

            case CarBcmManager.ID_BCM_HEAD_BEAM:
                onHeadBeam((int) data);
                break;

            case CarBcmManager.ID_BCM_FRONT_LIGHT_GROUP_MODE:
                onHeadLampGroup((int) data);
                break;

            case CarBcmManager.ID_BCM_INTERNAL_LIGHT_ON:
                onInternalLightOn((int) data);
                break;

            case CarBcmManager.ID_BCM_EMERGENCY_BRAKE_WARNING:
                onEmergencyBrakeWarning((int) data);
                break;

            case CarBcmManager.ID_BCM_ATWS:
                onAtws((int) data);
                break;

            case CarBcmManager.ID_BCM_DRIVE_AUTO_LOCK:
                onDriveAutoLock((int) data);
                break;

            case CarBcmManager.ID_BCM_PARKING_AUTO_UNLOCK:
                onParkingAutoUnLock((int) data);
                break;

            case CarBcmManager.ID_BCM_TRUNK:
                onTrunk((int) data);
                break;

            case CarBcmManager.ID_BCM_CHAIR_WELCOME_MODE_ON:
                onChairWelcomeModeOn((int) data);
                break;

            case CarBcmManager.ID_BCM_ELECTRIC_SEAT_BELT:
                onElectricSeatBelt((int) data);
                break;

            case CarBcmManager.ID_BCM_REAR_SEAT_BELT_WARNING_ON:
                onRealSeatBeltWarningOn((int) data);
                break;

            case CarBcmManager.ID_BCM_UNLOCK_RESPONSE:
                onUnLockResponse((int) data);
                break;

            case CarBcmManager.ID_BCM_DOOR_STATE:
                onDoorState(ArrayUtils.toPrimitive((Integer[]) data, 0));
                break;

            case CarBcmManager.ID_BCM_WINDOW_POSITION:
                onWindowPosition(ArrayUtils.toPrimitive((Float[]) data, 0));
                break;

            case CarBcmManager.ID_BCM_LOW_BEAM:
                onLowBeam((int) data);
                break;

            case CarBcmManager.ID_BCM_PARKING_LAMP:
                onParkingLamp((int) data);
                break;

            case CarBcmManager.ID_BCM_POWERMODE:
                onPowerMode((int) data);
                break;

            case CarBcmManager.ID_BCM_WELCOME_ST:
                onWelcomeSt((int) data);
                break;

            case CarBcmManager.ID_BCM_POLLING_OPEN_CFG:
                onPollingOpenCfg((int) data);
                break;

            case CarBcmManager.ID_BCM_DRIVER_SBLT_WARNING:
                onDriverSbltWarning((int) data);
                break;

            case CarBcmManager.ID_BCM_RAUTODOWN_CFG:
                onRauToDown((int) data);
                break;

            case CarBcmManager.ID_BCM_SEAT_VENT_LEVEL:
                onSeatVentLevel((int) data);
                break;

            case CarBcmManager.ID_BCM_SEAT_HEAT_LEVEL:
                onSeatHeatLevel((int) data);
                break;

            case CarBcmManager.ID_BCM_PSN_SEAT_HEAT_LEVEL:
                onPsnSeatHeatLevel((int) data);
                break;

            case CarBcmManager.ID_BCM_BACK_MIRROR_HEAT:
                onBackMirrorHeat((int) data);
                break;

            case CarBcmManager.ID_BCM_REAR_DEFROST_ON:
                onRearDefrostOn((int) data);
                break;

            default:
                break;
        }
    }

    public void onRauToDown(int value) {
    }

    /**
     * 照我回家
     *
     * @param value
     */
    public void onLightMeHome(int value) {
    }

    /**
     * 后雾灯
     *
     * @param value
     */
    public void onRearFogLampOn(int value) {
    }

    /**
     * 远光灯
     *
     * @param value
     */
    public void onHeadBeam(int value) {
    }

    /**
     * @param value
     */
    public void onHeadLampGroup(int value) {
    }

    /**
     * @param value
     */
    public void onInternalLightOn(int value) {
    }

    /**
     * @param value
     */
    public void onEmergencyBrakeWarning(int value) {
    }

    /**
     * @param value
     */
    public void onAtws(int value) {
    }

    /**
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     *
     * @param value
     */
    public void onDriveAutoLock(int value) {
    }

    /**
     * @param value
     */
    public void onParkingAutoUnLock(int value) {
    }

    /**
     * @param value
     */
    public void onTrunk(int value) {
    }

    /**
     * @param value
     */
    public void onChairWelcomeModeOn(int value) {
    }

    /**
     * @param value
     */
    public void onElectricSeatBelt(int value) {
    }

    /**
     * @param value
     */
    public void onRealSeatBeltWarningOn(int value) {
    }

    /**
     * @param value
     */
    public void onUnLockResponse(int value) {
    }

    /**
     * 车门
     *
     * @param state
     */
    public void onDoorState(int[] state) {
    }

    /**
     * 车窗
     *
     * @param position
     */
    public void onWindowPosition(float[] position) {
    }

    /**
     * @param value
     */
    public void onLowBeam(int value) {
    }

    /**
     * @param value
     */
    public void onParkingLamp(int value) {
    }

    /**
     * @param mode
     */
    public void onPowerMode(int mode) {
    }

    /**
     * @param value
     */
    public void onWelcomeSt(int value) {
    }

    /**
     * @param value
     */
    public void onPollingOpenCfg(int value) {
    }

    /**
     * BCM_DRIVER_BELT_BUCKLED = 0
     * BCM_DRIVER_BELT_UNBUCKLED_WARNING = 1
     * @param value
     */
    public void onDriverSbltWarning(int value) {
    }

    public void onSeatVentLevel(int level) {
    }

    public void onSeatHeatLevel(int level) {
    }

    public void onPsnSeatHeatLevel(int level) {
    }

    public void onBackMirrorHeat(int mode) {
    }

    public void onRearDefrostOn(int mode) {
    }
}
