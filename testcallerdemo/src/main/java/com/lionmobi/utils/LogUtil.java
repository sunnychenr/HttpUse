package com.lionmobi.utils;

import android.util.Log;

/**
 * Created by ChenR on 2016/12/27.
 */

public class LogUtil {

    private static final String TAG = "chenr";
    private static boolean isOutput = true;

    public static void log (String log) {
        if (isOutput) {
            Log.d(TAG, log);
        }
    }

}
