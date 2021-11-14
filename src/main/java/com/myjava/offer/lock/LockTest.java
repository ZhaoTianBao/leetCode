package com.myjava.offer.lock;

public class LockTest {

    public static void main(String[] args) throws InterruptedException {
        ASingletonTest a = new ASingletonTest();
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10000000; i++) {
                a.increase();
            }
        });
        t1.start();

        for (int i = 0; i < 10000000; i++) {
            a.increase();
        }
        t1.join();
        long end = System.currentTimeMillis();
        System.out.println(String.format("%s ms", end - start));
        System.out.println(a.getNum());


    }
}
