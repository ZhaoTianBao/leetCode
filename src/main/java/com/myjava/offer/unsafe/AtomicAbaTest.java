package com.myjava.offer.unsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicAbaTest {
    public static AtomicInteger atomicInteger = new AtomicInteger(1);

    //解决aba 问题 工具类
    // AtomicStampedReference
    public static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1,1);

    public static void main(String[] args) throws InterruptedException {
        Thread main = new Thread(new Runnable() {
            @Override
            public void run() {

                int orign = atomicInteger.get();
                System.out.println(" thread: "+Thread.currentThread().getName()+" 修改前: "+orign);
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                int stamp = atomicStampedReference.getStamp();
                boolean isCASRef = atomicStampedReference.compareAndSet(orign,2,stamp,stamp+1);
                boolean isCAS = atomicInteger.compareAndSet(orign,2);
                if (isCAS){
                    System.out.println(" thread: "+Thread.currentThread().getName()+" cas success ");
                    System.out.println(" thread: "+Thread.currentThread().getName()+" 修改后: "+atomicInteger.get());
                }


            }
        });


        //干扰线程
        Thread other = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.incrementAndGet();
                System.out.println(" 干扰  thread:"+Thread.currentThread().getName()+" 修改前: "+atomicInteger.get());
                atomicInteger.decrementAndGet();
                System.out.println(" 干扰  thread:"+Thread.currentThread().getName()+" 修改前: "+atomicInteger.get());

            }
        });

        main.start();
        other.start();


    }
}
