package com.myjava.offer;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RedisCluserTest {

    /**
     * 访问 redis cluser 集群
     * @param args
     */

    public static void main(String[] args) throws IOException {
        Set<HostAndPort> jedisCluserNode = new HashSet<HostAndPort>();
        jedisCluserNode.add(new HostAndPort("192.168.0.60",8001));
        jedisCluserNode.add(new HostAndPort("192.168.0.60",8002));
        jedisCluserNode.add(new HostAndPort("192.168.0.60",8003));
        jedisCluserNode.add(new HostAndPort("192.168.0.60",8004));
        jedisCluserNode.add(new HostAndPort("192.168.0.60",8005));
        jedisCluserNode.add(new HostAndPort("192.168.0.60",8006));
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(10);
        config.setTestOnBorrow(true);
        JedisCluster jedisCluster = new JedisCluster(jedisCluserNode, 6000, 10, config);
        System.out.println(jedisCluster.set("name", "zhuge"));
        System.out.println(jedisCluster.set("age", "18"));
        System.out.println(jedisCluster.get("name"));
        System.out.println(jedisCluster.get("age"));
        jedisCluster.close();

    }
}
