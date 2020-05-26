package com.java_practice_code.algorithm.leetcode;

public class IsBoomerang {
    // 自己写的，会出现斜率为0的状况
    private static boolean isBoomerang(int[][] points) {
        if ((points[0][0] / points[0][1]) == (points[1][0] / points[1][1])) {
            if ((points[0][0] / points[0][1]) == (points[2][0] / points[2][1])) {
                return false;
            }
        }
        return true;
    }

    // 参考leetcode官网
    private static boolean isBoomerang2(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];

        return !((x1 - x3) * (y1 - y2) == (x1 - x2) * (y1 - y3));
    }

    public static void main(String[] args) {
//        int[][] arr = {{1, 1}, {2, 3}, {3, 2}};
        int[][] arr = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(isBoomerang(arr));
    }
}
