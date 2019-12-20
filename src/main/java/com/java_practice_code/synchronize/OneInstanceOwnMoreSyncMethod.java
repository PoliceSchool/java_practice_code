package com.java_practice_code.synchronize;

import java.util.concurrent.CountDownLatch;

/**
 * description: 测试多线程访问某个实例中的两个同步方法
 * date: Created in 2019/12/20.
 *
 * @author lujingxiao
 */
class OneInstanceOwnMoreSyncMethod {
    private int count = 0;

    synchronized void print1(CountDownLatch latch) {
        count++;
        latch.countDown();
    }

    synchronized void print2(CountDownLatch latch) {
        count++;
        latch.countDown();
    }

    void setCountToZero() {
        this.count = 0;
    }

    int getCount() {
        return count;
    }
}
