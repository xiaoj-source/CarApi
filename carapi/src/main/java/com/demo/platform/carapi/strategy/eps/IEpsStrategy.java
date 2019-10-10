package com.demo.platform.carapi.strategy.eps;

import com.demo.platform.carapi.callback.ICarService;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public interface IEpsStrategy extends ICarService {
    /**
     * 获取方向盘转向助力
     */
    int getSteeringWheelEPS();

    /**
     * 设置方向盘转向助力
     */
    void setSteeringWheelEPS(int type);
}
