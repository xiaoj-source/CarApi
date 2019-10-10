package com.demo.platform.utils;

/**
 * Created by xiaojun
 *
 * @date 19-7-16
 */
public class ArrayUtils {
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];

    public static int[] toPrimitive(Integer[] array, int valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_INT_ARRAY;
        } else {
            int[] result = new int[array.length];

            for(int i = 0; i < array.length; ++i) {
                Integer b = array[i];
                result[i] = b == null ? valueForNull : b;
            }

            return result;
        }
    }

    public static float[] toPrimitive(Float[] array, float valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        } else {
            float[] result = new float[array.length];

            for(int i = 0; i < array.length; ++i) {
                Float b = array[i];
                result[i] = b == null ? valueForNull : b;
            }

            return result;
        }
    }
}
