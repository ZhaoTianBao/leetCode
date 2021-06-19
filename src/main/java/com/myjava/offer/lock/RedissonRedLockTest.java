package com.myjava.offer.lock;

import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.config.Config;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class RedissonRedLockTest {


    /**
     * redis 主从集群 红锁
     * @param args
     */
    public static void main(String[] args) {
        //初始化 此为单机模式
        Config config = new Config();
        String path = "redis://localhost:6379";
        config.useSingleServer().setAddress(path).setDatabase(0);


        //redisson 客户端实例
        // 这里需要自已实例化不网redis实例的redisson客户端连接，
        //这里只是伪代码用一个redison客 户端简化了
        Redisson redisson1 = (Redisson) Redisson.create(config);
        Redisson redisson2 = (Redisson) Redisson.create(config);
        Redisson redisson3 = (Redisson) Redisson.create(config);

        String lockKey ="product_ 001";

        //加锁
        RLock lock1 = redisson1.getLock(lockKey);
        RLock lock2 = redisson2.getLock(lockKey);
        RLock lock3 = redisson3.getLock(lockKey);

        //  根据多个RLock 对象构建RedissonRedLock (最核心的差别就在这重)
        RedissonRedLock redissonRedLock = new RedissonRedLock(lock1, lock2, lock3);

        try{

            /**
             *   waitTime
             *   尝试获取锁的最大等待时间了超过这个值，则认为获取锁失败
             *   leaseTime
             *   锁的持有时间，超过这个时间锁会自动失效(值应设置为大于业务处理的时间，确保在锁有效期内业务能处理完)
             */
            boolean b = redissonRedLock.tryLock(10, 30, TimeUnit.SECONDS);
            if (b){
                //获得锁成功处理业务
                //业务
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            //解锁
            redissonRedLock.unlock();
        }
        System.out.println("10s 后 结束");

    }
}
