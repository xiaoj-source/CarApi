package com.demo.platform.carapi.callback;

import android.car.hardware.esp.CarEspManager;

/**
 * Created by xiaojun
 *
 * @date 19-3-29
 */
public class EspCallbackAdapter extends BaseCallbackAdapter {
    public static final Integer[] PROP_IDS = {
            CarEspManager.ID_ESP_AVH,
            CarEspManager.ID_ESP_ESP,
            CarEspManager.ID_ESP_HDC,
            CarEspManager.ID_ESP_AVH_FAULT,
            CarEspManager.ID_ESP_ESP_FAULT
    };

    @Override
    final protected void onChangeEvent(int propertyId, Object data) {
        switch (propertyId) {
            case CarEspManager.ID_ESP_AVH:
                onAVH((int) data);
                break;

            case CarEspManager.ID_ESP_ESP:
                onESP((int) data);
                break;

            case CarEspManager.ID_ESP_HDC:
                onHDC((int) data);
                break;

            case CarEspManager.ID_ESP_AVH_FAULT:
                onAvhFault((int) data);
                break;

            case CarEspManager.ID_ESP_ESP_FAULT:
                onEspFault((int) data);
                break;
        }
    }

    public void onAVH(int value) {
    }

    /**
     * ESC_ESP_NORMAL = 1;
     * ESC_ESP_SPORT = 2;
     * ESC_ESP_OFF = 3;
     * ESC_ESP_ON = 4;//only for D21
     *
     * @param value
     */
    public void onESP(int value) {
    }

    /**
     * HDC_STATUS_INACTIVE = 0
     * HDC_STATUS_ACTIVE = 1
     * HDC_STATUS_STANDBY = 2
     *
     * @param value
     */
    public void onHDC(int value) {
    }

    /**
     * AVH_NOT_FAULT = 0
     * AVH_FAULT = 1
     *
     * @param value
     */
    public void onAvhFault(int value) {
    }

    /**
     * ESP_NOT_FAULT = 0
     * ESP_FAULT = 1
     *
     * @param value
     */
    public void onEspFault(int value) {
    }
}
