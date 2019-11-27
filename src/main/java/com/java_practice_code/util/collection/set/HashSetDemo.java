package com.java_practice_code.util.collection.set;

import java.util.HashSet;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/27.
 */
public class HashSetDemo {
    public static void main(String[] args)
    {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Geeks");
        hashSet.add("for");
        hashSet.add("Geeks");
        hashSet.add("GeeksforGeeks");

        System.out.println(hashSet);

    }
}
