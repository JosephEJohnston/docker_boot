package com.noob.docker_boot.other.design_pattern.strategy;

public class Train implements TravelStrategy {

    @Override
    public void travel() {
        System.out.println("选择火车出行...");
    }
}
