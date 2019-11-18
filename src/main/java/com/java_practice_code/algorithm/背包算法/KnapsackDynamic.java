package com.java_practice_code.algorithm.背包算法;


/**
 * 背包算法代码：https://www.geeksforgeeks.org/java-program-for-dynamic-programming-set-10-0-1-knapsack-problem/
 * 记录路径：http://www.voidcn.com/article/p-bcrsptpr-ok.html
 * @author lujingxiao
 */
public class KnapsackDynamic {
    // A utility function that returns maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that can be put in a knapsack
    // of capacity W
    static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        int result = K[n][W];
        int[] used = new int[n];
        for (int index = n; index >= 1; index--) {
            if (K[index][W] != K[index - 1][W]) {
                used[index - 1] = 1;
                W -= wt[index - 1];
            }
        }
        for (int index = 0; index <= n - 1; index++) {
            System.out.print(used[index]);
        }
        System.out.println();
        return result;
    }

    // Driver program to test above function
    public static void main(String args[]) {
        int val[] = new int[]{6, 3, 5, 4, 6};
        int wt[] = new int[]{2, 2, 6, 5, 4};
        int W = 10;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
