package com.java_practice_code.algorithm.leetcode;

public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit.maxProfit2(prices1));
        System.out.println(maxProfit.maxProfit2(prices2));
        System.out.println(maxProfit.maxProfit2(prices3));
    }


    public int maxProfit(int[] prices) {
        int[][] result = new int[prices.length][2];
        result[0][0] = 0;
        result[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            result[i][0] = Math.max(result[i - 1][0], result[i - 1][1] + prices[i]);
            result[i][1] = Math.max(result[i - 1][1], result[i - 1][0] - prices[i]);
        }
        return result[prices.length - 1][0];
    }

    public int maxProfit2(int[] prices) {
        int hold = -prices[0];
        int noHold = 0;
        for (int i = 1; i < prices.length; i++) {
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, noHold - prices[i]);
        }
        return noHold;
    }
}
