package com.java_practice_code.algorithm.leetcode;

public class ArrangeCoins {
    // 自己写的，已通过leetcode测试，不过效果很差
    public int arrangeCoins1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += i;
            if (n - count < i + 1) {
                return i;
            }
        }
        return 0;
    }

    // 参考leetcode代码题解
    public int arrangeCoins2(int n) {
        return (int) (Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }
}
