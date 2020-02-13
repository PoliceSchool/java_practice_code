package com.java_practice_code.algorithm.背包算法;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2020/2/13.
 */
public class KnapsackMinimumNew {
    /**
     * 参考资料：https://www.geeksforgeeks.org/minimum-cost-to-fill-given-weight-in-a-bag/
     * 带有记录路径的完全背包算法
     */
    private static KnapsackResult knapSack(int capacity, int[] weight, double[] val, int n, double maxMum) {
        double[][] path = new double[n + 1][capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            path[0][i] = maxMum;
        }
        for (int i = 1; i <= n; i++) {
            path[i][0] = 0;
        }
        // i表示第i个物品，表示当前要不要往背包里面放第i个物品
        // j表示当前背包的容量
        // val[i - 1]表示第i个物品的价值，weight[i - 1]表示第i个物品的重量
        // path[i][j]表示背包容量为j时，前i个物品的最小价值（这i个物品不一定都放在背包内）
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                // path[i - 1][j]表示不放第i个物品时背包的总价值；
                // path[i][j]表示第i个物品已经尝试放进背包之后的总价值，当第i个物品放不下的时，path[i][j]的值还是path[i - 1][j]
                // 当第i个物品的重量weight[i - 1]大于当前背包的容量j，表示第i个物品放不下，所以当前背包的总价值跟之前一样，path[i][j]的值还是path[i - 1][j]
                if (weight[i - 1] > j) {
                    path[i][j] = path[i - 1][j];
                }
                // 否则表示第i个物品的重量weight[i - 1]小于等于当前背包的容量j，当前背包的容量放得下第i个物品
                // 于是就选择放还是不放第i个物品:
                // 如果选择往背包里面第i个物品，那么path[i][j] = path[i][j - weight[i - 1]] + val[i - 1]。path[i][j - weight[i - 1]]表示当前背包容量为j时，放入第i个物品后，背包所剩余的容量所能够得到的最小价值，这个最小价值是之前的循环已经计算好的。
                // 如果选择不往背包里面放第i个物品，那么path[i][j]的值还是path[i - 1][j]
                else {
                    path[i][j] = Math.min(path[i - 1][j], path[i][j - weight[i - 1]] + val[i - 1]);
                }
            }
        }
        double result = path[n][capacity];
        int[] used = new int[n];
        for (int index = n; index >= 1; index--) {
            if (path[index][capacity] != path[index - 1][capacity]) {
                used[index - 1] = 1;
                capacity -= weight[index - 1];
            }
        }
        return new KnapsackResult((int) result, used);
    }
}
