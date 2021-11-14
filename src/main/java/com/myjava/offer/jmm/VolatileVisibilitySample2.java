package com.myjava.offer.jmm;

public class VolatileVisibilitySample2 {

    private Boolean initFlag = false;
    static Object object = new Object();

    public void refresh(){
        this.initFlag = true;
        System.out.println("线程 " +Thread.currentThread().getName()+ " 修改共享变量initFlag " );
    }

    public void load(){
        //本来一直阻塞
        //如果感知变量变化，结束循环向下走
        // while 空跑优先级高
        // 锁  阻塞 上下文切换    重新读主内存
        int i = 0;
        while (!initFlag){
            synchronized (object){
                i++;
            }
        }
        System.out.println("线程 " +Thread.currentThread().getName()+ " 当前嗅探到initFlag的状态改变 " );
    }

    public static void main(String[] args) {
        VolatileVisibilitySample2 sample = new VolatileVisibilitySample2();
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
