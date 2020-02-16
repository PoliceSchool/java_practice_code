package com.java_practice_code.algorithm.niukewang;

import java.util.ArrayList;

public class PrintMatrix {
    //未完成
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int rowNum = matrix.length;
        int cowNum = matrix[0].length;
        boolean down = false;
        boolean right = true;
        int i = 0;
        int j = 0;
        if (right){
            if (j != cowNum) {
                System.out.println(matrix[i][j++]);
            }
            if (j == cowNum) {
                System.out.println(matrix[i][j]);
                i++;
                right = false;
                down = true;
            }
        }
        return null;
    }
}
