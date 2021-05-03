package com.java_practice_code.algorithm.leetcode;

public class Test {

    public static void main(String[] args) {
//        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] arr = {1,1,2};
        new Test().removeDuplicates(arr);

    }

    public int removeDuplicates(int[] nums) {
        int left = 0, right = 1;
        int length = nums.length;
        while (left < length && right < length) {
            if (nums[left] == nums[right]) {
                right++;
                continue;
            }
            nums[++left] = nums[right++];
        }
        return left + 1;
    }
}
