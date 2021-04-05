package com.java_practice_code.algorithm.leetcode;

public class TruncateSentence {
    public static void main(String[] args) {
        System.out.println(new TruncateSentence().truncateSentence("Hello how are you Contestant", 4));
        System.out.println(new TruncateSentence().truncateSentence("What is the solution to this problem", 4));
        System.out.println(new TruncateSentence().truncateSentence("chopper is not a tanuki", 5));
    }

    public String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                stringBuilder.append(arr[i]);
            } else {
                stringBuilder.append(arr[i] + " ");
            }
        }
        return stringBuilder.toString();
    }
}
