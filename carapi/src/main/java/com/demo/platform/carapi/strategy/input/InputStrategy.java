package com.demo.platform.carapi.strategy.input;

import android.car.Car;

import com.demo.platform.carapi.strategy.BaseStrategy;

/**
 * Created by xiaojun
 *
 * @date 19-3-21
 */
public class InputStrategy extends BaseStrategy implements IInputStrategy {
    private static final String TAG = "InputStrategy";

    /**
     * 方向盘调高风速
     */
    public static final int KEYCODE_KNOB_WIND_SPD_UP = 500;
    /**
     * 方向盘调低风速
     */
    public static final int KEYCODE_KNOB_WIND_SPD_DOWN = 501;
    /**
     * 方向盘调高仪表亮度
     */
    public static final int KEYCODE_KNOB_BACKLIGHT_UP = 502;
    /**
     * 方向盘调低仪表亮度
     */
    public static final int KEYCODE_KNOB_BACKLIGHT_DOWN = 503;
    /**
     * 方向盘调高座椅温度
     */
    public static final int KEYCODE_KNOB_TEMP_UP = 504;
    /**
     * 方向盘调低座椅温度
     */
    public static final int KEYCODE_KNOB_TEMP_DOWN = 505;
    /**
     * 切换到 FM
     */
    public static final int KEYCODE_KNOB_FM = 507;
    /**
     * 切换到蓝牙音乐
     */
    public static final int KEYCODE_KNOB_BT = 508;
    /**
     * 切换到网络 FM
     */
    public static final int KEYCODE_KNOB_WEB_RADIO = 509;
    /**
     * 切换到音乐
     */
    public static final int KEYCODE_KNOB_MUSIC = 510;
    /**
     * 上一首
     */
    public static final int KEYCODE_PREVIOUS_BUTTON = 513;
    /**
     * 下一首
     */
    public static final int KEYCODE_NEXT_BUTTON = 514;
    /**
     * 方向盘左边滚轮按压
     */
    public static final int KEYCODE_LEFT_OK_BUTTON = 516;
    /**
     * 音量上
     */
    public static final int KEYCODE_KNOB_VOL_UP = 520;
    /**
     * 音量下
     */
    public static final int KEYCODE_KNOB_VOL_DOWN = 521;
    /**
     * 吹风模式
     */
    public static final int KEYCODE_WIND_EXIT_MODE = 524;
    /**
     * 额外扩展Event，用于未注册时扩展使用
     */
    public static final int KEYCODE_KNOB_TEM_EXTRA = 1000001;

    /**
     * 用户自定义按键，车顶相机拍照
     */
    public static final int KEYCODE_USER_DEF_BUTTON = 511;

    /**
     * 方向盘返回键
     */
    public static final int KEYCODE_BACK_BUTTON = 512;

    /**
     * 方向盘语音键
     */
    public static final int KEYCODE_VOICE_BUTTON = 515;

    /**
     * USB音乐
     */
    public static final int KEYCODE_KNOB_USB_MUSIC = 526;
    /**
     * 有声读物
     */
    public static final int KEYCODE_KNOB_TALKING_BOOK = 527;

    public InputStrategy() {
        super();
    }

    @Override
    public String getServiceName() {
        return Car.XP_INPUT_SERVICE;
    }

    @Override
    protected Integer[] getPropIds() {
        return new Integer[0];
    }

    @Override
    public void register() {
    }

}
