package com.example.anotherapp;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceIntent = new Intent();
        serviceIntent.setComponent(new ComponentName("com.example.xuepeng.startservicefromanotherapp","com.example.xuepeng.startservicefromanotherapp.AppService"));
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStartService:
                startService(serviceIntent);

                break;

            case R.id.btnStopService:
                stopService(serviceIntent);
                break;
        }

    }
}
