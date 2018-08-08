package com.leejoonhee.hangulclockforandroid.lockscreen;

import android.app.Application;

public class LockApplication extends Application {

   public boolean lockScreenShow=false;
    public int notificationId=1900;

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
