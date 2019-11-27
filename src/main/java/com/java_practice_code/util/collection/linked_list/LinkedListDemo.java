package com.java_practice_code.util.collection.linked_list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/27.
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        List<String> list1 = new LinkedList<>();
        list1.add("Geeks");
        list1.add("for");
        list1.add("Geeks");
        list1.add("GFG");
        list1.add("GeeksforGeeks");

        List<String> list2 = new LinkedList<>();
        list2.add("Geeks");

        list1.removeAll(list2);

        for (String temp : list1) {
            System.out.printf(temp + " ");
        }

        System.out.println();
    }

    private static void test2() {
        List<String> list = new LinkedList<>();
        list.add("Geeks");
        list.add("for");
        list.add("Geeks");
        list.add("GeeksforGeeks");
        Iterator<String> iter = list.iterator();

        while (iter.hasNext()) {
            System.out.printf(iter.next() + " ");
        }

        System.out.println();
    }
}
