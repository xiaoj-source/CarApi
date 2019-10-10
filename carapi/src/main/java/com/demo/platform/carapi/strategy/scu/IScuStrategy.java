package com.demo.platform.carapi.strategy.scu;

import com.demo.platform.carapi.callback.ICarService;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public interface IScuStrategy extends ICarService {
    /**
     * 获取前向碰撞安全预警开关
     */
    int getFrontCollisionSecurity();

    /**
     * 设置前向碰撞安全预警开关
     */
    void setFrontCollisionSecurity(int type);

    /**
     * @return 获取智能限速
     */
    int getIntelligentSpeedLimit();

    /**
     * 设置智能限速
     *
     * @param type
     */
    void setIntelligentSpeedLimit(int type);

    /**
     * 设置变道辅助
     *
     * @param type
     */
    void setLaneChangeAssist(int type);

    /**
     * 获取侧向倒车预警
     *
     * @return
     */
    int getSideReversingWarning();

    /**
     * 设置侧向倒车预警
     *
     * @param type
     */
    void setSideReversingWarning(int type);

    /**
     * 获取车道偏离预警
     *
     * @return
     */
    int getLaneDepartureWarning();

    /**
     * 设置车道偏离预警
     *
     * @param type
     */
    void setLaneDepartureWarning(int type);

    /**
     * 获取盲区检测预警
     *
     * @return
     */
    int getBlindAreaDetectionWarning();

    /**
     * 设置盲区检测预警
     *
     * @param type
     */
    void setBlindAreaDetectionWarning(int type);

    void setLaneMiddleAssist(int value);

    boolean getKeyPark();

}
