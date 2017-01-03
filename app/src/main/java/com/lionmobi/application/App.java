package com.lionmobi.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by ChenR on 2016/12/26.
 */

public class App extends Application {

    public static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
    }
}
