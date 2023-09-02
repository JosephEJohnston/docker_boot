package com.noob.docker_boot.other.thread;

// 如何让三个线程按序执行？
public class ThreadOrderTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("t1"));

        Thread t2 = new Thread(() -> {
            try {
                // 加入线程 t1，只有 t1 执行完后，才执行 t2
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2");
        });

        Thread t3 = new Thread(() -> {
            try {
                // 加入线程 t2，只有 t2 完成后，才执行 t3
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3");
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
