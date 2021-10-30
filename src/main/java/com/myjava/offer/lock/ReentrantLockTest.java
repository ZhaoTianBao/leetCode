package com.myjava.offer.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        System.out.println("准备开始");
        lock.lock();
        System.out.println("第一次加锁");
            lock.lock();
            System.out.println("第二次加锁");
            lock.unlock();
        lock.unlock();
        System.out.println("结束");
    }
}
