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
public class SingleThreadExecutor {
    public static void main(String[] args) {
        // SingleThreadExecutor是数量为1的FixedThreadPool
        // 如果向SingleThreadExecutor提交了多个任务，这些任务将会被排队
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        // 调用shutdown方法之后新的任务将不能被提交到exec，而在调用shutdown方法之前的任务将会继续运行直到完成
        exec.shutdown();
        // 在调用完shutdown方法之后再次执行execute方法将会报错
//        exec.execute(new LiftOff());
    }
}
