package com.demo.platform.carapi.callback;

import android.car.hardware.CarPropertyValue;
import android.util.Log;
import android.view.KeyEvent;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public abstract class BaseCallbackAdapter implements CarServiceCallback {
    private static final String TAG = "BaseCallbackAdapter";

    @Override
    final public void onChangeEvent(CarPropertyValue value) {
        if (value == null) {
            Log.e(TAG, "onChangeEvent error, value is null. ");
            return;
        }
        Object data = value.getValue();
        if (data == null) {
            Log.e(TAG, "onChangeEvent error, value.getValue() is null. value: " + value);
            return;
        }
        onChangeEvent(value.getPropertyId(), data);
    }

    @Override
    public void onErrorEvent(int propertyId, int zone) {

    }

    @Override
    public void onKeyEvent(KeyEvent keyEvent, int targetDisplay) {

    }

    protected abstract void onChangeEvent(int propertyId, Object data);
}
