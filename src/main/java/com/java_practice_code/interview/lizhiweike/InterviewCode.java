package com.java_practice_code.interview.lizhiweike;

import java.util.BitSet;

public class InterviewCode {
    // 斐波那契数列
    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = a + b;
        while (n-- > 2) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    // 利用java的BitSet数据结构,将每个数字对应位置的比特位置为1,最后再翻转一下
    // 这样比特位置为1的变为0,比特位置为0的变为1;这样就能筛选出唯一一个没有的数字
    // 比如数组{3, 0, 1}对应的比特位是 1101, 翻转之后变为 0010, 这样就能得到第几个比特位缺少了
    private static int missingNumber2(int[] nums) {
        int length = nums.length;
        BitSet bitSet = new BitSet(length);
        for (int num : nums) {
            bitSet.set(num);
        }
        bitSet.flip(0, length + 1);
        return Integer.parseInt(String.valueOf(bitSet.toString().subSequence(1, 2)));
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));

//        Q2 Missing Number
//        Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//        Example 1:
//        Input: [3,0,1]
//        Output: 2
//        Example 2:
//        Input: [9,6,4,2,3,5,7,0,1]
//        Output: 8
//        Note:
//
//        Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
        int[] arr1 = {3, 2, 1};
        int[] arr2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber2(arr1));
        System.out.println(missingNumber2(arr2));
    }
}
