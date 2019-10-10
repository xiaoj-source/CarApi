package com.demo.platform.carapi.callback;

import android.car.hardware.ciu.CarCiuManager;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public class CiuCallbackAdapter extends BaseCallbackAdapter {
    public static final Integer[] PROP_IDS = {
            CarCiuManager.ID_CIU_DMS_SW,
            CarCiuManager.ID_CIU_FACE_ID_SW,
            CarCiuManager.ID_CIU_FATIG_ST,
            CarCiuManager.ID_CIU_DISTRACTION_ST,
            CarCiuManager.ID_CIU_VALID,
            CarCiuManager.ID_CIU_RAIN_SW};

    @Override
    final protected void onChangeEvent(int propertyId, Object data) {
        switch (propertyId) {
            case CarCiuManager.ID_CIU_DMS_SW:
                onDmsSW((int) data);
                break;

            case CarCiuManager.ID_CIU_FACE_ID_SW:
                onFaceIdSW((int) data);
                break;

            case CarCiuManager.ID_CIU_FATIG_ST:
                onFatigSt((int) data);
                break;

            case CarCiuManager.ID_CIU_DISTRACTION_ST:
                onDistractionSt((int) data);
                break;

            case CarCiuManager.ID_CIU_VALID:
                onCiuValid((int) data);

            case CarCiuManager.ID_CIU_RAIN_SW:
                onRainSW((int) data);
                break;
        }
    }

    public void onDmsSW(int value) {
    }

    public void onFaceIdSW(int value) {
    }

    public void onFatigSt(int value) {
    }

    public void onDistractionSt(int value) {
    }

    public void onCiuValid(int value) {
    }

    public void onRainSW(int value) {
    }
}
