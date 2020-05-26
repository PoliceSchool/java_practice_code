package com.java_practice_code.algorithm.leetcode;

import java.util.Arrays;

// https://leetcode-cn.com/problems/check-if-n-and-its-double-exist/submissions/
public class CheckIfExist {
    private static boolean checkIfExist(int[] arr) {
        final int max = 1001;
        int[] positiveFlags = new int[max];
        int[] negativeFlags = new int[max];
        Arrays.fill(positiveFlags, Integer.MAX_VALUE);
        Arrays.fill(negativeFlags, Integer.MIN_VALUE);
        for (int i : arr) {
            if (i == 0 && positiveFlags[i] == 0) {
                return true;
            }
            if (i >= 0) {
                positiveFlags[i] = i;
            } else {
                negativeFlags[-1 * i] = i;
            }
        }
        for (int i = 1; i <= 500; i++) {
            if (positiveFlags[i] * 2 == positiveFlags[2 * i]) {
                return true;
            }
            if (negativeFlags[i] * 2 == negativeFlags[2 * i]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[] arr = {10, 2, 5, 3};
//        int[] arr = {7, 1, 14, 11};
//        int[] arr = {3, 1, 7, 11};
        int[] arr = {-2, 0, 10, -19, 4, 6, -8};
//        int[] arr = {0, 0};
        System.out.println(checkIfExist(arr));
    }
}
