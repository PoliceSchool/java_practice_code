package com.java_practice_code.第21章一并发.第二章第一节;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/21.
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    // 用于区分多个任务实例
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "thread id" + Thread.currentThread().getId() + ", #" + id + "(" + (countDown > 0 ? countDown : "Listoff!") + "), ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            // 当前线程声明让出cpu（从运行态转变为就绪态），之后cpu会随机选择一个线程执行，当前线程也可能会被再次选中
            // 值得注意的是，调用yield方法只能让相同优先级的其他线程运行
            Thread.yield();
        }
    }
}
