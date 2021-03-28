package com.java_practice_code.algorithm.leetcode;


public class ReinitializePermutation {
    public static void main(String[] args) {
        new ReinitializePermutation().reinitializePermutation(6);
    }

    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        int[] arr = new int[n];
        int count = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            fill(perm, arr);
            count++;
            if (isSame(arr)) {
                break;
            }
        }
        return count;
    }

    private void fill(int[] perm, int[] arr) {
        for (int i = 0; i < perm.length; i++) {
            perm[i] = arr[i];
        }
    }

    private boolean isSame(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return false;
            }
        }
        return true;
    }
}
