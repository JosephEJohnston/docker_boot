package com.noob.docker_boot.other.thread.basic;

public class ThreadNotify {

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "...waiting...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "... 被唤醒了");
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "...waiting...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "... 被唤醒了");
            }
        }, "t2");

        t1.start();
        t2.start();

        Thread.sleep(2000);

        synchronized (lock) {
            //lock.notify();
            lock.notifyAll();
        }
    }
}
