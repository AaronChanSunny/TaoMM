package com.aaron.taomm;

import android.app.Application;
import android.content.Context;

/**
 * Created by Aaron on 15/6/29.
 */
public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
