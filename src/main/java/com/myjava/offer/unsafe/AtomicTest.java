package com.myjava.offer.unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static AtomicInteger atomicInteger = new AtomicInteger(1);


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    atomicInteger.incrementAndGet();
                }
            }).start();
        }
        //没跑完
        Thread.sleep(1000);
        System.out.println(atomicInteger.get());
    }
}
