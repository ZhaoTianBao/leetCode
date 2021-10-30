package com.myjava.offer.singleton;



public class InstThread implements Runnable {
    @Override
    public void run() {
        BeautyTech beautyTech = new BeautyTech();
        System.out.println(" 当前线程 " + Thread.currentThread().getName() + " 当前类hashCode " + beautyTech.hashCode());
    }
}
