package com.java_practice_code.executor.tread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: lujingxiao
 * @description: 测试多线程安全问题
 * @since:
 * @version:
 * @date: Created in 2019/9/11.
 */
public class TreadPoolExecutorTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newScheduledThreadPool(50);
        Add a = new Add();
        for (int i = 0; i < 1000; i++) {
            executor.execute(() -> {
                try {
                    add(a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void add(Add a) throws Exception {
        int result = add(5);
        if (result != 15) {
            throw new Exception("error");
        }
        System.out.println("tid:" + Thread.currentThread().getId() + "  " + result);
    }

    public static int add(int a) {
        a += 2;
        a += 3;
        a += 5;
        return a;
    }

    static class Add {
        public int add(int a) {
            a += 2;
            a += 3;
            a += 5;
            return a;
        }
    }
}
