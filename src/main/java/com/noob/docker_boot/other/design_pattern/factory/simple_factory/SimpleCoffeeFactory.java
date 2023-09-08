package com.noob.docker_boot.other.design_pattern.factory.simple_factory;

import com.noob.docker_boot.other.design_pattern.factory.AmericanCoffee;
import com.noob.docker_boot.other.design_pattern.factory.Coffee;
import com.noob.docker_boot.other.design_pattern.factory.LatteCoffee;

public class SimpleCoffeeFactory {

    public static Coffee createCoffee(String type) {
        Coffee coffee = null;

        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        }

        coffee.addMilk();
        coffee.addSuqar();

        return coffee;
    }
}
