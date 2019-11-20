package com.java_practice_code.algorithm.sort;

/**
 * description: bit-map排序算法,不过受限于int或者long的位数限制
 *
 * @author lujingxiao
 */
public class BitMapSort {
    public static void main(String[] args) {
        int[] arr = {4, 32, 7, 2, 5, 3, 12};
        int min = 0;
        long bitMap = sort(arr);
        while (bitMap != 0) {
            if (bitMap % 2 == 1) {
                System.out.print(min + " ");
            }
            min++;
            bitMap /= 2;
        }
    }

    private static long sort(int[] arr) {
        long bitMap = 0;
        for (int i : arr) {
            // 这一步将对应的比特位置为1；比如i为5的话，会将bitMap的第6位设置为1，如果为7则将bitMap的第8位设置为1
            bitMap |= (1L << i);
        }
        return bitMap;
    }
}
