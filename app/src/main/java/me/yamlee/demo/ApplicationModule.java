package me.yamlee.demo;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yamlee on 16/1/9.
 */
@Module
public class ApplicationModule {
    private DemoApplication application;

    public ApplicationModule(DemoApplication application) {
        this.application = application;
    }

    @Provides
    public Context provideApplicationContext() {
        return application;
    }

    @Provides
    public LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }

}
