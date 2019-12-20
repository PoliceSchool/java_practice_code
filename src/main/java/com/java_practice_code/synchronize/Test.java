package com.java_practice_code.synchronize;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description: 测试多线程访问某个实例中的两个同步方法
 * 测试结果证明：
 * 多线程环境下，即使一个实例中有多个同步方法，
 * 只要有一个同步方法（假设为A方法）被某个线程占用，那么A方法以及其他同步方法都会被锁住，
 * 其他线程不管是访问A方法还是其他同步方法都要等当前占用方法的线程释放锁。
 *
 * 究其原因是：所有的synchronized方法使用的都是实例锁，只要这些synchronized方法都属于同一个实例，
 * 那么这些synchronized方法所使用的锁都是同一个；所以只要其中一个synchronized方法被锁住，其他同个实例下的synchronized方法也会被锁住
 * date: Created in 2019/12/20.
 *
 * @author lujingxiao
 */
public class Test {
    public static void main(String[] args) throws Exception {
        int loop = 5000;
        OneInstanceOwnMoreSyncMethod test1 = new OneInstanceOwnMoreSyncMethod();
        ExecutorService executor = Executors.newScheduledThreadPool(20);
        for (int index = 0; index < 1000; index++) {
            CountDownLatch latch = new CountDownLatch(loop * 2);
            for (int i = 0; i < loop; i++) {
                executor.execute(() -> test1.print1(latch));
                executor.execute(() -> test1.print2(latch));
            }
            latch.await();
            if (loop * 2 != test1.getCount()) {
                throw new Exception("错了");
            }
            System.out.println("the result: " + test1.getCount());
            test1.setCountToZero();
        }
        executor.shutdown();
    }
}
