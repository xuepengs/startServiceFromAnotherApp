package com.example.anotherapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.xuepeng.startservicefromanotherapp.IAppServiceInterfaceRemoteBinder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    private Intent serviceIntent;
    private EditText editText;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.etInput);
        textView=findViewById(R.id.textView);
        serviceIntent = new Intent();
        serviceIntent.setComponent(new ComponentName("com.example.xuepeng.startservicefromanotherapp","com.example.xuepeng.startservicefromanotherapp.AppService"));

        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.btnBindService).setOnClickListener(this);
        findViewById(R.id.btnUnbindService).setOnClickListener(this);
        findViewById(R.id.btnSync).setOnClickListener(this);

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
            case R.id.btnBindService:
                bindService(serviceIntent,this, Context.BIND_AUTO_CREATE);

                break;

            case R.id.btnUnbindService:
                unbindService(this);
                binder=null;
                break;
            case R.id.btnSync:
                if(binder!=null) {
                    //System.out.println(editText.getText().toString());

                    try {
                        binder.setData(editText.getText().toString());
                        textView.setText(editText.getText().toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
               }
                break;

        }

    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        System.out.println("service connected");
        System.out.println(iBinder);
        binder= IAppServiceInterfaceRemoteBinder.Stub.asInterface(iBinder);
        System.out.println(binder);

    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
    private IAppServiceInterfaceRemoteBinder binder= null;
}
