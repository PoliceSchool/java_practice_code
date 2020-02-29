package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strs = scanner.nextLine().split(" ");
            int allMoney = Integer.parseInt(strs[0]);
            int shopItemCount = Integer.parseInt(strs[1]);
            int[] value = new int[shopItemCount];
            int[] weight = new int[shopItemCount];
            int[] parentIndex = new int[shopItemCount];
            int index = 0;
            while (--shopItemCount >= 0) {
                String[] itemInfos = scanner.nextLine().split(" ");
                value[index] = Integer.parseInt(itemInfos[0]);
                weight[index] = Integer.parseInt(itemInfos[1]);
                parentIndex[index++] = Integer.parseInt(itemInfos[2]);
            }

            int[][] path = new int[value.length][allMoney / 10];
            for (int i = 1; i <= value.length; i++) {
                for (int j = 1; j <= allMoney / 10; j++) {
                    if (parentIndex[i - 1] == 0) {
                        if (value[i - 1] > j) {
                            path[i][j] = path[i - 1][j];
                        } else {
                            path[i][j] = Math.max(path[i - 1][j], path[i][j - weight[i - 1]] * value[i - 1]);
                        }
                    } else {
                        int parent = parentIndex[i - 1];

                    }

                }
            }
            System.out.println();
        }
    }
}
