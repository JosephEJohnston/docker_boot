package com.noob.docker_boot.other.thread.safe;

// 死锁产生条件
public class DeadLock {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (a) {
                System.out.println("t1-lock a");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (b) {
                    System.out.println("t1-lock b");
                    System.out.println("t1-操作...");
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (b) {
                System.out.println("t2-lock b");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (a) {
                    System.out.println("t2-lock a");
                    System.out.println("t2-操作...");
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
