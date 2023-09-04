package com.noob.docker_boot.other.thread.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadPoolExecutor {
    private static final Logger log = LoggerFactory
            .getLogger(TestThreadPoolExecutor.class);

    static class MyTask implements Runnable {
        private final String name;
        private final long duration;

        public MyTask(String name) {
            this(name, 0);
        }

        public MyTask(String name, long duration) {
            this.name = name;
            this.duration = duration;
        }

        @Override
        public void run() {
            try {
                log.debug("myThread running..." + this);
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "MyTask(" + name + ")";
        }
    }

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(1);
        ArrayBlockingQueue<Runnable> arrayBlockingQueue =
                new ArrayBlockingQueue<>(2);

        LinkedBlockingDeque<Object> linkedBlockingDeque =
                new LinkedBlockingDeque<>();

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, 3, 0,
                TimeUnit.MILLISECONDS,
                arrayBlockingQueue,
                r -> new Thread(r, "myThread" + count.getAndIncrement()),
                new ThreadPoolExecutor.AbortPolicy());

        showState(arrayBlockingQueue, threadPool);

        threadPool.submit(new MyTask("1", 3600000));
        showState(arrayBlockingQueue, threadPool);

        threadPool.submit(new MyTask("2", 3600000));
        showState(arrayBlockingQueue, threadPool);

        threadPool.submit(new MyTask("3"));
        showState(arrayBlockingQueue, threadPool);

        threadPool.submit(new MyTask("4"));
        showState(arrayBlockingQueue, threadPool);

        threadPool.submit(new MyTask("5", 3600000));
        showState(arrayBlockingQueue, threadPool);

        threadPool.submit(new MyTask("6"));
        showState(arrayBlockingQueue, threadPool);
    }

    // 展示线程池状态
    private static void showState(ArrayBlockingQueue<Runnable> queue, ThreadPoolExecutor executor) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Object> tasks = new ArrayList<>();
        for (Runnable runnable : queue) {
            try {
                Field callable = FutureTask.class.getDeclaredField("callable");
                callable.setAccessible(true);
                Object adapter = callable.get(runnable);
                Class<?> clazz = Class.forName("java.util.concurrent.Executors$RunnableAdapter");
                Field task = clazz.getDeclaredField("task");
                task.setAccessible(true);
                Object object = task.get(adapter);
                tasks.add(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        log.debug("pool size: {}, queue: {}", executor.getPoolSize(), tasks);
    }
}
