package com.java_practice_code.algorithm.leetcode;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2020/2/27.
 */
public class MaxArea {
    // 暴力法，自己写出来的
    private static int maxAreaOne(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    //双指针法，参考leetcode官方思路，没看代码
    private static int maxAreaTwo(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            max = Math.max(max, (end - start) * Math.min(height[start], height[end]));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("the result is:" + maxAreaTwo(arr));
    }
}
