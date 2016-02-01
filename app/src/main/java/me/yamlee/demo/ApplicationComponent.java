package me.yamlee.demo;

import dagger.Component;

/**
 * Created by yamlee on 16/1/9.
 */
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(DemoApplication demoApplication);

    void inject(BaseActivity baseActivity);

    void inject(MainListActivity mainListActivity);

    void testAnother(DemoApplication demoApplication);
}
