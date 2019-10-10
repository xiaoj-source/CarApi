package com.demo.platform.carapi.strategy.msm;

import com.demo.platform.carapi.callback.ICarService;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public interface IMsmStrategy extends ICarService {

    /**
     * 主驾座椅水平调节
     *
     * @param control   MSM_CONTROL_START =0x1;
     *                  MSM_CONTROL_PENDING =0x2;
     *                  MSM_CONTROL_STOP =0x3;
     * @param direction Msm_Move_Forward =0x1;
     *                  Msm_Move_Backward =0x2;
     */
    void setDriverSeatHorizMove(int control, int direction);

    /**
     * 主驾座椅靠背调节
     *
     * @param control   MSM_CONTROL_START =0x1;
     *                  MSM_CONTROL_PENDING =0x2;
     *                  MSM_CONTROL_STOP =0x3;
     * @param direction Msm_Move_Forward =0x1;
     *                  Msm_Move_Backward =0x2;
     */
    void setDriverSeatBackMove(int control, int direction);

    /**
     * 主驾座椅上下调节
     *
     * @param control   MSM_CONTROL_START =0x1;
     *                  MSM_CONTROL_PENDING =0x2;
     *                  MSM_CONTROL_STOP =0x3;
     * @param direction Msm_Move_Up =0x1;
     *                  Msm_Move_Down =0x2;
     */
    void setDriverSeatVertiMove(int control, int direction);

    /**
     * 主驾水平电机位置
     *
     * @param pos 0-100
     */
    void setDriverSeatHorizPosition(int pos);

    /**
     * 主驾水平电机位置
     *
     * @return 0-100
     */
    int getDriverSeatHorizPosition();

    /**
     * 主驾上下电机位置
     *
     * @param pos 0-100
     */
    void setDriverSeatVertiPosition(int pos);

    /**
     * 主驾上下电机位置
     *
     * @return 0-100
     */
    int getDriverSeatVertiPosition();

    /**
     * 主驾靠背电机位置
     *
     * @param pos 0-100
     */
    void setDriverSeatBackPosition(int pos);

    /**
     * 主驾靠背电机位置
     *
     * @return 0-100
     */
    int getDriverSeatBackPosition();
}
