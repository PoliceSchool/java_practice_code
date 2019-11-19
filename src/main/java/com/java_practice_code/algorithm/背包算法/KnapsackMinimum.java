package com.java_practice_code.algorithm.背包算法;

/**
 * 参考链接：https://www.geeksforgeeks.org/minimum-cost-to-fill-given-weight-in-a-bag/
 */
public class KnapsackMinimum {
    private static KnapsackResult knapSack(int[] val, int[] weight, int n, int capacity, int maxMum) {
        int[][] path = new int[n + 1][capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            path[0][i] = maxMum;
        }
        for (int i = 1; i <= n; i++) {
            path[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i - 1] > j) {
                    path[i][j] = path[i - 1][j];
                } else {
                    path[i][j] = Math.min(path[i - 1][j], path[i][j - weight[i - 1]] + val[i - 1]);
                }
            }
        }
        int result = path[n][capacity];
        int[] used = new int[n];
        for (int index = n; index >= 1; index--) {
            if (path[index][capacity] != path[index - 1][capacity]) {
                used[index - 1] = 1;
                capacity -= weight[index - 1];
            }
        }
        return new KnapsackResult(result, used);
    }

    public static void main(String[] args) {
        int capacity = 8;
        int maxMum = 10000;
        int[] val = {3, 4, 6};
        int[] weight = new int[]{3, 2, 1};
        System.out.println(knapSack(val, weight, val.length, capacity, maxMum));
    }
}
