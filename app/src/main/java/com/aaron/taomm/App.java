package com.aaron.taomm;

import android.app.Application;
import android.content.Context;

import com.aaron.taomm.net.TaoMMSpider;

/**
 * Created by Aaron on 15/6/29.
 */
public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = getApplicationContext();

        TaoMMSpider.start();
    }

    public static Context getContext() {
        return mContext;
    }
}
