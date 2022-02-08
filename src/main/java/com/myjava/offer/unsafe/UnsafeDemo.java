package com.myjava.offer.unsafe;

import sun.misc.Unsafe;

import java.util.concurrent.locks.LockSupport;

public class UnsafeDemo {


    public static void main(String[] args) {

        byte[] demo = new byte[6000*1024];



        //unsafe 3 种操作
        Unsafe unsafe = UnsafeInstance.getUnsafe();
        //锁
        unsafe.monitorEnter(1);
        //线程 先拿票据，后核销
        unsafe.park(true,1);
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        //读写屏障
        unsafe.storeFence();
        unsafe.loadFence();
    }
}
