package com.demo.platform.carapi.callback;

import android.car.hardware.CarPropertyValue;
import android.view.KeyEvent;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public interface CarServiceCallback {

    void onChangeEvent(CarPropertyValue value);

    void onErrorEvent(int propertyId, int zone);

    void onKeyEvent(KeyEvent keyEvent, int targetDisplay);
}
