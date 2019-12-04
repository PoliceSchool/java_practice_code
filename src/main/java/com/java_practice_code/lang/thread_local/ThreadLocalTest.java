package com.java_practice_code.lang.thread_local;

public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        testWithThreadLocal();
//        testWithoutThreadLocal();
    }

    private static void testWithThreadLocal() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 : " + Node.integer.get());
            Node.integer.set(1);
            System.out.println("thread1 : " + Node.integer.get());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 : " + Node.integer.get());
            Node.integer.set(2);
            System.out.println("thread2 : " + Node.integer.get());
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("thread3 : " + Node.integer.get());
            Node.integer.set(3);
            System.out.println("thread3 : " + Node.integer.get());
        });
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        Thread.sleep(1000);
        thread3.start();
    }

    private static void testWithoutThreadLocal() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 : " + Node.integer2);
            Node.integer2 = 1;
            System.out.println("thread1 : " + Node.integer2);
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 : " + Node.integer2);
            Node.integer2 = 2;
            System.out.println("thread2 : " + Node.integer2);
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("thread3 : " + Node.integer2);
            Node.integer2 = 3;
            System.out.println("thread3 : " + Node.integer2);
        });
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        Thread.sleep(1000);
        thread3.start();
    }
}
