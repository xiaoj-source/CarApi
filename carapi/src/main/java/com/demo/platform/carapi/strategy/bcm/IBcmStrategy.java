package com.demo.platform.carapi.strategy.bcm;

import com.demo.platform.carapi.callback.ICarService;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public interface IBcmStrategy extends ICarService {
    /**
     * 设置照我回家
     * BCM_LIGHT_ME_HOME_NOT_ACTIVE = 1 : Not active
     * BCM_LIGHT_ME_HOME_LOW_BEAM = 2 : Only low beam
     * BCM_LIGHT_ME_HOME_LOW_BEAM_PARKING = 3 : Low beam and  Parking  lamp  //only for D21
     */
    void setLightMeHome(int value);

    /**
     * 获取照我回家
     */
    int getLightMeHome();

    /**
     * 获取后雾灯
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     *
     * @return
     */
    int getRearFogLamp();

    /**
     * 设置后雾灯
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    void setRearFogLamp(int value);

    /**
     * 设置后视镜
     *
     * @param type 展开或折叠
     */
    void setRearViewMirror(int type);

    /**
     * 设置前大灯组
     */
    void setHeadLampGroup(int groupId);

    /**
     * 获取前大灯组
     */
    int getHeadLampGroup();

    /**
     * 设置车内照明灯
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    void setInternalLight(int value);

    /**
     * 获取车内照明灯
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    int getInternalLight();

    /**
     * 设置紧急刹车报警
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    void setEmergencyBrakeWarning(int value);

    /**
     * 获取紧急刹车报警
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    int getEmergencyBrakeWarning();

    /**
     * 设置全部车窗手动/自动升降
     */
    void setAllWindowManualOrAuto(int type);

    /**
     * 获取车的设防状态
     */
    int getAtwsState();

    /**
     * 设置车窗运动指令
     * window：
     * WINDOW_FRONT_LEFT = 0;
     * WINDOW_FRONT_RIGHT = 1;
     * WINDOW_BACK_LEFT = 2;
     * WINDOW_BACK_RIGHT = 3;
     * WINDOW_ALL = 4;
     * cmd:
     * BCM_WINDOW_TYPE_UP_MANUALLY = 1;
     * BCM_WINDOW_TYPE_UP_AUTO = 2;
     * BCM_WINDOW_TYPE_DOWN_MANUALLY = 3;
     * BCM_WINDOW_TYPE_DOWN_AUTO = 4;
     */
    void setWindowMoveCmd(int window, int cmd);

    /**
     * 设置行车自动落锁
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    void setDriveAutoLock(int value);

    /**
     * 获取行车自动落锁
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    int getDriveAutoLock();

    /**
     * 设置驻车自动解锁
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    void setParkingAutoUnlock(int value);

    /**
     * 获取驻车自动解锁
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    int getParkingAutoUnlock();

    /**
     * 设置应急灯
     * BCM_HAZARD_LIGHT_OFF = 0
     * BCM_HAZARD_LIGHT_ON = 1
     */
    void setHazardLight(int value);


    /**
     * 设置车门上锁
     * DOOR_UNLOCK = 0
     * DOOR_LOCK = 1
     */
    void setDoorLock(int value);

    /**
     * 设置后备箱
     */
    void setTrunk(int controlType);

    /**
     * 获取后备箱状态
     */
    int getTrunk();

    /**
     * 设置雨刮间歇档
     */
    void setWiperInterval(int level);

    /**
     * 获取座椅的迎宾模式开关
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    int getChairWelcomeMode();

    /**
     * 设置座椅的迎宾模式
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    void setChairWelcomeMode(int value);

    /**
     * 获取座椅电动安全带开关
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    int getElectricSeatBelt();

    /**
     * 设置座椅的电动安全带
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    void setElectricSeatBelt(int value);

    /**
     * 获取座椅后排安全带警报
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    int getRearSeatBeltWarning();

    /**
     * 设置座椅的后排安全带警告
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     */
    void setRearSeatBeltWarning(int value);

    /**
     * 设置解锁反馈
     */
    void setUnlockResponse(int type);

    /**
     * 获取解锁反馈
     */
    int getUnlockResponse();

    /**
     * 获取车门状态
     *
     * @return
     */
    int[] getDoorsState();

    /**
     * 获取四个车窗的开合度 顺序是左前 右前 左后 右后
     */
    float[] getWindowsState();

    /**
     * 获取座椅的错误状态
     * BCM_SEAT_ERROR_NONE = 0;
     * BCM_SEAT_ERROR_GAIN = 1;
     *
     * @return
     */
    int getSeatErrorState();

    /**
     * 控制通风功能
     */
    void setVentilate();

    /**
     * 打开关闭右后车窗
     *
     * @param open true = 打开
     */
    void setBackRightRowWindow(boolean open);

    /**
     * 打开关闭左后车窗
     *
     * @param open true = 打开
     */
    void setBackLeftRowWindow(boolean open);

    /**
     * 打开关闭后排车窗
     *
     * @param open true = 打开
     */
    void setBackWindows(boolean open);

    /**
     * 打开关闭前排车窗
     *
     * @param open true = 打开
     */
    void setFrontWindows(boolean open);

    /**
     * 打开关闭左前车窗
     *
     * @param open true = 打开
     */
    void setFrontLeftRowWindow(boolean open);

    /**
     * 打开关闭右前车窗
     *
     * @param open true = 打开
     */
    void setFrontRightRowWindow(boolean open);

    /**
     * 设置感应式解闭锁
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     *
     * @param value
     */
    void setPollingOpenCfg(int value);

    /**
     * BCM_STATUS_OFF = 0
     * BCM_STATUS_ON = 1
     *
     * @return
     */
    int getPollingOpenCfg();

    boolean getDriverBeltWarning();

    /**
     * 主驾是否有人
     * DRIVER_NOT_ON_SEAT = 0
     * DRIVER_ON_SEAT = 1
     *
     * @return
     */
    int getDriveOnSeat();

    /**
     * 设置后视镜自动下降
     * REARVIEW_AUTODOWN_CFG_CLOSE = 1;
     * REARVIEW_AUTODOWN_CFG_OPEN = 2;
     *
     * @param cfg
     */
    void setRearViewAutoDownCfg(int cfg);

    /**
     * REARVIEW_AUTODOWN_CFG_CLOSE = 1;
     * REARVIEW_AUTODOWN_CFG_OPEN = 2;
     *
     * @return
     */
    int getRearViewAutoDownCfg();


    /**
     * 设置座椅加热
     *
     * @param level
     */
    void setSeatHeatLevel(int level);

    void setSeatBlowLevel(int level);

    void setPsnSeatHeatLevel(int level);

    void setBackDefrostMode(int status);

    void setBackMirrorHeatMode(int status);
}
