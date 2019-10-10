package com.demo.platform.carapi.callback;

import android.car.hardware.msm.CarMsmManager;
import android.os.SystemClock;

import com.demo.platform.carapi.CarApiState;

/**
 * Created by xiaojun
 *
 * @date 19-3-28
 */
public class MsmCallbackAdapter extends BaseCallbackAdapter {
    public static final Integer[] PROP_IDS = {
            CarMsmManager.ID_MSMD_SEATHORZPOS,
            CarMsmManager.ID_MSMD_SEATVERTICALPOS,
            CarMsmManager.ID_MSMD_SEATILTINGPOS};

    private ChairTask mTask;

    @Override
    final protected void onChangeEvent(int propertyId, Object data) {
        switch (propertyId) {
            case CarMsmManager.ID_MSMD_SEATHORZPOS: //水平-左右
                onDriverSeatHorizPosition((int) data);
                checkChairPos();
                break;

            case CarMsmManager.ID_MSMD_SEATVERTICALPOS: //垂直-上下
                onDriverSeatVertiPosition((int) data);
                checkChairPos();
                break;

            case CarMsmManager.ID_MSMD_SEATILTINGPOS: //靠背-旋转
                onDriverSeatBackPosition((int) data);
                checkChairPos();
                break;

        }
    }

    public void onDriverSeatHorizPosition(int pos) {
    }

    public void onDriverSeatVertiPosition(int pos) {
    }

    public void onDriverSeatBackPosition(int pos) {
    }

    public void onChairPositionChangeEnd() {
    }

    private void checkChairPos() {
        if (mTask == null) {
            mTask = new ChairTask();
            mTask.start();
        }
    }

    private class ChairTask extends Thread {
        private boolean mChanging = true;
        int mLastX = -2;
        int mLastY = -2;
        int mLastZ = -2;

        @Override
        public void run() {
            while (mChanging) {
                int x = CarApiState.getMsm().getDriverSeatHorizPosition();
                int y = CarApiState.getMsm().getDriverSeatVertiPosition();
                int z = CarApiState.getMsm().getDriverSeatBackPosition();

                if (x == mLastX && y == mLastY && z == mLastZ) {
                    onChairPositionChangeEnd();
                    mChanging = false;
                    mTask = null;
                    break;
                }
                SystemClock.sleep(100);
            }
        }
    }

}
