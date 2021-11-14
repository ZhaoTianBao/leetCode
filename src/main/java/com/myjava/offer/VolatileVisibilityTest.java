package com.myjava.offer;

import com.myjava.utils.TreeUtil;

public class VolatileVisibilityTest {
    /**
     *
     * java 线程 每个工作内存中 会copy 一份 主内存中的变量
     *
     */
    private static volatile   boolean initFlag = false;
    //private static  boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("---------->A waiting data---");
                while (!initFlag){

                }
                //结束循环后会执行
                System.out.println("---------->A success");
            }
        }).start();


        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                change();
            }
        }).start();

    }


    public static void change(){
        
        System.out.println("--->prepare data start");
        initFlag = true;
        System.out.println("--->prepare data start");
    }

}
