package com.example.receiver;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.example.smadhiya.aidl.IMyAidlInterface;

public class MyActivity extends AppCompatActivity{

    private IMyAidlInterface service;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        startService();
    }

    private void startService() {
        Intent intent = new Intent("com.sample.AIDL");
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

                service = IMyAidlInterface.Stub.asInterface(iBinder);
                try {
                 int val =   service.addVal(20,30);
                 System.out.println(val);

                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        },BIND_AUTO_CREATE);
    }
}
