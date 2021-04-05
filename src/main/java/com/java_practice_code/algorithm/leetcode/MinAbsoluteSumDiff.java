package com.java_practice_code.algorithm.leetcode;

import javax.validation.constraints.Min;
import java.util.LinkedList;
import java.util.Queue;

public class MinAbsoluteSumDiff {

    public static void main(String[] args) {
        new MinAbsoluteSumDiff().test1();
        new MinAbsoluteSumDiff().test2();
        new MinAbsoluteSumDiff().test3();
        new MinAbsoluteSumDiff().test4();
        new MinAbsoluteSumDiff().test5();
    }

    private void test1() {
        int[] nums1 = {1, 7, 5}, nums2 = {2, 3, 5};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }

    private void test2() {
        int[] nums1 = {2, 4, 6, 8, 10}, nums2 = {2, 4, 6, 8, 10};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }

    private void test3() {
        int[] nums1 = {1, 10, 4, 4, 2, 7}, nums2 = {9, 3, 5, 1, 7, 4};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }

    private void test4() {
        int[] nums1 = {9, 10, 1};
        int[] nums2 = {1, 2, 1};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }

    private void test5() {
        int[] nums1 = {10, 9, 1};
        int[] nums2 = {2, 1, 1};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }

    // 第 235 场周赛 第三道题，前面42个用例都通过了，最后一个用例超时
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int max = 0, length = nums1.length;
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int abs = Math.abs(nums1[i] - nums2[i]);
            sum += abs;
            if (abs > max) {
                max = abs;
                queue = new LinkedList<>();
                queue.add(i);
            } else if (abs == max) {
                queue.add(i);
            }
        }
        if (sum == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int replaceIndex = -1;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int a = nums2[poll];
            for (int i = 0; i < length; i++) {
                int abs = Math.abs(nums1[i] - a);
                if (abs < min) {
                    min = abs;
                    minIndex = i;
                    replaceIndex = poll;
                }
            }
        }
        int a = Math.abs(Math.abs(nums1[minIndex] - nums2[replaceIndex]) - Math.abs(nums1[replaceIndex] - nums2[replaceIndex]));
        return (sum - a) % 1000000007;
    }
}
