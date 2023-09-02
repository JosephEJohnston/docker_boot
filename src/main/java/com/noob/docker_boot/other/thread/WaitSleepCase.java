package com.noob.docker_boot.other.thread;

// wait 和 sleep 方法的不同？
public class WaitSleepCase {
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        // illegalWait();
        // waiting();
        sleeping();
    }

    private static void illegalWait() throws InterruptedException {
        // 会直接报错，因为要和 synchronized 配合使用
        LOCK.wait();
    }

    private static void waiting() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println("thread lock");
                    LOCK.wait(5000L);
                    System.out.println("thread wait end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");

        t1.start();

        Thread.sleep(100);
        synchronized (LOCK) {
            System.out.println("main unlock");
        }
    }

    private static void sleeping() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println("thread lock");
                    Thread.sleep(5000L);
                    System.out.println("thread sleep end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");

        t1.start();

        Thread.sleep(100);
        synchronized (LOCK) {
            System.out.println("main unlock");
        }
    }
}
