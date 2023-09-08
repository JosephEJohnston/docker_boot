package com.noob.docker_boot.other.design_pattern.chain;

import com.noob.docker_boot.other.design_pattern.chain.handler.OrderAmountCalculate;
import com.noob.docker_boot.other.design_pattern.chain.handler.OrderCreate;
import com.noob.docker_boot.other.design_pattern.chain.handler.OrderFill;
import com.noob.docker_boot.other.design_pattern.chain.handler.OrderValidation;

public class Application {
    public static void main(String[] args) {
        // 校验订单
        OrderValidation orderValidation = new OrderValidation();
        // 补充订单信息
        OrderFill orderFill = new OrderFill();
        // 订单算价
        OrderAmountCalculate orderAmountCalculate = new OrderAmountCalculate();
        // 订单落库
        OrderCreate orderCreate = new OrderCreate();

        // 设置责任链路
        orderValidation.setNext(orderFill);
        orderFill.setNext(orderAmountCalculate);
        orderAmountCalculate.setNext(orderCreate);

        // 开始执行
        orderValidation.process(new OrderInfo());
    }
}
