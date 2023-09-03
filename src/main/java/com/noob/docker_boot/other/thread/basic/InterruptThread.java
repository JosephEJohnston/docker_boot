package com.noob.docker_boot.other.thread.basic;

// 如何停止一个正在运行的线程？
public class InterruptThread {

    public static void main(String[] args) throws InterruptedException {
        // main1();
        // main2();
        // main3();
        main4();
    }

    public static void main1() throws InterruptedException {
        MyInterrupt1 t1 = new MyInterrupt1();
        t1.start();

        Thread.sleep(6000);

        t1.flag = true;
    }

    public static void main2() throws InterruptedException {
        MyInterrupt2 t2 = new MyInterrupt2();
        t2.start();

        Thread.sleep(6000);

        t2.stop();
    }

    public static void main3() throws InterruptedException {
        // 打断阻塞线程
        Thread t3 = new Thread(() -> {
            System.out.println("t3 正在运行");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t3");

        t3.start();
        Thread.sleep(500);
        t3.interrupt();
        System.out.println(t3.isInterrupted());
    }

    public static void main4() throws InterruptedException {
        // 打断正常线程
        Thread t4 = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                boolean interrupted = current.isInterrupted();
                if (interrupted) {
                    System.out.println("打断状态：" + interrupted);
                    break;
                }
            }
        }, "t4");

        t4.start();
        Thread.sleep(500);
        t4.interrupt();
    }
}
