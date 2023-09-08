package com.noob.docker_boot.other.design_pattern.chain.handler;

import com.noob.docker_boot.other.design_pattern.chain.OrderInfo;

/**
 * 抽象处理者
 */
public abstract class Handler {
    protected Handler next;

    public void setNext(Handler handler) {
        this.next = handler;
    }

    /**
     * 处理过程
     * 需要子类进行实现
     */
    public abstract void process(OrderInfo orderInfo);
}
