package com.java_practice_code.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * description: 使用代码查看JVM内存使用情况：https://www.cnblogs.com/gaoBlog/p/10844119.html
 * date: Created in 2020/1/15.
 *
 * @author lujingxiao
 */
public class JvmTest {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        long max = run.maxMemory();
        long total = run.totalMemory();
        long free = run.freeMemory();
        long usable = max - total + free;
        System.out.println("最大内存 = " + max);
        System.out.println("已分配内存 = " + total);
        System.out.println("已分配内存中的剩余空间 = " + free);
        System.out.println("最大可用内存 = " + usable);

        // https://blog.csdn.net/weixin_34008805/article/details/86731084
        MemoryMXBean memoryMxBean = ManagementFactory.getMemoryMXBean();
        System.out.println(memoryMxBean.getHeapMemoryUsage());
        System.out.println(memoryMxBean.getNonHeapMemoryUsage());
    }
}
