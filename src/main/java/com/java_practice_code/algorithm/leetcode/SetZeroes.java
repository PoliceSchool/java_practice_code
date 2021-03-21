package com.java_practice_code.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetZeroes {

    public static void main(String[] args) {
//        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new SetZeroes().setZeroes(matrix);
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        List<Result> resultList = new ArrayList<>();

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    resultList.add(new Result(i, j));
                }
            }
        }

        for (Result result : resultList) {
            for (int i = 0; i < rowLength; i++) {
                matrix[i][result.y] = 0;
            }
            for (int i = 0; i < colLength; i++) {
                matrix[result.x][i] = 0;
            }
        }

    }

    class Result {
        public int x;
        public int y;

        public Result(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
