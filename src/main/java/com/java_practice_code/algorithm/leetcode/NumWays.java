package com.java_practice_code.algorithm.leetcode;

public class NumWays {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int n1 = 1, n2 = 1, temp;
        while (n-- >= 2) {
            temp = n1;
            n1 = n2;
            n2 = (temp + n2) % 1000000007;
        }
        System.out.println(n2);
        return n2;
    }

    public static void main(String[] args) {
        NumWays t = new NumWays();
        t.numWays(0);
        t.numWays(1);
        t.numWays(2);
        t.numWays(3);
        t.numWays(4);
        t.numWays(5);
        t.numWays(6);
        t.numWays(7);
        t.numWays(46);
        t.numWays(92);
        // 971215059 720754435
    }
}
