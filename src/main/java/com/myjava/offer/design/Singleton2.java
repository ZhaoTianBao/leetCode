package com.myjava.offer.design;

//  高效单例写法2
//  内部类     +   懒汉式
public final class Singleton2 {

    private static class Holder{
        private static Singleton2 instance = new Singleton2();
    }

    public Singleton2() {
    }

    public static Singleton2 getInstance(){
        return Holder.instance;
    }


}


