package com.noob.docker_boot.other.thread.safe;

// 线程间可见性
public class VolatileTestFirst {
    // private static boolean stop = false;
    private volatile static boolean stop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop = true;
            System.out.println(Thread.currentThread().getName() +
                    ": modify stop to true...");
        }, "t1").start();

        new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + stop);
        }, "t2").start();

        // 没加 volatile：t2 读到，但 t3 读不到，因为被 JIT 优化了
        new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
            System.out.println("stopped... c: " + i);
        }, "t3").start();
    }
}

