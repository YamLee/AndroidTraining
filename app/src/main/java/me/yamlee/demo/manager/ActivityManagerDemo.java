package me.yamlee.demo.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import me.yamlee.demo.R;

/**
 * Created by yamlee on 8/7/16.
 */
public class ActivityManagerDemo extends Activity {
    private ActivityManager activityManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_act_manager);
        activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
    }

    public void addAppTask(View view) {
//        activityManager.addAppTask()
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void getAppTask(View view) {
        List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
        for (int i = 0; i < appTasks.size(); i++) {
            ActivityManager.AppTask appTask = appTasks.get(i);
//            appTask.getTaskInfo().;
        }
    }
}
