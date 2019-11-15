package com.java_practice_code.seckill;


import redis.clients.jedis.Jedis;

public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        String value = jedis.get("a");
        System.out.println(value);
    }
}
