package com.java_practice_code.algorithm.leetcode;

import java.util.Arrays;

public class Decode {

    public static void main(String[] args) {
        Decode decode = new Decode();
        decode.test1();
        decode.test2();
    }

    private void test1() {
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(decode(arr, 1)));
    }

    private void test2() {
        int[] arr = {6, 2, 7, 3};
        System.out.println(Arrays.toString(decode(arr, 4)));
    }

    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for (int i = 1; i <= encoded.length; i++) {
            arr[i] = encoded[i - 1] ^ arr[i - 1];
        }
        return arr;
    }
}
