package com.java_practice_code.algorithm.niukewang;

/**
 * https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 本质上还是斐波那契数列
 *
 * 已通过牛客网测试
 */
public class RectCover {
    public int rectCover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return rectCover(target - 1) + rectCover(target - 2);
    }

    public static void main(String[] args) {
        System.out.println(new RectCover().rectCover(3));
    }
}
