package com.myjava.offer.design;

//  高效单例写法1
//  懒汉式  +   Double Check  +   volatile
public final class Singleton {


    private static volatile Singleton instance = null;

    public Singleton() {
    }

    public static Singleton getInstance(){
        if (null == instance){

            synchronized (Singleton.class){
                if (null == instance){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
