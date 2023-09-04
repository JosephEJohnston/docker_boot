package com.noob.docker_boot.other.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolCase {

    static class FixedThreadDemo implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();

            for (int i = 0; i < 2; i++) {
                System.out.println(name + ": " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new FixedThreadDemo());
            Thread.sleep(10);
        }

        executorService.shutdown();
    }
}
