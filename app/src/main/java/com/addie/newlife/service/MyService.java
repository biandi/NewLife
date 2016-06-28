package com.addie.newlife.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by di.bian on 2016/6/27.
 */
public class MyService extends Service {
    public static final String TAG = MyService.class.getSimpleName();

    private MyBinder myBinder;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG,"Service====onBind()");
        return myBinder.asBinder();
    }

    @Override
    public void onCreate() {
        Log.v(TAG,"Service====onCreate()");
        myBinder = new MyBinder();
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.v(TAG,"Service====onStart()");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG,"Service====onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.v(TAG,"Service====onDestroy()");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(TAG,"Service====onUnbind()");
        return super.onUnbind(intent);
    }


}
