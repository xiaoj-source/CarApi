package com.demo.platform.carapi.callback;

import android.car.hardware.tpms.CarTpmsManager;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public class TpmsCallbackAdapter extends BaseCallbackAdapter {
    public static final Integer[] PROP_IDS = {CarTpmsManager.ID_TPMS_TIRE_PRESSURE};

    @Override
    final protected void onChangeEvent(int propertyId, Object data) {
        switch (propertyId) {
            case CarTpmsManager.ID_TPMS_TIRE_PRESSURE:
                onTirePressure((int) data);
                break;
        }
    }

    public void onTirePressure(int value) {
    }
}
