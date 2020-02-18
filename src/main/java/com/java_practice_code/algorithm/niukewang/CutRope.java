package com.java_practice_code.algorithm.niukewang;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 本题做出不出来，通过参考他人答案完成
 * 已通过牛客网测试
 */
public class CutRope {

    private int cutRope(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int max;
        int[] arr = new int[target + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for (int i = 4; i < target + 1; i++) {
            max = 0;
            for (int j = 1; j < (i / 2) + 1; j++) {
                max = Math.max(arr[j] * arr[i - j], max);
            }
            arr[i] = max;
        }
        return arr[target];
    }

    public static void main(String[] args) {
        System.out.println("result: " + new CutRope().cutRope(8));
    }
}
