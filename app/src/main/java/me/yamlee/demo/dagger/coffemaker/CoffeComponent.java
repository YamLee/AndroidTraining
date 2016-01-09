package me.yamlee.demo.dagger.coffemaker;

import dagger.Component;

/**
 * Created by yamlee on 16/1/9.
 */
@Component(modules = {CoffeeModule.class})
public interface CoffeComponent {
    CoffeeMaker maker();
}
