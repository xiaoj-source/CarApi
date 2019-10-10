package com.demo.platform.carapi.callback;

import android.car.hardware.hvac.CarHvacManager;

/**
 * Created by xiaojun
 *
 * @date 19-3-22
 */
public class HvacCallbackAdapter extends BaseCallbackAdapter {
    private static final String TAG = "HvacCallbackAdapter";
    public static final Integer[] PROP_IDS = {
            CarHvacManager.ID_ZONED_HVAC_POWER_ON,
            CarHvacManager.ID_ZONED_AC_ON,
            CarHvacManager.ID_HVAC_LEFT_SYNC,
            CarHvacManager.ID_ZONED_TEMP_SETPOINT,
            CarHvacManager.ID_ZONE_HVAC_TEMPERATURE_PSN_SET,
            CarHvacManager.ID_ZONED_AUTOMATIC_MODE_ON,
            CarHvacManager.ID_ZONE_HVAC_BLW_COMFORT_CFG,
            CarHvacManager.ID_ZONED_AIR_RECIRCULATION_ON,
            CarHvacManager.ID_WINDOW_DEFROSTER_ON,
            CarHvacManager.ID_ZONED_FAN_POSITION,
            CarHvacManager.ID_ZONED_FAN_SPEED_SETPOINT,
            CarHvacManager.ID_ZONE_HVAC_PM25_AIR_PURGE,
            CarHvacManager.ID_HVAC_PM25,
            CarHvacManager.ID_HVAC_INNER_TEMPERATURE,
            CarHvacManager.ID_HVAC_ECON,
    };

    @Override
    final protected void onChangeEvent(int propertyId, Object data) {
        switch (propertyId) {
            case CarHvacManager.ID_ZONED_HVAC_POWER_ON:
                onHvacPowerMode((int) data);
                break;

            case CarHvacManager.ID_ZONED_AC_ON:
                onHvacTempACMode((int) data);
                break;


            case CarHvacManager.ID_HVAC_LEFT_SYNC:
                onHvacTempLeftSyncMode((int) data);
                break;

            case CarHvacManager.ID_ZONED_TEMP_SETPOINT:
                onHvacTempDriverValue((float) data);
            case CarHvacManager.ID_ZONE_HVAC_TEMPERATURE_PSN_SET:
                onHvacTempPsnValue((float) data);
                break;

            case CarHvacManager.ID_ZONED_AUTOMATIC_MODE_ON:
                onHvacAutoMode((int) data);
                break;

            case CarHvacManager.ID_ZONE_HVAC_BLW_COMFORT_CFG:
                onHvacAutoModeBlowLevel((int) data);
                break;

            case CarHvacManager.ID_ZONED_AIR_RECIRCULATION_ON:
                onHvacCirculationMode((int) data);
                break;

            case CarHvacManager.ID_WINDOW_DEFROSTER_ON:
                onHvacFrontDefrostMode((int) data);
                break;

            case CarHvacManager.ID_ZONED_FAN_POSITION:
                onHvacWindBlowMode((int) data);
                break;

            case CarHvacManager.ID_ZONED_FAN_SPEED_SETPOINT:
                onHvacWindSpeedLevel((int) data);
                break;

            case CarHvacManager.ID_ZONE_HVAC_PM25_AIR_PURGE:
                onHvacQualityPurgeMode((int) data);
                break;

            case CarHvacManager.ID_HVAC_PM25:
                onPm25Quality((int) data);
                break;

            case CarHvacManager.ID_HVAC_INNER_TEMPERATURE:
                onHvacInnerTemp((int) data);
                break;

            case CarHvacManager.ID_HVAC_ECON:
                onEconMode((int) data);
                break;

            default:
                break;
        }
    }

    public void onHvacPowerMode(int enable) {
    }

    public void onHvacTempACMode(int enable) {
    }

    public void onHvacTempLeftSyncMode(int enable) {
    }

    public void onHvacTempDriverValue(float level) {
    }

    public void onHvacTempPsnValue(float level) {
    }

    public void onHvacAutoMode(int enable) {
    }

    public void onHvacAutoModeBlowLevel(int level) {
    }

    public void onHvacCirculationMode(int enable) {
    }

    public void onHvacFrontDefrostMode(int enable) {
    }

    public void onHvacWindBlowMode(int mode) {
    }

    public void onHvacWindSpeedLevel(int level) {
    }

    public void onHvacQualityPurgeMode(int enable) {
    }

    public void onPm25Quality(int level) {
    }

    public void onHVACQualityOutsideLevel(int level) {
    }

    public void onHVACQualityOutsideStatus(int enable) {
    }

    public void onHvacInnerTemp(int level) {
    }

    public void onEconMode(int enable) {
    }

}
