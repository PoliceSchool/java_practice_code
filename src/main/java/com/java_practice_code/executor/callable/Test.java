package com.java_practice_code.executor.callable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/10.
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> result = new ArrayList<>(20);
        for (int i = 0; i < 10; i++) {
            result.add(executorService.submit(new Sum(BigDecimal.valueOf(i), BigDecimal.valueOf(i + 1))));
            result.add(executorService.submit(new Duction(BigDecimal.valueOf(i), BigDecimal.valueOf(i + 1))));
        }
        for (Future<String> future : result) {
            System.out.println(future.get());
        }
    }
}
