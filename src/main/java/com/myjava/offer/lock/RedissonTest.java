package com.myjava.offer.lock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import redis.clients.jedis.Jedis;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RedissonTest {

    public static void main(String[] args) {
        //初始化 此为单机模式
        Config config = new Config();
        String path = "redis://localhost:6379";
        config.useSingleServer().setAddress(path).setDatabase(0);
        //分布式
        /*
        config.useClusterServers()
                .addNodeAddress("redis://192.168.0.1:6370")
                .addNodeAddress("redis://192.168.0.1:6371")
                .addNodeAddress("redis://192.168.0.1:6372")
                .addNodeAddress("redis://192.168.0.1:6373")
                .addNodeAddress("redis://192.168.0.1:6374")
                .addNodeAddress("redis://192.168.0.1:6376");

         */
        //redisson 客户端实例
        Redisson redisson = (Redisson) Redisson.create(config);

        //指定Redis服务Host和port
        Jedis jedis = new Jedis("localhost", 6379);
//        jedis.auth("xxxx"); //如果Redis服务连接需要密码，制定密码

        //jedis.close(); //使用完关闭连接

        String lockKey = "lockKey"; //访问Redis服务
        //加锁
        RLock redissonLock = redisson.getLock(lockKey);


        try{
            redissonLock.lock();
            //  相当于  jedis.setnx(lockKey,clientId,30,TimeUnit.SECONDS); clientId 自己客户端线程id

            //业务
            String stockStr = jedis.get("stock");
            int stock = Integer.valueOf(stockStr);
            if (stock > 0) {
                int realStock = stock - 1;
                jedis.set("stock",String.valueOf(realStock));
                System.out.println("扣减成功，剩余库存: "+ realStock) ;
            } else {
                System.out.println("扣减失败，库存不足");
            }
        }finally{
            //解锁
            redissonLock.unlock();

        }
    }
}
