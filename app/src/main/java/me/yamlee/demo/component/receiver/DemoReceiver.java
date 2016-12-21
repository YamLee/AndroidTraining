package me.yamlee.demo.component.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by yamlee on 11/14/16.
 */
public class DemoReceiver extends BroadcastReceiver {
    private static final String TAG = "DemoReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive() called with: context = [" + context + "], intent = [" + intent + "]");
        if (intent != null) {
            String action = intent.getAction();
            Log.d(TAG, "onReceive: action:" + action);
        }
    }
}
