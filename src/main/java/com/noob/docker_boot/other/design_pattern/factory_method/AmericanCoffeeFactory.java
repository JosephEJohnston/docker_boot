package com.noob.docker_boot.other.design_pattern.factory_method;

import com.noob.docker_boot.other.design_pattern.AmericanCoffee;
import com.noob.docker_boot.other.design_pattern.Coffee;

public class AmericanCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
