package com.muke.app.application;

import android.app.Application;

public class MyApplication extends Application {
    public static MyApplication myApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }
    public  static MyApplication getAppInstance(){
        return  myApplication;
    }
}
