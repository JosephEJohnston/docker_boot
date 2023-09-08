package com.noob.docker_boot.other.design_pattern.factory.factory_method;

import com.noob.docker_boot.other.design_pattern.factory.Coffee;

public class CoffeeStore {

    private final CoffeeFactory coffeeFactory;

    public CoffeeStore(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee() {
        // 通过工厂获得对象，不需要知道对象实现的细节
        Coffee coffee = coffeeFactory.createCoffee();

        // 添加配料
        coffee.addMilk();
        coffee.addSuqar();

        return coffee;
    }

    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore(new LatteCoffeeFactory());
        Coffee latte = coffeeStore.orderCoffee();
        System.out.println(latte.getName());
    }
}
