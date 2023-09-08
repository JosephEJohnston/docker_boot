package com.noob.docker_boot.other.design_pattern.strategy;

public class Car implements TravelStrategy {

    @Override
    public void travel() {
        System.out.println("选择汽车出行...");
    }
}
