package com.java_practice_code.util.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/12/27.
 */
public class ListModifyTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
//        asyncTest(list);
//        forEachModify(list);
//        iteratorModify(list);
        test(list);
    }

    /**
     * 一个线程遍历list，另一个线程修改list，这样会报错
     */
    private static void asyncTest(List<String> list) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> forEach(list));
        Thread.sleep(4000);
        executor.execute(() -> modify(list));
    }

    private static void modify(List<String> list) {
        list.add("7");
    }

    private static void forEach(List<String> list) {
        try {
            for (String s : list) {
                Thread.sleep(1000);
                System.out.println(s);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * for循环里面一边修改一边遍历也会报错
     */
    private static void forEachModify(List<String> list) {
        for (String s : list) {
            if ("3".equals(s)) {
                list.add("7");
            }
            System.out.println(s);
        }
    }

    /**
     * for循环里面一边修改一边遍历也会报错
     */
    private static void iteratorModify(List<String> list) {
        Iterator<String> iterator = list.iterator();
        for (String s = iterator.next(); iterator.hasNext(); s = iterator.next()) {
            if ("3".equals(s)) {
//                iterator.
            }
            System.out.println(s);
        }
    }

    /**
     * 这样添加数据没问题
     */
    private static void test(List<String> list) {
        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }
    }
}
