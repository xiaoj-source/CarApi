package com.demo.platform.carapi;

import android.car.Car;
import android.content.Context;
import android.util.Log;
import android.util.SparseArray;

import com.demo.platform.carapi.callback.ICarConnect;
import com.demo.platform.carapi.strategy.bcm.BcmStrategy;
import com.demo.platform.carapi.strategy.ciu.CiuStrategy;
import com.demo.platform.carapi.strategy.icm.IcmStrategy;
import com.demo.platform.carapi.strategy.mcu.McuStrategy;
import com.demo.platform.carapi.strategy.scu.ScuStrategy;
import com.demo.platform.carapi.strategy.tpms.TpmsStrategy;
import com.demo.platform.carapi.strategy.vcu.VcuStrategy;
import com.demo.platform.carapi.callback.ICarService;
import com.demo.platform.carapi.strategy.avas.AvasStrategy;
import com.demo.platform.carapi.strategy.eps.EpsStrategy;
import com.demo.platform.carapi.strategy.esp.EspStrategy;
import com.demo.platform.carapi.strategy.hvac.HvacStrategy;
import com.demo.platform.carapi.strategy.input.InputStrategy;
import com.demo.platform.carapi.strategy.msm.MsmStrategy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public final class CarApi {
    private static final String TAG = "CarApi";

    public static final int API_BCM = 100;
    public static final int API_MCU = 101;
    public static final int API_VCU = 102;
    public static final int API_ICM = 103;
    public static final int API_TPMS = 104;
    public static final int API_EPS = 105;
    public static final int API_SCU = 106;
    public static final int API_ESP = 107;
    public static final int API_INPUT = 108;
    public static final int API_AVAS = 109;
    public static final int API_MSM = 110;
    public static final int API_CIU = 111;
    public static final int API_HVAC = 112;

    private static int[] APIS = {
            API_BCM, API_MCU, API_VCU,
            API_ICM, API_TPMS, API_EPS,
            API_SCU, API_ESP, API_INPUT,
            API_AVAS, API_MSM, API_CIU, API_HVAC};

    private static String mCarType = Car.CAR_TYPE_D21;

    private static XPCar sCar;
    private static SparseArray<ICarService> mStrategyCache = new SparseArray<>();
    private static Set<ICarService> mRegisters = new HashSet<>();

    static {
        initVersion();
    }

    public static void init(Context context) {
        connectCar(context);
        initCarService();
    }

    private static void initVersion() {
        try {
            int hardVersion = Car.getHardwareVersion();
            String carType = Car.getHardwareCarType();
            String stage = Car.getHardwareCarStage();
            Log.d(TAG, "hardVersion: " + hardVersion + " carType:" + carType + "  stage:" + stage);

            mCarType = carType;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void connectCar(Context context) {
        Log.i(TAG, "execute connectCar()...");
        sCar = new XPCar(context);
        sCar.register(new ICarConnect() {
            @Override
            public void onConnected() {
                Log.i(TAG, "Car has been connected!");
                for (ICarService service : mRegisters) {
                    service.register();
                    Log.i(TAG, "Registered: " + service.getServiceName());
                }
                mRegisters.clear();
            }

            @Override
            public void onDisconnected() {
                Log.e(TAG, "Car has not been connected.");
            }
        });
        sCar.connect();
    }

    private static void initCarService() {
        if (APIS == null) {
            throw new IllegalArgumentException("initCarService error, param APIS is not correct.");
        }
        for (int api : APIS) {
            getCarApi(api);
        }
    }

    public static Car getCar() {
        return (Car) sCar.getCar();
    }

    private synchronized static ICarService createCarService(int api) {
        assertApiName(api);
        ICarService carService = null;
        switch (api) {
            case API_BCM:
                carService = new BcmStrategy();
                break;

            case API_MCU:
                carService = new McuStrategy();
                break;

            case API_VCU:
                carService = new VcuStrategy();
                break;

            case API_ICM:
                carService = new IcmStrategy();
                break;

            case API_TPMS:
                carService = new TpmsStrategy();
                break;

            case API_EPS:
                carService = new EpsStrategy();
                break;

            case API_SCU:
                carService = new ScuStrategy();
                break;

            case API_ESP:
                carService = new EspStrategy();
                break;

            case API_INPUT:
                carService = new InputStrategy();
                break;

            case API_AVAS:
                carService = new AvasStrategy();
                break;

            case API_MSM:
                carService = new MsmStrategy();
                break;

            case API_CIU:
                carService = new CiuStrategy();
                break;

            case API_HVAC:
                carService = new HvacStrategy();
                break;
        }
        return carService;
    }

    public synchronized static ICarService getCarApi(int api) {
        ICarService service = mStrategyCache.get(api);
        if (service == null) {
            service = createCarService(api);
            if (sCar.isConnected()) {
                service.register();
            } else {
                Log.i(TAG, "Need Register: " + service.getServiceName());
                mRegisters.add(service);
            }
            mStrategyCache.put(api, service);
        }
        return service;
    }

    public static String getCarVersion() {
        return mCarType;
    }

    private static void assertApiName(int api) {
        if (api != API_BCM
                && api != API_MCU
                && api != API_VCU
                && api != API_ICM
                && api != API_TPMS
                && api != API_EPS
                && api != API_SCU
                && api != API_ESP
                && api != API_INPUT
                && api != API_AVAS
                && api != API_MSM
                && api != API_CIU
                && api != API_HVAC) {
            throw new IllegalArgumentException("Error Car API name!");
        }
    }
}
