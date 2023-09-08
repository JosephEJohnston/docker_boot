package com.noob.docker_boot.other.design_pattern.chain.handler;

import com.noob.docker_boot.other.design_pattern.chain.OrderInfo;

/**
 * 订单校验
 */
public class OrderValidation extends Handler {

    @Override
    public void process(OrderInfo orderInfo) {
        System.out.println("校验订单基本信息");

        // 校验
        next.process(orderInfo);
    }
}
