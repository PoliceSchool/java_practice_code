package com.java_practice_code.algorithm.leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class IntegerReverse {

    // 参考别人代码，自己解决不了溢出
    private static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("the result is : " + reverse(1534236469));
    }
}
