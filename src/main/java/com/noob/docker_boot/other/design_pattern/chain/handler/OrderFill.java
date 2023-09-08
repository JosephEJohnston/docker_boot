package com.noob.docker_boot.other.design_pattern.chain.handler;

import com.noob.docker_boot.other.design_pattern.chain.OrderInfo;

/**
 * 补充订单信息
 */
public class OrderFill extends Handler {

    @Override
    public void process(OrderInfo orderInfo) {
        System.out.println("补充订单信息");

        next.process(orderInfo);
    }
}
