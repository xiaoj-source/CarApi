package com.demo.platform.carapi.strategy.vcu;

import com.demo.platform.carapi.callback.ICarService;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public interface IVcuStrategy extends ICarService {
    /**
     * 获取驾驶模式
     */
    int getDriveMode();

    /**
     * 设置能量回收等级
     */
    void setEnergyRecycle(int level);

    /**
     * 获取电量百分比
     *
     * @return
     */
    float getElectricityPercent();

    /**
     * 获取车速
     *
     * @return
     */
    float getCarSpeed();

    int getSystemReady();

    float getRawCarSpeed();

}
