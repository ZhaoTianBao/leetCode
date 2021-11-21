package com.myjava.offer.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeInstance {

    private static int a,b;

    //private volatile static int x,y;
    private static int x,y;
    static Object  o = new Object();

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for ( ; ; ) {
            i++;
            a = 0;
            b = 0;
            x = 0;
            y = 0;

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    //等下t2线程，让其尽量一起执行
                    shortWait(1000);
                    a = 1;
                    //内存屏障，或者手动加内存屏障
                    //Unsafe类，越过虚拟机直接操作底层
                    getUnsafe().storeFence();
                    x = b;
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            String  res = "第 " + i + "次" + " ( " + x + " , " + y + " ） ";
            if (x == 0 && y == 0){
                System.out.println(res);
                break;
            }
            System.out.println(res);

        }

        /**
         * 正常出现结果
         * 1,1
         * 0,1
         * 1,0
         *
         *
         *
         * 出现指令重排，cpu或者jit对代码重排序，cpu感知不到指令重排序的影响
         * 0,0
         */




    }

    public static void shortWait(long time){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while (time + start >= end);
    }

    //unsafe安全级别非常高，只能反射用
    public static Unsafe getUnsafe()  {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        }catch (Exception e){

        }
        return null;


    }


}
