package com.demo.platform.carapi.callback;

import android.car.hardware.avas.CarAvasManager;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public class AvasCallbackAdapter extends BaseCallbackAdapter {
    public static final Integer[] PROP_IDS = {
            CarAvasManager.ID_AVAS_SWSTCMD,
            CarAvasManager.ID_AVAS_LOWSPEEDSOUND_CFG};

    @Override
    final protected void onChangeEvent(int propertyId, Object data) {
        switch (propertyId) {
            case CarAvasManager.ID_AVAS_SWSTCMD:
                onLowSpeedSoundSwitch((int) data);
                break;

            case CarAvasManager.ID_AVAS_LOWSPEEDSOUND_CFG:
                onLowSpeedSoundChanged((int) data);
                break;
        }
    }

    public void onLowSpeedSoundSwitch(int switchType) {
    }

    public void onLowSpeedSoundChanged(int sound) {
    }
}
