package com.demo.platform.carapi.strategy.esp;

import com.demo.platform.carapi.callback.ICarService;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public interface IEspStrategy extends ICarService {
    /**
     * 获取hdc
     * HDC_STATUS_INACTIVE = 0
     * HDC_STATUS_ACTIVE = 1
     * HDC_STATUS_STANDBY = 2
     */
    int getHdc();

    /**
     * 设置hdc 下坡安全辅助
     * HDC_STATUS_INACTIVE = 0
     * HDC_STATUS_ACTIVE = 1
     */
    void setHdc(int enable);

    /**
     * 获取eso
     *
     * @return
     */
    int getEsp();

    /**
     * 设置ESP 电子稳定系统
     *
     * @param type ESC_ESP_NORMAL = 1;
     *             ESC_ESP_SPORT = 2;
     *             ESC_ESP_OFF = 3;
     *             ESC_ESP_ON = 4;//only for D21
     */
    void setEsp(int type);


    /**
     * 获取avh
     *
     * @return ESP_STATUS_INACTIVE = 0
     * ESP_STATUS_ACTIVE = 1
     * ESP_STATUS_STANDBY = 2
     */
    int getAvh();

    /**
     * 设置AVH 自动驻车安全
     *
     * @param status ESP_STATUS_INACTIVE = 0
     *               ESP_STATUS_ACTIVE = 1
     */
    void setAvh(int status);

    boolean getEspFault();

    boolean getHdcFault();

    boolean getAvhFault();

}
