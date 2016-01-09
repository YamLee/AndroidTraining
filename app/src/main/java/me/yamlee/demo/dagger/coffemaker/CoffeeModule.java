package me.yamlee.demo.dagger.coffemaker;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yamlee on 16/1/9.
 */
@Module
public class CoffeeModule {
    @Provides
    public Heater provideHeater() {
        return new ElectricHeater();
    }

    @Provides
    public Pump providePump(CustomPump customPump) {
        return customPump;
    }

//    @Provides
//    CoffeeMaker provideCoffeeMaker(CoffeeMaker coffeeMaker) {
//        return coffeeMaker;
//    }
}
