package com.demo.platform.carapi.strategy.tpms;

import com.demo.platform.carapi.callback.ICarService;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public interface ITpmsStrategy extends ICarService {
    /**
     * 校准胎压
     */
    void calibrateTirePressure();

    /**
     * 获取胎压状态
     *
     * @return
     */
    int getTirePressure();
}
