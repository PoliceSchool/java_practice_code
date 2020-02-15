package com.java_practice_code.algorithm.niukewang;

import org.bouncycastle.asn1.x509.UserNotice;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 已通过测试
 */
public class Fibonacci {
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int first = 1;
        int second = 1;
        while (n-- > 2) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println("result: " + new Fibonacci().fibonacci(5));
    }
}
