package com.myjava.offer.singleton;

public class DebugThread {
    /**
     * 人为控制调试多线程
     *
     */

    public static void main(String[] args) {

        InstThread instThread = new InstThread();
        Thread thread1 = new Thread(instThread);
        Thread thread2 = new Thread(instThread);

        thread1.start();
        thread2.start();

        System.out.println("主线程 main " + Thread.currentThread().getName());


    }
}
