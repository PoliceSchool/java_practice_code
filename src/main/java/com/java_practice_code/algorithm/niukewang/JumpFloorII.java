package com.java_practice_code.algorithm.niukewang;

/**
 * https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * <p>
 * 简单的思路就是从斐波那契数列的思想拓展开来:
 * 斐波那契数列一开始设定只能走1步或者2步,所以斐波那契数列的递推式是f(n) = f(n-1) + f(n-2)
 * 现在设定可以走1到n步,所以递推式是f(n) = f(n-1) + f(n-2) + ... + f(n-n),也就是循环累加即可
 *
 * 已通过牛客网测试
 */
public class JumpFloorII {
    private int jumpFloorII(int target) {
        if (target == 1 || target == 0) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int sum = 0;
        for (int i = 1; i <= target; i++) {
            sum += jumpFloorII(target - i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("result:" + new JumpFloorII().jumpFloorII(5));
    }
}
