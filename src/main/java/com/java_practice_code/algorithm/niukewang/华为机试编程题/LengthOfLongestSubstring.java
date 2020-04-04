package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if ("".equals(s)) {
            return 0;
        }
        if (length == 1) {
            return length;
        }
        int start = 0, end = 1, manLength = -1;
        while (end < length) {
            String temp = s.substring(start, end);
            if (temp.contains(s.substring(end, end + 1))) {
                if (end - start > manLength) {
                    manLength = end - start;
                }
                start++;
                end = start + 1;
            } else {
                end++;
            }
        }
        return (end - start) > manLength ? (end - start) : manLength;
    }
}
