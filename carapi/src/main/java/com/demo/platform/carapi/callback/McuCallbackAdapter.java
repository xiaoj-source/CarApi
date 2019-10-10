package com.demo.platform.carapi.callback;

import android.car.hardware.mcu.CarMcuManager;

import com.demo.platform.utils.ArrayUtils;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public class McuCallbackAdapter extends BaseCallbackAdapter {
    private static final String TAG = "McuCallbackAdapter";
    public static final Integer[] PROP_IDS = {
            CarMcuManager.ID_MCU_3S_REPORT_EV, CarMcuManager.ID_MCU_DTC_REPORT_EV};

    @Override
    final protected void onChangeEvent(int propertyId, Object data) {
        switch (propertyId) {
            case CarMcuManager.ID_MCU_3S_REPORT_EV:
                onIgStatusChanged(ArrayUtils.toPrimitive((Integer[]) data, 0));
                break;

            case CarMcuManager.ID_MCU_DTC_REPORT_EV:
                onDtcReportEVChanged(ArrayUtils.toPrimitive((Integer[]) data, 0));
                break;
        }
    }

    public void onIgStatusChanged(int[] status) {
    }

    public void onDtcReportEVChanged(int[] value) {
    }
}
