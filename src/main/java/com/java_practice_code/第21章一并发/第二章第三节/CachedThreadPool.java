package com.java_practice_code.第21章一并发.第二章第三节;


import com.java_practice_code.第21章一并发.第二章第一节.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/21.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        // CachedThreadPool将为每个任务创建一个线程；另外，在任何线程池中，线程在可能的情况下都会被复用
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        // 调用shutdown方法之后新的任务将不能被提交到exec，而在调用shutdown方法之前的任务将会继续运行直到完成
        exec.shutdown();
        // 在调用完shutdown方法之后再次执行execute方法将会报错
        exec.execute(new LiftOff());
    }
}
