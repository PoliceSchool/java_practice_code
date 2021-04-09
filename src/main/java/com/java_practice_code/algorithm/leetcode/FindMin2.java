package com.java_practice_code.algorithm.leetcode;

public class FindMin2 {

    public static void main(String[] args) {
        FindMin2 findMin2 = new FindMin2();
        findMin2.test1();
        findMin2.test2();
        findMin2.test3();
        findMin2.test4();
        findMin2.test5();
        findMin2.test6();
        findMin2.test7();
        findMin2.test8();
    }

    private void test1() {
        int[] nums = {1, 3, 5};
        System.out.println(findMin(nums));
    }

    private void test2() {
        int[] nums = {2, 2, 2, 0, 1};
        System.out.println(findMin(nums));
    }

    private void test3() {
        int[] nums = {4, 5, 6, 7, 0, 1, 4};
        System.out.println(findMin(nums));
    }

    private void test4() {
        int[] nums = {0, 1, 4, 4, 5, 6, 7};
        System.out.println(findMin(nums));
    }

    private void test5() {
        int[] nums = {1, 1};
        System.out.println(findMin(nums));
    }

    private void test6() {
        int[] nums = {3, 1, 3, 3};
        System.out.println(findMin(nums));
    }

    private void test7() {
        int[] nums = {1, 3, 3};
        System.out.println(findMin(nums));
    }

    private void test8() {
        int[] nums = {3, 3, 1, 3};
        System.out.println(findMin(nums));
    }


    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int midIndex;
        while (l < r) {
            midIndex = l + (r - l) / 2;
            if (nums[midIndex] < nums[r]) {
                r = midIndex;
            } else if (nums[midIndex] == nums[r]) {
                r--;
            } else {
                l = midIndex + 1;
            }
        }
        return nums[l];
    }
}
