package com.java_practice_code.algorithm.leetcode;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        Merge merge = new Merge();
        merge.test1();
    }

    private void test1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }
}
