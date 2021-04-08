package com.java_practice_code.algorithm.leetcode;

public class FindMin {

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        findMin.test1();
        findMin.test2();
        findMin.test3();
    }

    public void test1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));
    }

    public void test2() {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }

    public void test3() {
        int[] nums = {11, 13, 15, 17};
        System.out.println(findMin(nums));
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length;
        int min = nums[0];
        while (l < r) {
            int left = nums[l];
            int right = nums[r - 1];
            int mid = nums[l + (r - l) / 2];
            if (mid < left && mid < right) {
                l++;
                r--;
                continue;
            }
            if (left <= right) {
                return left;
            }
            l = l + (r - l) / 2;
        }
        return min;
    }
}
