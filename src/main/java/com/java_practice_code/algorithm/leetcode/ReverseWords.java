package com.java_practice_code.algorithm.leetcode;

public class ReverseWords {
    // 参考官网答案
    // https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/solution/mian-shi-ti-58-i-fan-zhuan-dan-ci-shun-xu-shuang-z/
    private String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("the sky is blue"));
    }
}
