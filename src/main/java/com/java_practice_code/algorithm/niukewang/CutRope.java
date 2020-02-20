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
        // 题解：一整根绳子最大乘积其实是分解为2段时的最大乘积；但是绳子长度是8时得到的最大乘积18时所分成的段数是3段啊？分别是2、3、3
        // 其实，只需要想象成是2、6或者5、3这种乘积即可；因为6的最大乘积可能是3、3，如果是2、这种情况的话，最后最大乘积的分段就是2、3、3
        // 如果是5、3这种乘积的话，因为5的最大乘积可能是2、3，最后最大乘积的分段也是2、3、3
        // 所以一整根绳子最大乘积其实是分解为2段时的最大乘积，而这两段的最大乘积还是分别分解为两段时的乘积，最后最大值就是多段的乘积
        // 也可以这样理解，就是每一次分解绳子只能将其分解为两段，所以公式是这样的max(f(i)*f(n-i))
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
