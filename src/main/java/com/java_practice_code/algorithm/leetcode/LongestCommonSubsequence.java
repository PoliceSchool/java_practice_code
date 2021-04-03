package com.java_practice_code.algorithm.leetcode;

public class LongestCommonSubsequence {
    private char[] textArr1;
    private char[] textArr2;

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abc", "abc"));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abc", "def"));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));


        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence2("abcde", "ace"));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence2("abc", "abc"));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence2("abc", "def"));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence2("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }

    // 递归解法(超时)
    public int longestCommonSubsequence(String text1, String text2) {
        textArr1 = text1.toCharArray();
        textArr2 = text2.toCharArray();
        return doLongestCommonSubsequence(0, 0);
    }

    public int doLongestCommonSubsequence(int startIndex1, int startIndex2) {
        if (startIndex1 >= textArr1.length || startIndex2 >= textArr2.length) {
            return 0;
        }
        if (textArr1[startIndex1] == textArr2[startIndex2]) {
            return doLongestCommonSubsequence(startIndex1 + 1, startIndex2 + 1) + 1;
        }
        return Math.max(doLongestCommonSubsequence(startIndex1 + 1, startIndex2), doLongestCommonSubsequence(startIndex1, startIndex2 + 1));
    }

    // 动态规划解法
    public int longestCommonSubsequence2(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        int[][] result = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            char ch   = text1.charAt(i - 1);
            for (int j = 1; j <= length2; j++) {
                if (ch == text2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        return result[length1][length2];
    }
}
