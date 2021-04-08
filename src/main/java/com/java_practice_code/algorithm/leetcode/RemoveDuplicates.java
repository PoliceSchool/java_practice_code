package com.java_practice_code.algorithm.leetcode;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.test1();
        removeDuplicates.test2();
        removeDuplicates.test3();
        removeDuplicates.test4();
        removeDuplicates.test5();
    }

    private void test1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums));
    }

    private void test2() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
    }

    private void test3() {
        int[] nums = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3};
        System.out.println(removeDuplicates(nums));
    }

    private void test4() {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(removeDuplicates(nums));
    }

    private void test5() {
        int[] nums = {1, 1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

    // 试下一次性循环到重复数字的最右端
//    public int removeDuplicates(int[] nums) {
//        int i = 0, j = nums.length - 1;
//        int count = 1;
//        for (i = 0; i < j; ) {
//            while (i + count < j && nums[i + count] == nums[i]) {
//                count++;
//                if (count > 2) {
//                    int tmp = nums[i + count - 1];
//                    nums[i + count - 1] = nums[j];
//                    nums[j] = tmp;
//                    j--;
//                }
//            }
//            if (count >= 2) {
//                i += 2;
//            } else {
//                i++;
//            }
//            count = 1;
//        }
//        Arrays.sort(nums, 0, j + 1);
//        return j + 1;
//    }


    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
