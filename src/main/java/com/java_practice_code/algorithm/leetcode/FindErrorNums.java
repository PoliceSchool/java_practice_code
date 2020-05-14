package com.java_practice_code.algorithm.leetcode;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.Arrays;

// https://leetcode-cn.com/problems/set-mismatch/
public class FindErrorNums {
    // 参考答案：https://leetcode-cn.com/problems/set-mismatch/solution/cuo-wu-de-ji-he-by-leetcode/
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1;
        int missing = 1;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == nums[index - 1]) {
                dup = nums[index];
            } else if (nums[index] > nums[index - 1] + 1) {
                missing = nums[index - 1] + 1;
            }
        }
        return new int[]{dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }

    // 参考答案：https://leetcode-cn.com/problems/set-mismatch/solution/cuo-wu-de-ji-he-by-leetcode/
    public int[] findErrorNums2(int[] nums) {
        int dup = -1, missing = 1;
        for (int n : nums) {
            if (nums[Math.abs(n) - 1] < 0)
                dup = Math.abs(n);
            else
                nums[Math.abs(n) - 1] *= -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                missing = i + 1;
        }
        return new int[]{dup, missing};
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 4};
        int[] arr2 = {1, 1};
        int[] arr3 = {1, 2, 3, 3};
        int[] arr4 = {3, 2, 3, 4, 6, 5};
        int[] arr5 = {1, 5, 3, 2, 2, 7, 6, 4, 8, 9};
        System.out.println(Arrays.toString(new FindErrorNums().findErrorNums(arr5)));
    }
}
