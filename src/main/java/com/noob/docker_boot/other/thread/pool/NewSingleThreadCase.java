package com.noob.docker_boot.other.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewSingleThreadCase {

    static int count = 0;

    static class Demo implements Runnable {

        @Override
        public void run() {
            count++;
            System.out.println(Thread.currentThread().getName() + ": " + count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            exec.execute(new Demo());
            Thread.sleep(5);
        }

        exec.shutdown();
    }
}
