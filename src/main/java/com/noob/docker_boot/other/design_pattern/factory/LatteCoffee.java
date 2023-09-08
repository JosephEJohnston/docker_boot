package com.noob.docker_boot.other.design_pattern.factory;

public class LatteCoffee implements Coffee {
    @Override
    public String getName() {
        return "LatteCoffee";
    }

    @Override
    public void addMilk() {
        System.out.println("LatteCoffee...addMilk...");
    }

    @Override
    public void addSuqar() {
        System.out.println("LatteCoffee...addSquar...");
    }
}
