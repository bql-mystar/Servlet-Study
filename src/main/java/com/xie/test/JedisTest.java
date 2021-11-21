package com.xie.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {
    @Test
    public void test01(){
        // 1、获取链接
        Jedis jedis = new Jedis("120.25.220.19", 6379);
        // 2、操作
        jedis.set("username", "lisi");
        System.out.println(jedis.get("username"));
        // 3、关闭链接
        jedis.close();
    }

    @Test
    public void test02(){
        // 1、获取Jedis连接池对象
        JedisPool jedisPool = new JedisPool("120.25.220.19", 6379);
        // 2、获取链接
        Jedis jedis = jedisPool.getResource();
        // 3、使用
        String username = jedis.get("username");
        System.out.println(username);
        // 4、关闭 归还到连接池中
        jedis.close();

    }
}
