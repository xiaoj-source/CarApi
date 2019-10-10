package com.demo.platform.carapi.callback;

import android.car.hardware.CarEcuManager;
import android.car.hardware.CarPropertyValue;
import android.util.Log;

import com.demo.platform.carapi.CarApiThreadPool;

import java.util.List;

/**
 * 避免每个CarManager注册时都去写一次回调方法，这里统一封装。
 * <p>
 * Created by xiaojun
 *
 * @date 19-3-27
 */
public class CarServiceEventAdapter implements CarEcuManager.CarEcuEventCallback {
    private static final String TAG = "CarServiceEventAdapter";
    private String mServiceName;
    private List<CarServiceCallback> mCallbackList;

    public CarServiceEventAdapter(String serviceName, List<CarServiceCallback> callbackList) {
        mServiceName = serviceName;
        mCallbackList = callbackList;
    }

    @Override
    public void onChangeEvent(final CarPropertyValue value) {
        Log.d(TAG, "ServiceName:" + mServiceName + " onChangeEvent value = " + value.toString());
        //此回调是在一个子线程执行，有可能出来子线程中的阻塞，因此通过线程池execute，防止阻塞
        CarApiThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                for (final CarServiceCallback callback : mCallbackList) {
                    callback.onChangeEvent(value);
                }
            }
        });
    }

    @Override
    public void onErrorEvent(final int propertyId, final int zone) {
        Log.e(TAG, "ServiceName:" + mServiceName + " onErrorEvent error, propertyId = " + propertyId + " zone = " + zone);

        CarApiThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                for (final CarServiceCallback callback : mCallbackList) {
                    callback.onErrorEvent(propertyId, zone);
                }
            }
        });
    }
}
