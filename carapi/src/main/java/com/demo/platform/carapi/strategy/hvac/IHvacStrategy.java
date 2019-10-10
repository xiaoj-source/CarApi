package com.demo.platform.carapi.strategy.hvac;

import com.demo.platform.carapi.callback.ICarService;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public interface IHvacStrategy extends ICarService {

    void setHvacPowerMode(int enable);

    void setHvacTempAcMode(int enable);

    void setHvacTempLeftSyncMode(int enable);

    void setHvacTempDriverValue(float level);

    void setHvacTempPsnValue(float level);

    void setHvacAutoMode(int enable);

    void setHvacCirculatisetMode(int enable);

    void setHvacFrontDefrostMode(int enable);

    void setHvacWindBlowMode(int mode);

    void setHvacWindSpeedLevel(int level);

    void setHvacQualityPurgeMode(int enable);

    void setEconMode(int enable);
}
