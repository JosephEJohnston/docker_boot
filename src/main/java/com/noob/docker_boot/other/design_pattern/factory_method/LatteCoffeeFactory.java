package com.noob.docker_boot.other.design_pattern.factory_method;

import com.noob.docker_boot.other.design_pattern.Coffee;
import com.noob.docker_boot.other.design_pattern.LatteCoffee;

public class LatteCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
