package com.newgate.ecotransandroid;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class EcotransApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
