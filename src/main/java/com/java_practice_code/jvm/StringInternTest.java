package com.java_practice_code.jvm;

import java.util.Random;

public class StringInternTest {
    static final int MAX = 1000 * 10000;
    static final String[] arr = new String[MAX];

    public static void main(String[] args) {
//        Integer[] DA_DATA = new Integer[10];
//        Random random = new Random(10 * 10000);
//        for (int i = 0; i < DA_DATA.length; i++) {
//            DA_DATA[i] = random.nextInt();
//        }
//        long t = System.currentTimeMillis();
//        for (int i = 0; i < MAX; i++) {
//            arr[i] = new String(String.valueOf(DA_DATA[i % DA_DATA.length])).intern();
//        }
//
//        System.out.println((System.currentTimeMillis() - t) + "ms");
//        System.gc();

        String a = new String("11");
        String b = "11";
        System.out.println(a == b);
    }
}
