package com.java_practice_code.leetcode;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/12/26.
 */
public class LengthOfLongestSubstring {
    private int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if ("".equals(s)) {
            return 0;
        }
        if (length == 1) {
            return length;
        }
        int start = 0, end = 1, maxLength = -1;
        while (end < length) {
            String temp = s.substring(start, end);
            if (temp.contains(s.substring(end, end + 1))) {
                if (end - start > maxLength) {
                    maxLength = end - start;
                }
                start++;
                end = start + 1;
            } else {
                end++;
            }
        }
        return (end - start) > maxLength ? (end - start) : maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring demo = new LengthOfLongestSubstring();
        System.out.println(demo.lengthOfLongestSubstring("abcabcbb"));
    }
}
