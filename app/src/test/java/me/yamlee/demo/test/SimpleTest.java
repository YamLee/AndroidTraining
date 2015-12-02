package me.yamlee.demo.test;

import org.hamcrest.generator.config.XmlConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import yamlee.com.demo.BuildConfig;
/**
 * Created by yamlee on 15/10/9.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class SimpleTest {
    @Test
    public void testSimple() {

    }
}
