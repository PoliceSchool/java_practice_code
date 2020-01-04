package com.java_practice_code.leetcode;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2020/1/4.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(123));
    }

    private int reverse(int x) {
        boolean flag = false, isFirst = true;
        int count = 0, result = 0;
        int[] arr = new int[12];
        if (x < 0) {
            flag = true;
        }
        x = Math.abs(x);
        while (x > 0) {
            int temp = x % 10;
            if (temp != 0 && isFirst) {
                isFirst = false;
                arr[count] = temp;
                count++;
            }
            x /= 10;
        }
        count--;
        for (int i : arr) {
            int temp = result;
            result += (i * Math.pow(10, count--));
            if (result < temp) {
                return 0;
            }
        }
        if (flag) {
            result *= -1;
        }
        return result;
    }
}
