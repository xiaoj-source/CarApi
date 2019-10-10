package com.demo.platform.carapi.strategy.icm;

import com.demo.platform.carapi.callback.ICarService;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public interface IIcmStrategy extends ICarService {
    /**
     * 重置里程A
     */
    void resetMeterMileageA();

    /**
     * 重置里程B
     */
    void resetMeterMileageB();

    /**
     * 获取仪表报警音量
     *
     * @return int ICM_ALARM_STATUS_VOLUME_SOFT = 1;
     * int ICM_ALARM_STATUS_VOLUME_STANDARD = 2;
     * int ICM_ALARM_STATUS_VOLUME_POWER = 3;
     */
    int getIcmAlarmVolume();

    /**
     * 设置选择警示音量
     *
     * @param volumeLevel
     */
    void setIcmAlarmVolume(int volumeLevel);

    /**
     * 设置选择仪表时间格式
     *
     * @param index
     */
    void setIcmTimeFormat(int index);

    /**
     * 获取仪表自定义菜单 温度
     *
     * @return
     */
    int getIcmTemperature();

    /**
     * 设置仪表自定义菜单 温度
     *
     * @param value
     */
    void setIcmTemperature(int value);

    /**
     * 获取仪表自定义菜单 风力
     *
     * @return
     */
    int getIcmWindPower();

    /**
     * 设置仪表自定义菜单 风力
     *
     * @param value
     */
    void setIcmWindPower(int value);

    /**
     * 获取仪表自定义菜单 吹风模式
     *
     * @return
     */
    int getIcmWindMode();

    /**
     * 设置仪表自定义菜单 吹风模式
     *
     * @param value
     */
    void setIcmWindMode(int value);


    /**
     * 获取仪表自定义菜单 媒体源
     *
     * @return
     */
    int getIcmMediaSource();

    /**
     * 设置仪表自定义菜单 媒体源
     */
    void setIcmMediaSource(int value);

    /**
     * 获取仪表自定义菜单 背光
     *
     * @return
     */
    int getIcmScreenLight();

    /**
     * 设置仪表自定义菜单 背光
     *
     * @param value
     */
    void setIcmScreenLight(int value);

    /**
     * 设置仪表自定义菜单 导航
     *
     * @param value
     */
    void setIcmNavigation(int value);


    /**
     * 设置仪表自定义菜单 昼夜模式
     *
     * @param value
     */
    void setIcmDayNightSwitch(int value);

    /**
     * 获取限速开关
     *
     * @return
     */
    int getSpeedLimitWarningSwitch();

    /**
     * 设置限速开关
     *
     * @param value
     */
    void setSpeedLimitWarningSwitch(int value);

    /**
     * 获取限速值
     *
     * @return
     */
    int getSpeedLimitWarningValue();

    /**
     * 设置限速值
     *
     * @param value
     */
    void setSpeedLimitWarningValue(int value);

    void setIcmWindBlowMode(int mode) throws Exception;

    void setIcmWindLevel(int level) throws Exception;

    void setIcmDriverTempValue(float value) throws Exception;

    void setIcmSystemTimeValue(int hour, int minutes) throws Exception;

    /**
     * 同时设置多条属性
     */
    void setIcmMultiProperty(LinkedList<HashMap<Integer, Object>> linkedList);

    void setIntProperty(int propertyId, int val);

    float getMeterMileageA();

    float getMeterMileageB();

    float getDriveTotalMileage();

    float getLastChargeMileage();

    float getLastStartUpMileage();
}
