package yamlee.com.androidexampleproject.component.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import yamlee.com.androidexampleproject.R;

public class ServiceActivity extends Activity {

    private static final String TAG = "Service_Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void unbindService(View view) {

    }


    public void bindService_binder(View view) {
        Log.i(TAG, "bindservice btn onclicked!");
        Intent intet = new Intent(this, DemoService.class);
        intet.putExtra(DemoService.BINDER_COMMUNICATE_WAY_KEY,DemoService.BINDER_COMMUNICATE_WAY_VALUE);
        bindService(intet, new BinderServiceConnection(), BIND_AUTO_CREATE);
    }

    public void bindService_messenger(View view) {
        Log.i(TAG,"bindservice_messenger clicked");
        Intent intet = new Intent(this, DemoService.class);
        intet.putExtra(DemoService.MESSENGER_COMMUNICATE_WAY_KEY,DemoService.MESSENGER_COMMUNICATE_WAY_VALUE);
        bindService(intet, new MessengerServiceConnection(), BIND_AUTO_CREATE);
    }

    class MessengerServiceConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Messenger messenger = new Messenger(service);
            Message msg = Message.obtain(null,DemoService.MSG_WHAT_SAY_HELLO);
            try {
                messenger.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }


    class BinderServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            DemoService.MyBider binder = (DemoService.MyBider) service;
            DemoService myService = binder.getService();
            int randomNum = myService.getRandomNum();
            Log.i(TAG, "service rander num --->" + randomNum);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
