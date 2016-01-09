package me.yamlee.demo.dagger.coffemaker;

import javax.inject.Inject;

/**
 * Created by yamlee on 16/1/9.
 */
public class CoffeeMaker {
    private Heater heater;
    private Pump pump;

    @Inject
    public CoffeeMaker(Heater heater, Pump pump) {
        this.heater = heater;
        this.pump = pump;
    }

    public void brew() {
        heater.on();
        pump.pump();
        heater.off();
    }
}
