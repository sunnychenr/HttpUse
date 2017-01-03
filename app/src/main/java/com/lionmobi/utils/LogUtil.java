package com.lionmobi.utils;

import android.util.Log;

/**
 * Created by ChenR on 2016/12/26.
 */

public class LogUtil {

    private static final String TAG = "chenr";
    private static boolean isOutPut = true;

    public static void log (String log) {
        if (isOutPut) {
            Log.d(TAG, log);
        }
    }


}
