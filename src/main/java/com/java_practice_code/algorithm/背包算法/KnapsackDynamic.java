package com.java_practice_code.algorithm.背包算法;


/**
 * 背包算法代码：https://www.geeksforgeeks.org/java-program-for-dynamic-programming-set-10-0-1-knapsack-problem/
 * 记录路径：http://www.voidcn.com/article/p-bcrsptpr-ok.html
 *
 * @author lujingxiao
 */
public class KnapsackDynamic {

    public static void main(String[] args) {
        int capacity = 10;
        int[] val = new int[]{6, 3, 5, 4, 6};
        int[] weight = new int[]{2, 2, 6, 5, 4};
        System.out.println(Knapsack.knapSack(capacity, weight, val, val.length));
    }

    static class Knapsack {
        static int max(int a, int b) {
            return (a > b) ? a : b;
        }

        static KnapsackResult knapSack(int capacity, int[] weight, int[] val, int n) {
            int i, w;
            int[][] path = new int[n + 1][capacity + 1];
            for (i = 0; i <= n; i++) {
                for (w = 0; w <= capacity; w++) {
                    if (i == 0 || w == 0) {
                        path[i][w] = 0;
                    } else if (weight[i - 1] <= w) {
                        path[i][w] = max(val[i - 1] + path[i - 1][w - weight[i - 1]], path[i - 1][w]);
                    } else {
                        path[i][w] = path[i - 1][w];
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
    }
}
