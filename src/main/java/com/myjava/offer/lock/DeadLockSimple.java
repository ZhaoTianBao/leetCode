package com.myjava.offer.lock;

public class DeadLockSimple extends Thread{

    private String lockA;

    private String lockB;

    public DeadLockSimple(String name, String lockA, String lockB) {
        super(name);
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void run(){

//        synchronized (lockA){
//              sleep;
//            synchronized (lockB){
//
//            }
//        }

        //  synchronized ---> jvm 翻译成 monitor 监视锁
        synchronized (lockA){
            System.out.println(this.getName() + "hold:---->" + lockA);
            try {
                //sleep 每一次运行基本都可以保证死锁 1s
                Thread.sleep(1000L);
                synchronized (lockB){

                    System.out.println(this.getName() + "hold:---->" + lockB);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockSimple d1 = new DeadLockSimple("thread1", lockA, lockB);
        DeadLockSimple d2 = new DeadLockSimple("thread1", lockB, lockA);
        d1.start();
        d2.start();
        d1.join();
        d2.join();
    }

    //排查   jps   jstack 7880



}
