package com.java_practice_code.algorithm.niukewang;

/**
 * https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0
 *
 * 已通过牛客网测试
 */
public class Power {
    public double power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        double result = 1;
        int loop = Math.abs(exponent);
        while (loop-- > 0) {
            if (exponent > 0){
                result *= base;
            } else {
                result /= base;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("result:" + new Power().power(2, -3));
    }
}
