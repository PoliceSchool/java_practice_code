package com.java_practice_code.interview.practice.singleton.singletonenum;


public class SingletonEnumTest {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
