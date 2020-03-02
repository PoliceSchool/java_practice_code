package com.java_practice_code.jvm;

import java.util.ArrayList;

public class HeapTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testAllocation3();
    }

    /**
     * 测试出现一次Minor GC
     * -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+UseSerialGC -verbose:gc -XX:+PrintGCDetails
     */
    private static void testAllocation1() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[2 * _1MB]; // 出现一次Minor GC
    }

    /**
     * 直接分配在老年代中
     * -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+UseSerialGC -verbose:gc -XX:+PrintGCDetails
     * -XX:PretenureSizeThreshold=3145728
     */
    private static void testAllocation2() {
        byte[] allocation1;
        allocation1 = new byte[4 * _1MB]; // 出现一次Minor GC
    }

    /**
     * 测试经历多少次GC进入老年代
     * -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+UseSerialGC -verbose:gc -XX:+PrintGCDetails -XX:MaxTenuringThreshold=1
     * -XX:+PrintTenuringDistribution
     */
    private static void testAllocation3() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[4 * _1MB];
        // 什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
