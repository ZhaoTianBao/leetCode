package com.myjava.offer;

public class VolatileAtomicTest {

    public static volatile int num  = 10;
//    public static synchronized void increase(){
//        num++;
//    }



    //结果小于等于 10010
    public static  void increase(){
        num++;
    }


    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        //等上边线程执行完,合并回主线程
        for (Thread thread : threads) {
            thread.join();
        }
        //然后向下执行

        System.out.println(num);


    }

}
