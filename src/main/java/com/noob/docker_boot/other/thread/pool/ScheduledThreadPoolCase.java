package com.noob.docker_boot.other.thread.pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolCase {

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + ", 开始：" + new Date());
                Thread.sleep(1000);
                System.out.println(name + ", 结束：" + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);
        System.out.println("程序开始: " + new Date());

        exec.schedule(new Task(), 0, TimeUnit.SECONDS);
        exec.schedule(new Task(), 1, TimeUnit.SECONDS);
        exec.schedule(new Task(), 5, TimeUnit.SECONDS);

        Thread.sleep(5000);

        exec.shutdown();
    }
}
