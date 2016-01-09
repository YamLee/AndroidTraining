package me.yamlee.demo.dagger.coffemaker;

/**
 * Created by yamlee on 16/1/9.
 */
public class ElectricHeater implements Heater {
    private boolean isHot;

    @Override
    public void on() {
        System.out.println("heater on ----- heating");
        isHot = true;
    }

    @Override
    public void off() {
        isHot = false;
        System.out.println("heater off ");
    }

    @Override
    public boolean isHot() {
        return isHot;
    }
}
