package com.demo.platform.carapi;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class CarApiConstant {

    /**
     * BCM模块
     */
    public static class BCM {

    }

    public static class MCU {
        /**
         * 反馈 驾驶模式 D2车才有反馈
         */
        public static final int DRIVING_STATUS_MODE_COMFORT = 0;
        public static final int DRIVING_STATUS_MODE_ECO = 1;
        public static final int DRIVING_STATUS_MODE_SPORT = 2;

        /**
         * MCU 获取通风的状态
         */
        public static final int MCU_VENTILATE_INVALID = 0;
        public static final int MCU_VENTILATE_STATE = 1;

        /**
         * 座椅的控制方式
         */
        public static final int SEAT_SLOW_MOVE_START = 1;
        public static final int SEAT_SLOW_MOVE_PENDING = 2;
        public static final int SEAT_SLOW_MOVE_STOP = 3;

        /**
         * 座椅控制的方向
         */
        public static final int SEAT_SLOW_MOVE_HORI_FORWARD = 1;
        public static final int SEAT_SLOW_MOVE_HORI_BACKWARD = 2;
        public static final int SEAT_SLOW_MOVE_VERT_FORWARD = 3;
        public static final int SEAT_SLOW_MOVE_VERT_BACKWARD = 4;
        public static final int SEAT_SLOW_MOVE_ANGL_FORWARD = 5;
        public static final int SEAT_SLOW_MOVE_ANGL_BACKWARD = 6;
    }

    public static class Tpms {
        /**
         * 胎压状态
         */
        public static final int TYPE_NOT_FIX = 0;//未调整
        public static final int TYRE_FIXING = 1;//调整中
        public static final int TYRE_FIXED = 2;//调整成功
        public static final int TYRE_FAIL = 3;//调整失败

    }

    public static class SCU {
        /**
         * 车道居中辅助
         */
        public static final int SCU_LANE_MIDDLE_ASSIST_ENABLE = 1;
        public static final int SCU_LANE_MIDDLE_ASSIST_DISABLE = 0;
    }
}
