package me.yamlee.demo.test.dagger;

import org.junit.Test;

import me.yamlee.demo.dagger.coffemaker.CoffeeMaker;
import me.yamlee.demo.dagger.coffemaker.CustomPump;
import me.yamlee.demo.dagger.coffemaker.DaggerCoffeComponent;
import me.yamlee.demo.dagger.coffemaker.ElectricHeater;
import me.yamlee.demo.dagger.coffemaker.Heater;
import me.yamlee.demo.dagger.coffemaker.Pump;
import me.yamlee.demo.test.BaseRobolectricTestCase;

/**
 * Created by yamlee on 16/1/9.
 */
public class TestCoffeeMaker extends BaseRobolectricTestCase {
    @Test
    public void test() {
        Heater heater = new ElectricHeater();
        Pump pump = new CustomPump(heater);
        CoffeeMaker coffeeMaker = new CoffeeMaker(heater, pump);
        coffeeMaker.brew();
    }

    @Test
    public void testDagger() {
        DaggerCoffeComponent.create().maker().brew();
    }
}
