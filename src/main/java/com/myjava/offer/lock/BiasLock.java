package com.myjava.offer.lock;

import java.util.Vector;

public class BiasLock {


    /**
     * 默认开启偏向锁
     *
     * 
     * 开启偏向锁
     *
     *
     * 关闭偏向锁
     *
     *
     */
    public static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int count = 0;
        int num = 0;
        while (count < 10000000){
            vector.add(num);
            num = num + 5;
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);



    }
}
