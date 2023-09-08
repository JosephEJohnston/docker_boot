package com.noob.docker_boot.other.thread.sample;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        // 初始化了一个倒计时锁，参数为 3
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-begin...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            latch.countDown();
            System.out.println(Thread.currentThread().getName() + "-end...");
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-begin...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            latch.countDown();
            System.out.println(Thread.currentThread().getName() + "-end...");
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-begin...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            latch.countDown();
            System.out.println(Thread.currentThread().getName() + "-end...");
        }).start();

        String name = Thread.currentThread().getName();
        System.out.println(name + "-waiting...");
        // 等待其他线程完成
        latch.await();
        System.out.println(name + "-wait end...");
    }
}
