package com.addie.newlife.service;

import android.os.RemoteException;

import com.addie.newlife.IMyAidlInterface;

/**
 * Created by di.bian on 2016/6/27.
 */
public class MyBinder extends IMyAidlInterface.Stub {


    @Override
    public int getNum(int num) throws RemoteException {
        return num+1;
    }
}
