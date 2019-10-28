package com.java_practice_code.executor;

import java.util.concurrent.Callable;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/7.
 */
public class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程" + Thread.currentThread().getId() + "在计算");
        Thread.sleep(2000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
