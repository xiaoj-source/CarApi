package com.demo.platform.carapi.callback;

import android.car.hardware.vcu.CarVcuManager;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public class VcuCallbackAdapter extends BaseCallbackAdapter {
    private static final String TAG = "VcuCallbackAdapter";
    public static final Integer[] PROP_IDS = {
            CarVcuManager.ID_VCU_DRIVE_MODE_GET,
            CarVcuManager.ID_VCU_ENERGY_RECYCLE,
            CarVcuManager.ID_VCU_RAW_CAR_SPEED,
            CarVcuManager.ID_VCU_EVSYS_READYST,
            CarVcuManager.ID_VCU_GEAR_LEVER};

    @Override
    final protected void onChangeEvent(int propertyId, Object data) {
        switch (propertyId) {
            case CarVcuManager.ID_VCU_DRIVE_MODE_GET:
                onDriveModeGet((int) data);
                break;

            case CarVcuManager.ID_VCU_ENERGY_RECYCLE:
                onEnergyRecycle((int) data);
                break;

            case CarVcuManager.ID_VCU_RAW_CAR_SPEED:
                onCarSpeed((Float) data);
                break;

            case CarVcuManager.ID_VCU_EVSYS_READYST:
                onEvSystemRead((int) data);
                break;

            case CarVcuManager.ID_VCU_GEAR_LEVER:
                onGearLever((int) data);
                break;
        }
    }

    public void onDriveModeGet(int mode) {
    }

    public void onEnergyRecycle(int value) {
    }

    public void onCarSpeed(float speed) {
    }

    public void onEvSystemRead(int value) {
    }

    public void onGearLever(int value){
    }
}
