package com.java_practice_code.algorithm.leetcode;

public class XorOperation {

    public static void main(String[] args) {
        XorOperation xorOperation = new XorOperation();
        xorOperation.test1();
        xorOperation.test2();
        xorOperation.test3();
        xorOperation.test4();
    }

    private void test1() {
        System.out.println(xorOperation(5, 0));
    }

    private void test2() {
        System.out.println(xorOperation(4, 3));
    }

    private void test3() {
        System.out.println(xorOperation(1, 7));
    }

    private void test4() {
        System.out.println(xorOperation(10, 5));
    }


    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; i++) {
            result ^= start + 2 * i;
        }
        return result;
    }
}
