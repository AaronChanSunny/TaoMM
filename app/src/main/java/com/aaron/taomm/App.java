package com.aaron.taomm;

import android.app.Application;
import android.content.Context;

/**
 * Created by Aaron on 15/6/29.
 */
public class App extends Application {

    private static final String TAG = App.class.getSimpleName();
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
