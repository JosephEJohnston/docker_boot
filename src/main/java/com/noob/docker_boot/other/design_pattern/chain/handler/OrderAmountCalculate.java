package com.noob.docker_boot.other.design_pattern.chain.handler;

import com.noob.docker_boot.other.design_pattern.chain.OrderInfo;

/**
 * 计算金额
 */
public class OrderAmountCalculate extends Handler {
    @Override
    public void process(OrderInfo orderInfo) {
        System.out.println("计算金额-优惠券、VIP、活动打折");

        next.process(orderInfo);
    }
}
