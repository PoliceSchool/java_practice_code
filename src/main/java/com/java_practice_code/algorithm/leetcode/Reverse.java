package com.java_practice_code.algorithm.leetcode;

public class Reverse {

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(123));
        System.out.println(new Reverse().reverse(-123));
        System.out.println(new Reverse().reverse(120));
        System.out.println(new Reverse().reverse(0));
        System.out.println(new Reverse().reverse(1534236469));
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result * 10 / 10 != result) {
                result = 0;
                break;
            }
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return result;
    }
}
