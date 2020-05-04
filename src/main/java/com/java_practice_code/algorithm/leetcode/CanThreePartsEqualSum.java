package com.java_practice_code.algorithm.leetcode;

public class CanThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        int singleSum = sum / 3;
        int tempSum = 0;
        int[] indexs = {0, -1, -1, -1, -1, -1};
        for (int i = 0; i < A.length; i++) {
            tempSum += A[i];
            if (tempSum == singleSum) {

            }
        }
        return false;
    }
}
