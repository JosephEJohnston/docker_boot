package com.noob.docker_boot.other.design_pattern.chain.handler;

import com.noob.docker_boot.other.design_pattern.chain.OrderInfo;

/**
 * 订单入库
 */
public class OrderCreate extends Handler {
    @Override
    public void process(OrderInfo orderInfo) {
        System.out.println("订单入库");

    }
}
