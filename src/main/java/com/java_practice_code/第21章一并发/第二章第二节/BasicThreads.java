package com.java_practice_code.第21章一并发.第二章第二节;


import com.java_practice_code.第21章一并发.第二章第一节.LiftOff;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/21.
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        // 由于新开了一个线程执行任务，所以t.start()方法立即返回，所以下面这条语句最先输出
        System.out.println("Waiting for LiftOff");
    }
}
