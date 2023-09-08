package com.noob.docker_boot.other.design_pattern.factory.factory_method;

import com.noob.docker_boot.other.design_pattern.factory.Coffee;
import com.noob.docker_boot.other.design_pattern.factory.LatteCoffee;

public class LatteCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
