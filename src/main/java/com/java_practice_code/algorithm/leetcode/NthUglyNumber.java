package com.java_practice_code.algorithm.leetcode;

public class NthUglyNumber {

    private int count = 0;

    public static void main(String[] args) {
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
//        nthUglyNumber.test1();
//        nthUglyNumber.test2();
//        nthUglyNumber.test3();
        nthUglyNumber.test4();
        System.out.println();
    }

    private void test1() {
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber2(10));
    }

    private void test2() {
        System.out.println(nthUglyNumber(1));
        System.out.println(nthUglyNumber2(1));
    }

    private void test3() {
        System.out.println(nthUglyNumber(2));
        System.out.println(nthUglyNumber2(2));
    }

    private void test4() {
        System.out.println(nthUglyNumber(1352));
//        System.out.println(nthUglyNumber2(1352));
    }

    public int nthUglyNumber(int n) {
        int i = 1;
        while (n > 0) {
            if (isUgly(i)) {
                n--;
            }
            i++;
        }
        return i - 1;
    }

    private boolean isUgly(int n) {
        while (true) {
            count++;
            if (n == 0) {
                return false;
            }
            if (n == 1) {
                return true;
            }
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }
            if (n % 3 == 0) {
                n /= 3;
                continue;
            }
            if (n % 5 == 0) {
                n /= 5;
                continue;
            }
            return false;
        }
    }


    public int nthUglyNumber2(int n) {
        if (n == 1) {
            return n;
        }
        int i = 1;
        while (n > 0) {
            if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0) {
                i++;
                continue;
            }
            n--;
            if (n == 0) {
                return i;
            }
        }
        return i;
    }
}
