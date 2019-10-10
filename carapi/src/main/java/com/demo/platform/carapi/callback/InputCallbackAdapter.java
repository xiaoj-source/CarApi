package com.demo.platform.carapi.callback;

import android.view.KeyEvent;

import com.demo.platform.carapi.strategy.input.InputStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-3-29
 */
public class InputCallbackAdapter extends BaseCallbackAdapter {

    @Deprecated
    @Override
    final protected void onChangeEvent(int propertyId, Object data) {
    }

    @Override
    final public void onKeyEvent(KeyEvent keyEvent, int targetDisplay) {
        switch (keyEvent.getKeyCode()) {
            /**
             * 方向盘调高风速
             */
            case InputStrategy.KEYCODE_KNOB_WIND_SPD_UP:
                onIcmWindUpLevel(keyEvent);
                break;
            /**
             * 方向盘调低风速
             */
            case InputStrategy.KEYCODE_KNOB_WIND_SPD_DOWN:
                onIcmWindDownLevel(keyEvent);
                break;
            /**
             * 方向盘调高仪表亮度
             */
            case InputStrategy.KEYCODE_KNOB_BACKLIGHT_UP:
                break;
            /**
             * 方向盘调低仪表亮度
             */
            case InputStrategy.KEYCODE_KNOB_BACKLIGHT_DOWN:
                break;
            /**
             * 方向盘调高座椅温度
             */
            case InputStrategy.KEYCODE_KNOB_TEMP_UP:
                onIcmDriverTempUpValue(keyEvent);
                break;
            /**
             * 方向盘调低座椅温度
             */
            case InputStrategy.KEYCODE_KNOB_TEMP_DOWN:
                onIcmDriverTempDownValue(keyEvent);
                break;
            /**
             * 切换到 FM
             */
            case InputStrategy.KEYCODE_KNOB_FM:
                break;

            /**
             * 切换到蓝牙音乐
             */
            case InputStrategy.KEYCODE_KNOB_BT:
                break;

            /**
             * 切换到网络 FM
             */
            case InputStrategy.KEYCODE_KNOB_WEB_RADIO:
                break;

            /**
             * 切换到音乐
             */
            case InputStrategy.KEYCODE_KNOB_MUSIC:
                break;

            /**
             * 上一首
             */
            case InputStrategy.KEYCODE_PREVIOUS_BUTTON:
                break;

            /**
             * 下一首
             */
            case InputStrategy.KEYCODE_NEXT_BUTTON:
                break;

            /**
             * 方向盘左边滚轮按压
             */
            case InputStrategy.KEYCODE_LEFT_OK_BUTTON:
                break;

            /**
             * 音量上
             */
            case InputStrategy.KEYCODE_KNOB_VOL_UP:
                break;

            /**
             * 音量下
             */
            case InputStrategy.KEYCODE_KNOB_VOL_DOWN:
                break;

            /**
             * 吹风模式
             */
            case InputStrategy.KEYCODE_WIND_EXIT_MODE:
                onIcmWindBlowMode(keyEvent);
                break;

            /**
             * 额外扩展Event，用于未注册时扩展使用
             */
            case InputStrategy.KEYCODE_KNOB_TEM_EXTRA:
                break;


            /**
             * 用户自定义按键，车顶相机拍照
             */
            case InputStrategy.KEYCODE_USER_DEF_BUTTON:
                onUserDefButton(keyEvent);
                break;

            /**
             * 方向盘返回键
             */
            case InputStrategy.KEYCODE_BACK_BUTTON:
                break;


            /**
             * 方向盘语音键
             */
            case InputStrategy.KEYCODE_VOICE_BUTTON:
                break;


            /**
             * USB音乐
             */
            case InputStrategy.KEYCODE_KNOB_USB_MUSIC:
                break;

            /**
             * 有声读物
             */
            case InputStrategy.KEYCODE_KNOB_TALKING_BOOK:
                break;

            default:
                break;
        }
    }

    public void onUserDefButton(KeyEvent keyEvent) {
    }

    public void onIcmWindBlowMode(KeyEvent keyEvent) {
    }

    public void onIcmWindUpLevel(KeyEvent keyEvent) {
    }

    public void onIcmWindDownLevel(KeyEvent keyEvent) {
    }

    public void onIcmDriverTempUpValue(KeyEvent keyEvent) {
    }

    public void onIcmDriverTempDownValue(KeyEvent keyEvent) {
    }

}
