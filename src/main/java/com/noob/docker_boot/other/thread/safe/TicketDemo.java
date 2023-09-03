package com.noob.docker_boot.other.thread.safe;

// synchronized 用法回顾
public class TicketDemo {

    private static final Object lock = new Object();
    private int ticketNum = 10;

    public void getTicket() {
        synchronized (lock) {
            if (ticketNum <= 0) {
                return;
            }

            System.out.println(Thread.currentThread().getName() +
                    "抢到一张票，剩余：" + ticketNum);

            // 非原子性操作
            ticketNum--;
        }
    }

    public static void main(String[] args) {
        TicketDemo demo = new TicketDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(demo::getTicket).start();
        }
    }
}
