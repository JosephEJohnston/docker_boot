package com.noob.docker_boot.other.design_pattern.factory_method;

import com.noob.docker_boot.other.design_pattern.Coffee;

public interface CoffeeFactory {
    // 创建咖啡
    Coffee createCoffee();
}
