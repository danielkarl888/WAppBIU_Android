package com.example.wappbiu_android;

import android.app.Application;
import android.content.Context;

public class WAppBIU_Android extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

}
