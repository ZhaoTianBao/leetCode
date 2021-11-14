package com.myjava.offer.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ASingletonTest {

     int num = 0;

     //原子类优化,
    AtomicInteger atomicInteger = new AtomicInteger();

    //cas版本号
    AtomicStampedReference atomicStampedReference = new AtomicStampedReference(0,0);

    public long getNum(){
        return num;
    }

    //相似的
    public long getNum2(){
        return atomicInteger.get();
    }

    public synchronized void increase(){
        num++;
    }

    public void increase2(){
        atomicInteger.incrementAndGet();
        //未加synchronize
        atomicInteger.set(1);

        while (true){
            //CAS原理
            int oldValue = atomicInteger.get();
            int newValue = oldValue + 1;
            if (atomicInteger.compareAndSet(oldValue, newValue)){
                break;
            }
        }

    }


    /**
     * static synchronized  静态方法锁对象
     *
     * public void synchronized 锁调用方法的对象 = synchronized(this)
     */








}
