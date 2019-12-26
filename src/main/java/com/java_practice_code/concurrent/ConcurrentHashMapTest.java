package com.java_practice_code.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description: 用来记录ConcurrentHashMap的使用场景
 * date: Created in 2019/12/21.
 *
 * @author lujingxiao
 */
public class ConcurrentHashMapTest {
    private final Map<String, Long> urlCounter = new ConcurrentHashMap<>();
    private final Map<String, String> threadNameMap = new HashMap<>();
    private final Map<String, String> threadNameConcurrentHashMap = new ConcurrentHashMap<>();

    /************************用来统计某个东西的访问次数*********************************/
    /**
     * 接口调用次数 +1
     */
    private long increase(String url) {
        Long oldValue = urlCounter.get(url);
        Long newValue = (oldValue == null) ? 1L : oldValue + 1;
        urlCounter.put(url, newValue);
        return newValue;
    }

    /**
     * 获取调用次数
     */
    private Long getCount(String url) {
        return urlCounter.get(url);
    }

    /**
     * 用来统计某个东西的访问次数
     * 参考：https://www.cnkirito.moe/java-ConcurrentHashMap-CAS/
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        final ConcurrentHashMapTest counterDemo = new ConcurrentHashMapTest();
        int callTime = 100000;
        final String url = "http://localhost:8080/hello";
        CountDownLatch countDownLatch = new CountDownLatch(callTime);
        // 模拟并发情况下的接口调用统计
        for (int i = 0; i < callTime; i++) {
            executor.execute(() -> {
                counterDemo.increase(url);
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        // 等待所有线程统计完成后输出调用次数
        System.out.println("调用次数：" + counterDemo.getCount(url));
    }
    /************************用来统计某个东西的访问次数*********************************/

    /******************使用ConcurrentHashMap代替单例模式***************************/
    /**
     * 参考：https://blog.csdn.net/a_fengzi_code_110/article/details/61191591
     */
    public String getThreadPool(String type) {
        String value = threadNameMap.get(type);
        if (value == null) {
            synchronized (this) {
                value = threadNameMap.get(type);
                if (value == null) {
                    threadNameMap.put(type, Thread.currentThread().getName());
                }
            }
        }
        return threadNameMap.get(type);
    }
    public String getThreadNameInConccu(String type) {
        String value = threadNameConcurrentHashMap.get(type);
        if (value == null) {
            threadNameConcurrentHashMap.putIfAbsent(type, Thread.currentThread().getName());
        }
        return threadNameConcurrentHashMap.get(type);
    }
    /******************使用ConcurrentHashMap代替单例模式***************************/
}

