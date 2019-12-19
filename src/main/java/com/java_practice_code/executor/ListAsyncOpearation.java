package com.java_practice_code.executor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: 测试串行往list里面添加数据与并行往线程安全的list里面添加数据的速度
 * date: Created in 2019/12/18.
 *
 * @author lujingxiao
 */
public class ListAsyncOpearation {
    private static int size = 1000;

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
//            test1(list, new ArrayList<>(size));
            test2(list, Collections.synchronizedList(new ArrayList<>(size)));
            test3(list);
            System.out.println();
        }
    }

    /**
     * 串行往list里面添加数据
     */
    private static void test1(List<Integer> list, List<Integer> list1) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            list.forEach(integer -> list1.add(getData(integer)));
            if (list1.size() != size) {
                throw new Exception("错了");
            }
            list1.clear();
        }
        System.out.println("串行往list里面添加数据消耗时间：" + (System.currentTimeMillis() - start));
    }

    /**
     * 并行往线程安全的list里面添加数据
     */
    private static void test2(List<Integer> list, List<Integer> list1) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            list.parallelStream().forEach(integer -> list1.add(getData(integer)));
            if (list1.size() != size) {
                throw new Exception("错了");
            }
            list1.clear();
        }
        System.out.println("并行往线程安全的list里面添加数据消耗时间：" + (System.currentTimeMillis() - start));
    }

    private static void test3(List<Integer> list) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            List<Integer> list1 = list.parallelStream().map(ListAsyncOpearation::getData).collect(Collectors.toList());
            if (list1.size() != size) {
                throw new Exception("错了");
            }
            list1.clear();
        }
        System.out.println("使用map并行往list里面添加数据消耗时间：" + (System.currentTimeMillis() - start));
    }


    private static int getData(int i) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }
}
