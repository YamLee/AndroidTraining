package me.yamlee.demo.test;

import org.junit.Test;

/**
 * Created by yamlee on 16/2/26.
 */
public class TestEnum extends BaseRobolectricTestCase {
    public enum FRUIT{
        APPLE,ORANGE
    }
    @Test
    public void testEnum() {
        System.out.println(FRUIT.APPLE.toString());
    }
}
