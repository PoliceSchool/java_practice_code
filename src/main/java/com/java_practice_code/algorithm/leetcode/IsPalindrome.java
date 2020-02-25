package com.java_practice_code.algorithm.leetcode;

/**
 * https://leetcode-cn.com/problems/palindrome-number/submissions/
 * 已通过leetcode测试
 * 回文数
 */
public class IsPalindrome {
    private static boolean isPalindromeOne(int x) {
        if (x < 0) {
            return false;
        }
        int index = 0;
        int[] flag = new int[11];
        while (x != 0) {
            flag[index++] = x % 10;
            x /= 10;
        }
        for (int i = 0; i < index / 2; i++) {
            if (flag[i] != flag[index - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeTwo(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x;
        int result = (x % 10);
        x /= 10;
        while (x != 0) {
            result *= 10;
            result += (x % 10);
            x /= 10;
        }
        return tmp == result;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeTwo(10));
    }
}
