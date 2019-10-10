package com.demo.platform.carapi.callback;

import android.car.hardware.eps.CarEpsManager;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public class EpsCallbackAdapter extends BaseCallbackAdapter {
    public static final Integer[] PROP_IDS = {CarEpsManager.ID_EPS_STEER_WHEEL_EPS};

    @Override
    final protected void onChangeEvent(int propertyId, Object data) {
        switch (propertyId) {
            case CarEpsManager.ID_EPS_STEER_WHEEL_EPS:
                onSteerWheelEps((int) data);
                break;
        }
    }

    public void onSteerWheelEps(int value) {
    }
}
