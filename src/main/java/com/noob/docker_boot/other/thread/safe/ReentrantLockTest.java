package com.noob.docker_boot.other.thread.safe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// synchronized 和 Lock 区别
public class ReentrantLockTest {
    // 创建锁对象
    private static final ReentrantLock lock = new ReentrantLock();
    // 条件 1
    private static final Condition c1 = lock.newCondition();
    // 条件 2
    private static final Condition c2 = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        // 可打断
        // lockInterrupt();

        // 可超时
        // timeOutLock();

        // 多条件变量
        conditionTest();
    }

    // 可打断
    public static void lockInterrupt() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                // 开启可中断的锁
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("等待的过程中被打断");
                return;
            }

            try {
                System.out.println(Thread.currentThread().getName() + ", 获得了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");

        lock.lock();
        System.out.println("主线程获得了锁");
        t1.start();

        try {
            Thread.sleep(1000);
            t1.interrupt();
            System.out.println("执行打断");
        } finally {
            lock.unlock();
        }
    }

    // 锁超时
    public static void timeOutLock() {
        Thread t1 = new Thread(() -> {
            // 尝试获得锁，如果获得锁成功，返回 true，否则返回 false
            try {
                if (!lock.tryLock(2, TimeUnit.SECONDS)) {
                    System.out.println("t1-获得锁失败");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                System.out.println("t1-获得了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");

        lock.lock();
        System.out.println("主线程获得了锁");
        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 多条件变量
    public static void conditionTest() {
        new Thread(() -> {
            lock.lock();
            try {
                // 进入 c1 条件的等待
                c1.await();
                System.out.println("t1, acquire lock...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                // 进入 c1 条件的等待
                c2.await();
                System.out.println("t2, acquire lock...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();

        new Thread(() -> {
            lock.lock();
            try {
                // 唤醒 c1 条件的线程
                c1.signal();
                // 唤醒 c2 条件的线程
                c2.signal();
                System.out.println("t3, acquire lock...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t3").start();
    }
}
