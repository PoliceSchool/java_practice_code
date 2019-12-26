package com.java_practice_code.leetcode;

/**
 * description: leetcode算法题，两数之和，https://leetcode-cn.com/problems/two-sum/
 * date: Created in 2019/12/26.
 *
 * @author lujingxiao
 */
class TwoSum {
    private int[] solutionOne(int[] nums, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[i] + nums[j] == target) && i != j) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
            if (result[0] != -1) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {3, 2, 4};
        twoSum.solutionOne(nums, 6);
    }
}
