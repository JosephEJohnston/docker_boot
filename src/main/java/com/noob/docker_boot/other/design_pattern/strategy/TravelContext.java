package com.noob.docker_boot.other.design_pattern.strategy;

public class TravelContext {
    private final TravelStrategy travelStrategy;

    public TravelContext(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void selectTravel() {
        this.travelStrategy.travel();
    }

    public static void main(String[] args) {
        TravelContext travelContext = new TravelContext(new Aircraft());

        travelContext.selectTravel();
    }
}
