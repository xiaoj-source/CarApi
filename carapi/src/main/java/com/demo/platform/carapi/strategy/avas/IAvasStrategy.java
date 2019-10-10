package com.demo.platform.carapi.strategy.avas;

import com.demo.platform.carapi.callback.ICarService;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public interface IAvasStrategy extends ICarService {
    /**
     * 设置低速模拟音 音效
     */
    void setAvasLowSpeedSound(int type);

    /**
     * 获取低速模拟音类型
     *
     * @return <p></p>
     * {@link android.car.hardware.avas.CarAvasManager}
     * AVAS_SOUND_TYPE_1 = 1;
     * AVAS_SOUND_TYPE_2 = 2;
     * AVAS_SOUND_TYPE_3 = 3;
     * AVAS_SOUND_TYPE_4 = 4;
     */
    int getAvasLowSpeedSound();

    /**
     * 设置低速模拟音 开关
     */
    void setAvasLowSpeedSoundSwitch(int enable);

    /**
     * 获取低速模拟音是否打开
     * <p>
     * AVAS_SWITCH_CLOSE = 0
     * AVAS_SWITCH_OPEN = 1
     *
     * @return
     */
    int getAvasLowSpeedSoundSwitch();
}
