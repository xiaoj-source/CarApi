package com.demo.platform.carapi.callback;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public interface ICarService {

    String getServiceName();

    void register();

    void addCarServiceCallback(CarServiceCallback callback);

    void removeCarServiceCallback(CarServiceCallback callback);
}
