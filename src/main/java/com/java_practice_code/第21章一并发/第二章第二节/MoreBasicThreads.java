package com.java_practice_code.第21章一并发.第二章第二节;


import com.java_practice_code.第21章一并发.第二章第一节.LiftOff;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/21.
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        // 这里可以看到main线程没有引用new出来的任何一个线程；
        // 这里就引出一个问题：一般来说jvm会对清除没有被引用的对象，那么这些被new出来的Thread会被jvm清除掉吗？
        // 答案是在Thread的任务的run方法退出之前是不会被jvm清除的，因为每个Thread类都"注册"了它自己；
        // 因此，只有在Thread的任务的run方法退出之后才会被jvm清除；所以调用完Thread的start方法后，Thread还是会继续存在直到run方法退出
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
