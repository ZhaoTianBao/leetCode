package com.myjava.offer.unsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest2 {
    public static AtomicInteger atomicInteger = new AtomicInteger(1);



    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(11);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    atomicInteger.incrementAndGet();
                }
            }).start();
        }
        //没跑完 等跑完 写法没成
        countDownLatch.await();
        System.out.println(atomicInteger.get());
    }
}
