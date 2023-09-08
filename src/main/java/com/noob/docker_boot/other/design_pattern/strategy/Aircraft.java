package com.noob.docker_boot.other.design_pattern.strategy;

public class Aircraft implements TravelStrategy {

    @Override
    public void travel() {
        System.out.println("选择飞机出行...");
    }
}
