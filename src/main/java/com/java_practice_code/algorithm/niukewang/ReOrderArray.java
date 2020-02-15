package com.java_practice_code.algorithm.niukewang;

/**
 * https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * 已通过牛客网测试
 */
public class ReOrderArray {

    // 已通过牛客网测试
    private static void reOrderArray(int[] array) {
        int index = 0;
        int[] result = new int[array.length];
        for (int i : array) {
            if (i % 2 == 1) {
                result[index++] = i;
            }
        }
        for (int i : array) {
            if (i % 2 == 0) {
                result[index++] = i;
            }
        }
        for (index = 0; index < array.length; index++) {
            array[index] = result[index];
        }
    }

    // 这个方法只能保证奇数和偶数分别在数组的两侧,不能保证相对位置,所以不能通过牛客网测试,之所以写这个方法是因为这个刷选奇偶数的方法值得借鉴
    // 参考链接:https://blog.csdn.net/zhangshk_/article/details/81190870
    private static void reOrderArray2(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int temp = 0;
        while (i < j) {
            if ((array[i] & 1) == 1) {
                i++;
                continue;
            }
            if ((array[j] & 1) == 0) {
                j--;
                continue;
            }
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] ss = {1, 2, 3, 4, 5};
        reOrderArray(ss);
        System.out.println("result:" + ss);
    }
}
