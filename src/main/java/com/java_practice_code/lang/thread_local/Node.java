package com.java_practice_code.lang.thread_local;

public class Node {
    public static ThreadLocal<Integer> integer = new ThreadLocal<>();
    public static Integer integer2 = null;

    public static ThreadLocal<Integer> getInteger() {
        return integer;
    }

    public static void setInteger(ThreadLocal<Integer> integer) {
        Node.integer = integer;
    }
}
