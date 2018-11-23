package com.example.laptop88.ezgo.view;

import android.app.Application;

public class EzgoApplication extends Application {

    private static EzgoApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static EzgoApplication getInstance() {
        if (sInstance == null)
            sInstance = new EzgoApplication();
        return sInstance;
    }
}
