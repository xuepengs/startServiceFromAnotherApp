package com.example.xuepeng.startservicefromanotherapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AppService extends Service {
    public AppService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("start service");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("stop service");
    }
}
