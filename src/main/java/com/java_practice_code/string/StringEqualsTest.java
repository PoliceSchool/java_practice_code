package com.java_practice_code.string;

public class StringEqualsTest {
    public static void main(String[] args) {
        String test = "test";
        String test1 = new String("test");
        System.out.println(test == test1);
        System.out.println(test.equals(test1));
        System.out.println(test.compareTo(test1));
    }
}
