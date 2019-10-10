package com.demo.platform.carapi.callback;

import android.car.hardware.icm.CarIcmManager;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public class IcmCallbackAdapter extends BaseCallbackAdapter {
    public static final Integer[] PROP_IDS = {
            CarIcmManager.ID_ICM_ALARM_VOLUME, CarIcmManager.ID_ICM_TEMPERATURE,
            CarIcmManager.ID_ICM_WIND_POWER, CarIcmManager.ID_ICM_WIND_MODE,
            CarIcmManager.ID_ICM_MEDIA_SOURCE, CarIcmManager.ID_ICM_SCREEN_LIGHT,
            CarIcmManager.ID_ICM_SPEED_LIMIT_WARNING_SWITCH, CarIcmManager.ID_ICM_SPEED_LIMIT_WARNING_VALUE,
            CarIcmManager.ID_ICM_TOTAL_ODO_METER, CarIcmManager.ID_ICM_TRIP_SINCE_CHARGING,
            CarIcmManager.ID_ICM_TRIP_SINCE_IGON, CarIcmManager.ID_ICM_TRIPA,
            CarIcmManager.ID_ICM_TRIPB, CarIcmManager.ID_ICM_WIND_BLOW_LEVEL};

    @Override
    final protected void onChangeEvent(int propertyId, Object data) {
        switch (propertyId) {
            case CarIcmManager.ID_ICM_ALARM_VOLUME:
                onAlarmVolume((int) data);
                break;

            case CarIcmManager.ID_ICM_TEMPERATURE:
                onTemperature((int) data);
                break;

            case CarIcmManager.ID_ICM_WIND_POWER:
                onWindPower((int) data);
                break;

            case CarIcmManager.ID_ICM_WIND_MODE:
                onWindMode((int) data);
                break;

            case CarIcmManager.ID_ICM_MEDIA_SOURCE:
                onMediaSource((int) data);
                break;

            case CarIcmManager.ID_ICM_SCREEN_LIGHT:
                onScreenLight((int) data);
                break;

            case CarIcmManager.ID_ICM_SPEED_LIMIT_WARNING_SWITCH:
                onSpeedLimitWarningSwitch((int) data);
                break;

            case CarIcmManager.ID_ICM_SPEED_LIMIT_WARNING_VALUE:
                onSpeedLimitWarningValue((int) data);
                break;

            case CarIcmManager.ID_ICM_TOTAL_ODO_METER:
                onTotalOdoMeter((Float) data);
                break;

            case CarIcmManager.ID_ICM_TRIP_SINCE_CHARGING:
                onTripSinceCharging((Float) data);
                break;

            case CarIcmManager.ID_ICM_TRIP_SINCE_IGON:
                onTripSinceIgon((Float) data);
                break;

            case CarIcmManager.ID_ICM_TRIPA:
                onTripA((Float) data);
                break;

            case CarIcmManager.ID_ICM_TRIPB:
                onTripB((Float) data);
                break;

            case CarIcmManager.ID_ICM_WIND_BLOW_LEVEL:
                onWindBlowLevel((int) data);
                break;
        }
    }

    public void onAlarmVolume(int value) {
    }

    public void onTemperature(int value) {
    }

    public void onWindPower(int value) {
    }

    public void onWindMode(int value) {
    }

    public void onMediaSource(int value) {
    }

    public void onScreenLight(int value) {
    }

    public void onSpeedLimitWarningSwitch(int value) {
    }

    public void onSpeedLimitWarningValue(int value) {
    }

    public void onTotalOdoMeter(float value) {
    }

    public void onTripSinceCharging(float value) {
    }

    public void onTripSinceIgon(float value) {
    }

    public void onTripA(float value) {
    }

    public void onTripB(float value) {
    }

    public void onWindBlowLevel(int value) {
    }
}
