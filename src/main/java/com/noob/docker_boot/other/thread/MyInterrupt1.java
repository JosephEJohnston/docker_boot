package com.noob.docker_boot.other.thread;

public class MyInterrupt1 extends Thread {
    // 线程执行的退出标记
    public volatile boolean flag = false;

    @Override
    public void run() {
        while (!flag) {
            System.out.println("MyThread...run...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
