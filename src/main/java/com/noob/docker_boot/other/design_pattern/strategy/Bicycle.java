package com.noob.docker_boot.other.design_pattern.strategy;

public class Bicycle implements TravelStrategy {

    @Override
    public void travel() {
        System.out.println("选择自行车出行...");
    }
}
