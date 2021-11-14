package com.myjava.offer.lock;

import org.openjdk.jol.info.ClassLayout;

public class LockUpgrade {


    public static void main(String[] args) throws InterruptedException {
        User userTemp = new User();
        System.out.println(" 无状态(001): " + ClassLayout.parseInstance(userTemp).toPrintable());

        //  jvm 默认延迟4s开启 偏向锁
        // -XX:BiasedLockingStartupDelay=0 取消延时
        // 取消偏向锁 -XX:-UseBiasedLocking = false
        // 关键代码
        //只要超过4s，就升级启动偏向锁
        Thread.sleep(5000);
        User user2 = new User();
        System.out.println(" 启动偏向锁(001): " + ClassLayout.parseInstance(user2).toPrintable());


        for (int i = 0; i < 2; i++) {
            synchronized (user2){
                System.out.println(" 偏向锁(001)(带线程id): " + ClassLayout.parseInstance(user2).toPrintable());
            }
            System.out.println(" 偏向释放锁(001)(带线程id): " + ClassLayout.parseInstance(user2).toPrintable());
        }

        //只要有其他线程争抢，就升级轻量级锁
        new Thread(()->{
            synchronized (user2){
                System.out.println(" 轻量级锁(00): " + ClassLayout.parseInstance(user2).toPrintable());
                try {
                    System.out.println("====睡眠3秒钟====");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" 轻量->重量(10): " + ClassLayout.parseInstance(user2).toPrintable());
            }
        }).start();


        Thread.sleep(1000);
        //上边线程在休眠，又有新的线程争抢了，锁升级为重量级
        //2个线程，就升级重量级锁，有点草率了
        new Thread(()->{
            synchronized (user2){
                System.out.println(" 重量级锁(10): " + ClassLayout.parseInstance(user2).toPrintable());

            }
        }).start();



    }
}
