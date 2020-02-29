package com.java_practice_code.algorithm.niukewang;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 已通过牛客网测试
 */
public class Fibonacci {
    // 迭代实现
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

    // 递归实现
    public int fibonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return fibonacci2(n - 1) + fibonacci2(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("result: " + new Fibonacci().fibonacci(5));
    }
}
