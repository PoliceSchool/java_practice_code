package com.java_practice_code.algorithm.背包算法;

/**
 * 背包算法代码：https://www.geeksforgeeks.org/java-program-for-dynamic-programming-set-10-0-1-knapsack-problem/
 * @author lujingxiao
 */
public class KnapsackRecursive  {

    /**
     * A utility function that returns maximum of two integers
     */
    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * Returns the maximum value that can
     * be put in a knapsack of capacity W
     */
    private static int knapSack(int w, int wt[], int val[], int n) {
        // Base Case
        if (n == 0 || w == 0) {
            return 0;
        }

        // If weight of the nth item is more
        // than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n - 1] > w) {
            return knapSack(w, wt, val, n - 1);
        }
        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        else {
            return max(val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1),
                    knapSack(w, wt, val, n - 1));
        }

    }

    /**
     * Driver program to test above function
     */
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int w = 50;
        int n = val.length;
        System.out.println(knapSack(w, wt, val, n));
    }
}