package com.demo.platform.carapi.callback;

import android.car.hardware.scu.CarScuManager;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public class ScuCallbackAdapter extends BaseCallbackAdapter {
    public static final Integer[] PROP_IDS = {
            CarScuManager.ID_SCU_FRONT_COLLISION_SECURITY,
            CarScuManager.ID_INTELLIGENT_SPEED_LIMIT,
            CarScuManager.ID_SCU_SIDE_REVERSION_WARNING,
            CarScuManager.ID_SCU_LANE_DEPARTURE_WARNING,
            CarScuManager.ID_SCU_BLIND_AREA_DETECTION_WARNING,
            CarScuManager.ID_SCU_KEYPARK_SWST};

    @Override
    final protected void onChangeEvent(int propertyId, Object data) {
        switch (propertyId) {
            case CarScuManager.ID_SCU_FRONT_COLLISION_SECURITY:
                onFrontCollisionSecurity((int) data);
                break;

            case CarScuManager.ID_INTELLIGENT_SPEED_LIMIT:
                onIntelligentSpeedLimit((int) data);
                break;

            case CarScuManager.ID_SCU_SIDE_REVERSION_WARNING:
                onSideReversionWarning((int) data);
                break;

            case CarScuManager.ID_SCU_LANE_DEPARTURE_WARNING:
                onLaneDepartureWarning((int) data);
                break;

            case CarScuManager.ID_SCU_BLIND_AREA_DETECTION_WARNING:
                onBlindAreADetectionWarning((int) data);
                break;

            case CarScuManager.ID_SCU_KEYPARK_SWST:
                onKeyParkSwst((int) data);
                break;
        }
    }

    public void onFrontCollisionSecurity(int value) {
    }

    public void onIntelligentSpeedLimit(int value) {
    }

    public void onSideReversionWarning(int value) {
    }

    public void onLaneDepartureWarning(int value) {
    }

    public void onBlindAreADetectionWarning(int value) {
    }

    public void onKeyParkSwst(int value) {
    }
}
