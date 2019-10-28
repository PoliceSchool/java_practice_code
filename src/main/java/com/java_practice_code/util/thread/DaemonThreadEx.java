package com.java_practice_code.util.thread;

import java.util.stream.IntStream;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/10/25.
 */
public class DaemonThreadEx extends Thread {
    @Override
    public void run() {
        System.out.println("Is started thread daemon? " + this.isDaemon());
        System.out.println("Thread execution starts " + this.getPriority());
        IntStream.iterate(0, i -> i + 1).limit(10).forEach(i -> System.out.printf("%d ", i));
        System.out.println("Thread execution complete");
    }

    public static void main(String[] args) {
        DaemonThreadEx example = new DaemonThreadEx();
        System.out.println("Is Main thread daemon ? " + Thread.currentThread().isDaemon());
        example.setDaemon(true);
        example.start();
        IntStream.iterate(0, i -> i + 1).limit(3).forEach(i -> System.out.printf("%d@main ", i));
    }
}
