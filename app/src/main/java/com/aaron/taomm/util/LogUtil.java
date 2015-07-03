package com.aaron.taomm.util;

import android.util.Log;

import com.aaron.taomm.BuildConfig;


/**
 * Created by Aaron on 15/7/2.
 */
public class LogUtil {

    private static final boolean LOG_DEBUG = BuildConfig.LOG_DEBUG;

    public static void v(String tag, String msg) {
        if (LOG_DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void v(String tag, String msg, Throwable tr) {
        if (LOG_DEBUG) {
            Log.v(tag, msg,tr);
        }
    }

    public static void d(String tag, String msg) {
        if (LOG_DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg, Throwable tr) {
        if (LOG_DEBUG) {
            Log.v(tag, msg,tr);
        }
    }

    public static void i(String tag, String msg) {
        if (LOG_DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void i(String tag, String msg, Throwable tr) {
        if (LOG_DEBUG) {
            Log.v(tag, msg,tr);
        }
    }

    public static void w(String tag, String msg) {
        if (LOG_DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void w(String tag, String msg, Throwable tr) {
        if (LOG_DEBUG) {
            Log.v(tag, msg,tr);
        }
    }

    public static void e(String tag, String msg) {
        if (LOG_DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (LOG_DEBUG) {
            Log.v(tag, msg,tr);
        }
    }

}
