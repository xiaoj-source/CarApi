package com.demo.platform.carapi.strategy;

import android.car.Car;
import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.car.hardware.CarEcuManager;
import android.util.Log;

import com.demo.platform.carapi.callback.CarServiceEventAdapter;
import com.demo.platform.carapi.CarApi;
import com.demo.platform.carapi.callback.CarServiceCallback;
import com.demo.platform.carapi.callback.ICarService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public abstract class BaseStrategy implements ICarService {
    private static final String TAG = "BaseStrategy";

    protected CarEcuManager mManager;
    protected List<CarServiceCallback> mCallbackList = new ArrayList<>();

    protected BaseStrategy() {
    }

    protected abstract Integer[] getPropIds();

    @Override
    public void register() {
        try {
            mManager = (CarEcuManager) getCarManagerService(getServiceName());
            if (mManager != null) {
                List<Integer> ids = Arrays.asList(getPropIds());
                if (ids.isEmpty()) {
                    mManager.registerCallback(new CarServiceEventAdapter(TAG, mCallbackList));
                } else {
                    mManager.registerPropCallback(ids, new CarServiceEventAdapter(TAG, mCallbackList));
                }
            }
        } catch (CarNotConnectedException e) {
            e.printStackTrace();
        }
    }

    @Override
    final public void addCarServiceCallback(CarServiceCallback callback) {
        if (callback == null) {
            throw new RuntimeException("CarService call back can not be null.");
        }
        if (!mCallbackList.contains(callback)) {
            mCallbackList.add(callback);
        }
    }

    @Override
    final public void removeCarServiceCallback(CarServiceCallback callback) {
        mCallbackList.remove(callback);
    }

    final protected CarManagerBase getCarManagerService(String serviceName) {
        Log.d(TAG, "getCarManagerService() serviceName:" + serviceName);
        try {
            Car car = CarApi.getCar();
            if (car != null) {
                Object base = car.getCarManager(serviceName);
                if (base instanceof CarManagerBase) {
                    return (CarManagerBase) base;
                }
            } else {
                throw new IllegalArgumentException("May be error car type!");
            }
        } catch (CarNotConnectedException e) {
            Log.e(TAG, "getCarManagerService error, CarNotConnectedException");
            e.printStackTrace();
        }
        return null;
    }

    public void unRegister(CarEcuManager.CarEcuEventCallback callback, Collection<Integer> ids) {
        try {
            if (mManager != null) {
                if (ids == null || ids.isEmpty()) {
                    mManager.unregisterCallback(callback);
                } else {
                    mManager.unregisterPropCallback(ids, callback);
                }
            }
        } catch (CarNotConnectedException e) {
            e.printStackTrace();
        }
    }

    public void unRegister(CarEcuManager.CarEcuEventCallback callback) {
        unRegister(callback, null);
    }
}
