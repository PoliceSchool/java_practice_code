package com.java_practice_code.algorithm.背包算法;

public class KnapsackMinimum {
    private static int knapSack(int[] val, int[] weight, int n, int capacity, int maxMum) {
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
        return path[n][capacity];
    }

    public static void main(String[] args) {
        int capacity = 8;
        int maxMum = 10000;
        int[] val = {3, 4, 6};
        int[] weight = new int[]{3, 2, 1};
        System.out.println(knapSack(val, weight, val.length, capacity, maxMum));
    }
}
