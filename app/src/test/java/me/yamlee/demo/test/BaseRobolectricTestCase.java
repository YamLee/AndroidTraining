package me.yamlee.demo.test;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import me.yamlee.demo.BuildConfig;

/**
 * Created by yamlee on 15/10/9.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class BaseRobolectricTestCase {

}
