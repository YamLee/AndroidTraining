package me.yamlee.demo.dagger.coffemaker;

import javax.inject.Inject;

/**
 * Created by yamlee on 16/1/9.
 */
public class CustomPump implements Pump{
    private Heater heater;

    @Inject
    public CustomPump(Heater heater) {
        this.heater = heater;
    }

    @Override
    public void pump() {
        if (heater.isHot()) {
            System.out.println("pumping------");
        }
    }
}
