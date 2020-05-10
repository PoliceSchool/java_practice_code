package com.java_practice_code.JVM并发编程;

/**
 * 参考：https://www.bilibili.com/video/BV1eJ411M7aN?p=2
 */
public class P2_JMM {
    private static boolean initFlag = false;
//    private static volatile boolean initFlag = false;


    public static void refresh() {
        System.out.println("refresh data ....");
        initFlag = true;
        System.out.println("refresh data success ....");
    }

    public static void loadData() {
        while (!initFlag) {

        }
        String name = Thread.currentThread().getName();
        System.out.println("线程:" + name + "当期线程嗅探到initFlag的状态的改变");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(P2_JMM::loadData, "ThreadA");
        Thread threadB = new Thread(P2_JMM::refresh, "ThreadA");

        threadA.start();
        Thread.sleep(1000);
        threadB.start();
    }
}
