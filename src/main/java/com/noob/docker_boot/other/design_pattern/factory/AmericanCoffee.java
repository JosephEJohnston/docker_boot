package com.noob.docker_boot.other.design_pattern.factory;

public class AmericanCoffee implements Coffee {
    @Override
    public String getName() {
        return "AmericanCoffee";
    }

    @Override
    public void addMilk() {
        System.out.println("AmericanCoffee...addMilk...");
    }

    @Override
    public void addSuqar() {
        System.out.println("AmericanCoffee...addSquar...");
    }
}
