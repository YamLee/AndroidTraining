package me.yamlee.demo;

import android.app.Application;

/**
 * Created by yamlee on 16/1/9.
 */
public class DemoApplication extends Application{
    private ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
        applicationComponent.testAnother(this);
    }
}
