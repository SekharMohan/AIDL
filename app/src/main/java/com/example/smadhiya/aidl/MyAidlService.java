package com.example.smadhiya.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

public class MyAidlService extends Service{

    private MyServer myServer = new MyServer();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myServer;
    }

    static class MyServer extends IMyAidlInterface.Stub {

        @Override
        public int addVal(int val1, int val2) throws RemoteException {
            return val1+val2;
        }
    }
}
