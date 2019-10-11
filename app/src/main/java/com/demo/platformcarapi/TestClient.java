package com.demo.platformcarapi;

import android.util.Log;
import android.view.KeyEvent;

import com.demo.platform.annotation.RunOnBackGround;
import com.demo.platform.carapi.CarApi;
import com.demo.platform.carapi.callback.BcmCallbackAdapter;
import com.demo.platform.carapi.callback.EpsCallbackAdapter;
import com.demo.platform.carapi.callback.EspCallbackAdapter;
import com.demo.platform.carapi.callback.IcmCallbackAdapter;
import com.demo.platform.carapi.callback.McuCallbackAdapter;
import com.demo.platform.carapi.callback.MsmCallbackAdapter;
import com.demo.platform.carapi.callback.ScuCallbackAdapter;
import com.demo.platform.carapi.callback.TpmsCallbackAdapter;
import com.demo.platform.carapi.callback.VcuCallbackAdapter;
import com.demo.platform.carapi.strategy.bcm.BcmStrategy;
import com.demo.platform.carapi.strategy.ciu.CiuStrategy;
import com.demo.platform.carapi.strategy.icm.IcmStrategy;
import com.demo.platform.carapi.strategy.mcu.McuStrategy;
import com.demo.platform.carapi.strategy.scu.ScuStrategy;
import com.demo.platform.carapi.strategy.tpms.TpmsStrategy;
import com.demo.platform.carapi.strategy.vcu.VcuStrategy;
import com.demo.platform.annotation.RunOnMainThread;
import com.demo.platform.carapi.callback.InputCallbackAdapter;
import com.demo.platform.carapi.strategy.eps.EpsStrategy;
import com.demo.platform.carapi.strategy.esp.EspStrategy;
import com.demo.platform.carapi.strategy.hvac.HvacStrategy;
import com.demo.platform.carapi.strategy.input.InputStrategy;
import com.demo.platform.carapi.strategy.msm.MsmStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-3-22
 */
public class TestClient {
    private static final String TAG = "TestClient";

    private BcmStrategy mBcmStrategy;
    private McuStrategy mMcuStrategy;
    private VcuStrategy mVcuStrategy;
    private IcmStrategy mIcmStrategy;
    private TpmsStrategy mTpmsStrategy;
    private EpsStrategy mEpsStrategy;
    private ScuStrategy mScuStrategy;
    private EspStrategy mEspStrategy;
    private InputStrategy mInputStrategy;
    private MsmStrategy mMsmStrategy;
    private CiuStrategy mCiuStrategy;
    private HvacStrategy mHvacStrategy;

    private BcmCallbackAdapter mBcmCallback = new BcmCallbackAdapter() {

        @RunOnMainThread
        @Override
        public void onLightMeHome(int value) {
            Log.d(TAG, "onLightMeHome() value:" + value + "  thread: " + Thread.currentThread().getName());
        }

    };
    private McuCallbackAdapter mMcuCallback = new McuCallbackAdapter() {
        @Override
        public void onIgStatusChanged(int[] status) {
            super.onIgStatusChanged(status);
        }
    };

    private VcuCallbackAdapter mVcuCallback = new VcuCallbackAdapter() {

        @RunOnBackGround
        @Override
        public void onDriveModeGet(int mode) {

        }
    };

    private IcmCallbackAdapter mIcmCallback = new IcmCallbackAdapter() {

        @Override
        @RunOnMainThread
        public void onAlarmVolume(int value) {
            super.onAlarmVolume(value);
        }
    };

    private TpmsCallbackAdapter mTpmsCallback = new TpmsCallbackAdapter();
    private EpsCallbackAdapter mEpsCallback = new EpsCallbackAdapter();
    private ScuCallbackAdapter mScuCallback = new ScuCallbackAdapter();
    private EspCallbackAdapter mEspCallback = new EspCallbackAdapter();
    private InputCallbackAdapter mInputCallback = new InputCallbackAdapter() {
        @Override
        public void onUserDefButton(KeyEvent keyEvent) {
        }
    };
    private MsmCallbackAdapter mMsmCallback = new MsmCallbackAdapter();

    public void test() {
        mBcmCallback.onLightMeHome(11);
    }

    public void init() {
        mBcmStrategy = (BcmStrategy) CarApi.getCarApi(CarApi.API_BCM);
        mBcmStrategy.addCarServiceCallback(mBcmCallback);

        mMcuStrategy = (McuStrategy) CarApi.getCarApi(CarApi.API_MCU);
        mMcuStrategy.addCarServiceCallback(mMcuCallback);

        mVcuStrategy = (VcuStrategy) CarApi.getCarApi(CarApi.API_VCU);
        mVcuStrategy.addCarServiceCallback(mVcuCallback);

        mIcmStrategy = (IcmStrategy) CarApi.getCarApi(CarApi.API_ICM);
        mIcmStrategy.addCarServiceCallback(mIcmCallback);

        mTpmsStrategy = (TpmsStrategy) CarApi.getCarApi(CarApi.API_TPMS);
        mTpmsStrategy.addCarServiceCallback(mTpmsCallback);

        mEpsStrategy = (EpsStrategy) CarApi.getCarApi(CarApi.API_EPS);
        mEpsStrategy.addCarServiceCallback(mEpsCallback);

        mScuStrategy = (ScuStrategy) CarApi.getCarApi(CarApi.API_SCU);
        mScuStrategy.addCarServiceCallback(mScuCallback);

        mEspStrategy = (EspStrategy) CarApi.getCarApi(CarApi.API_ESP);
        mEspStrategy.addCarServiceCallback(mEspCallback);

        mInputStrategy = (InputStrategy) CarApi.getCarApi(CarApi.API_INPUT);
        mInputStrategy.addCarServiceCallback(mInputCallback);

        mMsmStrategy = (MsmStrategy) CarApi.getCarApi(CarApi.API_MSM);
        mMsmStrategy.addCarServiceCallback(mMsmCallback);

        mCiuStrategy = (CiuStrategy) CarApi.getCarApi(CarApi.API_CIU);
        mHvacStrategy = (HvacStrategy) CarApi.getCarApi(CarApi.API_HVAC);
    }

    void destroy() {
        mBcmStrategy.removeCarServiceCallback(mBcmCallback);
        mMcuStrategy.removeCarServiceCallback(mMcuCallback);
        mVcuStrategy.removeCarServiceCallback(mVcuCallback);
        mIcmStrategy.removeCarServiceCallback(mIcmCallback);
        mTpmsStrategy.removeCarServiceCallback(mTpmsCallback);
        mEpsStrategy.removeCarServiceCallback(mEpsCallback);
        mScuStrategy.removeCarServiceCallback(mScuCallback);
        mEspStrategy.removeCarServiceCallback(mEspCallback);
        mInputStrategy.removeCarServiceCallback(mInputCallback);
    }
}
