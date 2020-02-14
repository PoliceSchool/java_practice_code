package com.java_practice_code.algorithm.niukewang;

/**
 * @author lujingxiao
 * 剑指Offer编程题：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 通常的解法是遍历二维数组，但是有更好的解法：https://www.cnblogs.com/edisonchou/p/4737944.html
 *
 * 两种解法已通过牛客网测试：https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e
 */
public class FindNumber {
    public boolean solutionOne(int target, int[][] array) {
        int firstLen = array[0].length;
        int seccondLen = array.length;
        for (int i = 0; i < firstLen; i++) {
            for (int j = 0; j < seccondLen; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean solutionTwo(int target, int[][] array) {
        int firstLen = array[0].length;
        int seccondLen = array.length;
        int i = 0;
        while (firstLen > 0 && seccondLen > 0) {
            if (array[i][firstLen - 1] == target) {
                return true;
            } else if (array[i][firstLen - 1] > target) {
                firstLen--;
            } else {
                seccondLen--;
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(new FindNumber().solutionTwo(7, arr));
    }
}
