package com.noob.docker_boot.other.design_pattern.factory.factory_method;

import com.noob.docker_boot.other.design_pattern.factory.AmericanCoffee;
import com.noob.docker_boot.other.design_pattern.factory.Coffee;

public class AmericanCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
