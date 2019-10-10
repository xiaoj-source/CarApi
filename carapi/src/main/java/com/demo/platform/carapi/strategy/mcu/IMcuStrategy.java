package com.demo.platform.carapi.strategy.mcu;

import com.demo.platform.carapi.callback.ICarService;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public interface IMcuStrategy extends ICarService {
    /**
     * 设置驾驶模式
     *
     * @param mode
     */
    void setDriveMode(int mode);

    /**
     * 获取硬件版本
     *
     * @throws
     */
    int getHardwareVersion();

    /**
     * 设置鸣笛
     */
    void setHorn(boolean on);

    /**
     * 设置闪光
     */
    void setFlash(boolean on);


    /**
     * @return 获取车型号
     * @throws
     */
    String getHardwareCarType();

    /**
     * @return 获取车生产阶段
     * @throws
     */
    String getHardwareCarStage();


    /**
     * 设置异常震动阀值 同步给mcu
     *
     * @param shockValue2Mcu
     * @throws
     */
    void setShockValue2Mcu(int shockValue2Mcu);

    /**
     * 获取状态属性值，主要用于判断行车记录仪设备状态
     *
     * @return
     * @throws
     */
    int[] getDtcReportEV();

    /**
     * 获取上下电状态
     *
     * @return int[0] -> 屏幕温度
     * int[1] -> 0-下电，1-本地上电，2-远程上电
     */
    int[] getIgStatus();
}
