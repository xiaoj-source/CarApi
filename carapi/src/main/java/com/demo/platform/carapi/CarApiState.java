package com.demo.platform.carapi;

import com.demo.platform.carapi.strategy.bcm.BcmStrategy;
import com.demo.platform.carapi.strategy.ciu.CiuStrategy;
import com.demo.platform.carapi.strategy.icm.IcmStrategy;
import com.demo.platform.carapi.strategy.mcu.McuStrategy;
import com.demo.platform.carapi.strategy.scu.ScuStrategy;
import com.demo.platform.carapi.strategy.tpms.TpmsStrategy;
import com.demo.platform.carapi.strategy.vcu.VcuStrategy;
import com.demo.platform.carapi.strategy.avas.AvasStrategy;
import com.demo.platform.carapi.strategy.eps.EpsStrategy;
import com.demo.platform.carapi.strategy.esp.EspStrategy;
import com.demo.platform.carapi.strategy.hvac.HvacStrategy;
import com.demo.platform.carapi.strategy.input.InputStrategy;
import com.demo.platform.carapi.strategy.msm.MsmStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-4-16
 */
public class CarApiState {

    public static BcmStrategy getBcm() {
        return (BcmStrategy) CarApi.getCarApi(CarApi.API_BCM);
    }

    public static McuStrategy getMcu() {
        return (McuStrategy) CarApi.getCarApi(CarApi.API_MCU);
    }

    public static VcuStrategy getVcu() {
        return (VcuStrategy) CarApi.getCarApi(CarApi.API_VCU);
    }


    public static IcmStrategy getIcm() {
        return (IcmStrategy) CarApi.getCarApi(CarApi.API_ICM);
    }


    public static TpmsStrategy getTpms() {
        return (TpmsStrategy) CarApi.getCarApi(CarApi.API_TPMS);
    }

    public static EpsStrategy getEps() {
        return (EpsStrategy) CarApi.getCarApi(CarApi.API_EPS);
    }

    public static ScuStrategy getScu() {
        return (ScuStrategy) CarApi.getCarApi(CarApi.API_SCU);
    }

    public static EspStrategy getEsp() {
        return (EspStrategy) CarApi.getCarApi(CarApi.API_ESP);
    }

    public static InputStrategy getInput() {
        return (InputStrategy) CarApi.getCarApi(CarApi.API_INPUT);
    }

    public static AvasStrategy getAvas() {
        return (AvasStrategy) CarApi.getCarApi(CarApi.API_AVAS);
    }

    public static MsmStrategy getMsm() {
        return (MsmStrategy) CarApi.getCarApi(CarApi.API_MSM);
    }

    public static CiuStrategy getCiu() {
       return (CiuStrategy) CarApi.getCarApi(CarApi.API_CIU);
    }

    public static HvacStrategy getHvac() {
        return (HvacStrategy) CarApi.getCarApi(CarApi.API_HVAC);
    }
}
