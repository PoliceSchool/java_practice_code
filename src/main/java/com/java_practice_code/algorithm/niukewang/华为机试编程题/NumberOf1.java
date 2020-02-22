package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 原码/反码/补码的知识:https://www.cnblogs.com/zhangziqiu/archive/2011/03/30/computercode.html
 * [+1] = [00000001]原 = [00000001]反 = [00000001]补
 * [-1] = [10000001]原 = [11111110]反 = [11111111]补
 *
 * 已通过牛客网测试
 */
public class NumberOf1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int count = 0;
            while (n != 0) {
                count += (n & 1);
                n >>>= 1;
            }
            System.out.println(count);
        }
    }
}
