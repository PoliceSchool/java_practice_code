package com.java_practice_code.algorithm.lru;


public class LRUTest {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.set(1, 1);
        cache.set(2, 2);
        cache.get(1);
        cache.set(3, 3);
        cache.set(4, 4);
        cache.get(2);
        cache.set(5, 5);
        cache.set(6, 6);
        cache.get(3);
        cache.set(7, 7);
        cache.set(8, 8);
        cache.get(4);
    }
}
