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
//        assertThat(true, is(false));
//        assertThat(test,hasProperty("test"));
//        String test = "test";
//        anything("anything will match");
//        int result = 1 + 2;
//        assertThat(result, describedAs("A integer should equals %0 ", equalTo(2), 2));
//        assertThat(result,allOf());
//        assertThat(2,hasToString("3"));
//        assertThat(1.99,closeTo(2.0,1.0));
//        assertThat(null,notTextEmpty());
        try {
            XmlConfigurator.main(new String[]{"custom_matchers.xml"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
