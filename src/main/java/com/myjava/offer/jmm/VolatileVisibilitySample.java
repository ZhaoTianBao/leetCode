package com.myjava.offer.jmm;

public class VolatileVisibilitySample {

    private Boolean initFlag = false;

//    private volatile Boolean initFlag = false;

    public void refresh(){
        this.initFlag = true;
        System.out.println("线程 " +Thread.currentThread().getName()+ " 修改共享变量initFlag " );
    }

    public void load(){
        //本来一直阻塞
        //如果感知变量变化，结束循环向下走
        while (!initFlag){

        }
        System.out.println("线程 " +Thread.currentThread().getName()+ " 当前嗅探到initFlag的状态改变 " );
    }

    public static void main(String[] args) {
        VolatileVisibilitySample sample = new VolatileVisibilitySample();
        Thread a = new Thread(()->{
            sample.refresh();
        },"a");

        Thread b = new Thread(()->{
            sample.load();
        },"b");

        b.start();


        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        a.start();
    }

}
