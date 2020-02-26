package com.redis.practice;

import redis.clients.jedis.Jedis;

public class TestApi {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6381);
        jedis.set("a", "a");
        jedis.set("b", "b");
        jedis.set("c", "c");
        System.out.println(jedis.get("a"));
        System.out.println(jedis.keys("*"));
    }
}
