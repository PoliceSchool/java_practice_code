package com.redis.practice;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTx {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6381);
        Transaction transaction = jedis.multi();
        transaction.set("d", "dd");
        transaction.set("e", "ee");
//        transaction.exec();
        transaction.discard();
    }
}
