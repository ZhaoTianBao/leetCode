package com.myjava.offer.singleton;

public class Singleton {
    //高并发下单例模式
    private static volatile Singleton myInstance;

    public static Singleton getInstance(){
        if (null == myInstance){
            synchronized (Singleton.class){
                if(null == myInstance){
                    return new Singleton();
                    // 1 申请内存address 2 instance Object 实例化对象 3 Object = address 对象分配内存
                }
            }
        }
        return myInstance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
