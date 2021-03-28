package com.java_practice_code.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumDifferentIntegers {
    public static void main(String[] args) {
        new NumDifferentIntegers().numDifferentIntegers("a123bc34d8ef34");
        new NumDifferentIntegers().numDifferentIntegers("leet1234code234");
        new NumDifferentIntegers().numDifferentIntegers("a1b01c001");
    }

    public int numDifferentIntegers(String word) {
        int size = word.length();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            char ch = word.charAt(i);
            if (isInteger(ch)) {
                int j = i + 1;
                int x = (ch - '0');
                while (j < size && isInteger(word.charAt(j))) {
                    ch = word.charAt(j++);
                    x *= 10;
                    x += (ch - '0');
                }
                set.add(x);
                i = j;
            }
        }
        return set.size();
    }

    private boolean isInteger(char ch) {
        int x = ch - '0';
        return x >= 0 && x <= 9;
    }
}
