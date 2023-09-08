package com.noob.docker_boot.other.design_pattern.simple_factory;

import com.noob.docker_boot.other.design_pattern.Coffee;

public class CoffeeStore {
    public static void main(String[] args) {
        Coffee coffee = orderCoffee("latte");
        System.out.println(coffee.getName());
    }

    public static Coffee orderCoffee(String type) {
        // 通过工厂获得对象，不需要知道对象实现的细节
        Coffee coffee = SimpleCoffeeFactory
                .createCoffee(type);

        // 添加配料
        coffee.addMilk();
        coffee.addSuqar();

        return coffee;
    }
}
