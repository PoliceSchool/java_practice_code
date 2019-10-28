package com.java_practice_code.第21章一并发.第二章第一节;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/21.
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        // 通过run方法执行不会产生新的线程，要通过Thread类才能产生新的线程
        launch.run();
    }
}
