package com.noob.docker_boot.other.thread.sample;

public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            String name = Thread.currentThread().getName();

            threadLocal.set("itcast");

            print(name);

            System.out.println(name + "-after remove : " + threadLocal.get());
        }, "t1").start();

        new Thread(() -> {
            String name = Thread.currentThread().getName();

            threadLocal.set("itheima");

            print(name);

            System.out.println(name + "-after remove : " + threadLocal.get());
        }, "t2").start();
    }

    private static void print(String str) {
        System.out.println(str + " :" + threadLocal.get());
        threadLocal.remove();
    }
}
