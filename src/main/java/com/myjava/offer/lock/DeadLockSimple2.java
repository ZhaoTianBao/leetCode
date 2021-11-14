package com.myjava.offer.lock;

public class DeadLockSimple2 {

    private final static String resource_a = "a";

    private final static String resource_b = "b";

    public static void deadLock() {
        Thread t1 = new Thread(() -> {
            synchronized (resource_a) {

                System.out.println(Thread.currentThread() + " get resource a");
                try {
                    Thread.sleep(2000);
                    synchronized (resource_b) {
                        System.out.println(Thread.currentThread() + " get resource b");
                    }
                } catch (Exception e) {

                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource_b) {
                System.out.println(Thread.currentThread() + " get resource b");
                synchronized (resource_a) {
                    System.out.println(Thread.currentThread() + " get resource a");
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        deadLock();
    }
    //排查   jps   jstack 7880
}
