package com.java_practice_code.algorithm.leetcode;

/**
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 */
public class SumNums {
    public static void main(String[] args) {
        System.out.println(sumNums(9));
    }

    private static int sumNums(int n) {
        int sum = n;
        boolean flag = (n > 0) && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}
