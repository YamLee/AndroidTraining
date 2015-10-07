package com.example.testapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.LENGTH_SHORT;


/**
 * Created by yamlee on 15/7/23.
 */
public class DemoService extends Service {

    private static final String TAG ="service_demo";
    public static final String BINDER_COMMUNICATE_WAY_KEY = "binder_communicate_way";
    public static final int BINDER_COMMUNICATE_WAY_VALUE = 1;
    public static final String MESSENGER_COMMUNICATE_WAY_KEY = "messenger_communicate_way";
    public static final int MESSENGER_COMMUNICATE_WAY_VALUE = 2;
    private Binder mBinder;
    public static final int MSG_WHAT_SAY_HELLO = 0;

    static class MyBider extends Binder{
        private DemoService service;

        MyBider(DemoService service) {
            this.service = service;
        }

        public DemoService getService(){
            return service;
        }
    }

    private Handler mHander = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MSG_WHAT_SAY_HELLO:
                    Toast.makeText(DemoService.this,"service say Hello!", LENGTH_SHORT).show();
                    break;
                default:
                    break;

            }
        }
    } ;

    private final Messenger messenger = new Messenger(mHander);

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"DemoService oncreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "DemoService onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "DemoService onDestroy");
        super.onDestroy();

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "DemoService onUnbind");
        return super.onUnbind(intent);

    }

    @Override
    public IBinder onBind(Intent intent) {
        if(intent.getIntExtra(BINDER_COMMUNICATE_WAY_KEY,0)== BINDER_COMMUNICATE_WAY_VALUE){
            mBinder = new MyBider(this);
            return mBinder;
        }
        if(intent.getIntExtra(MESSENGER_COMMUNICATE_WAY_KEY,0)== MESSENGER_COMMUNICATE_WAY_VALUE){

            return messenger.getBinder();
        }

        return null;
    }

    public int getRandomNum(){
        return new Random().nextInt();
    }
}
