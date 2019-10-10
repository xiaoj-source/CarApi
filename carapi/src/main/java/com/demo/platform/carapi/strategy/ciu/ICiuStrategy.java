package com.demo.platform.carapi.strategy.ciu;

import com.demo.platform.carapi.callback.ICarService;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public interface ICiuStrategy extends ICarService {

    int getDmsStatus();

    void setDmsStatus(int status);

    /**
     * CIU_INVALID = 0
     * CIU_VALID = 1
     *
     * @return
     */
    int getCiuValid();

    /**
     * FACE_ID_SW_STATUS_OFF = 0;
     * FACE_ID_SW_STATUS_ON = 1;
     * FACE_ID_SW_STATUS_FAULT = 2;
     *
     * @return
     */
    int getFaceIdSw();

    /**
     * FACE_ID_SW_STATUS_OFF = 0;
     * FACE_ID_SW_STATUS_ON = 1;
     * FACE_ID_SW_STATUS_FAULT = 2;
     *
     * @param value
     */
    void setFaceIdSw(int value);

    /**
     * FATIGUE_STATUS_ON = 1;
     * FATIGUE_STATUS_OFF = 2;
     *
     * @param status
     */
    void setFatigueStatus(int status);

    /**
     * FATIGUE_STATUS_ON = 1;
     * FATIGUE_STATUS_OFF = 2;
     *
     * @return
     */
    int getFatigueStatus();

    /**
     * DISTRACT_STATUS_ON = 1;
     * DISTRACT_STATUS_OFF = 2;
     *
     * @param status
     */
    void setDistractionStatus(int status);


    /**
     * DISTRACT_STATUS_ON = 1;
     * DISTRACT_STATUS_OFF = 2;
     *
     * @return
     */
    int getDistractionStatus();
}
