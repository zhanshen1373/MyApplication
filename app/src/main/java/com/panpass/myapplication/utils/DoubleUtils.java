package com.panpass.myapplication.utils;

/**
 * author：luck
 * project：PictureSelector
 * package：com.wiwork.common.lib.tool
 * email：893855882@qq.com
 * data：2017/5/25
 */

public class DoubleUtils {
    private final static long TIME = 800;
    /**
     * Prevent continuous click, jump two pages
     */
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < TIME) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
