package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/253986e66d114d378ae8de2e6c4577c1?tpId=37&tqId=21232&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * <p>
 * 已通过牛客网测试
 */
public class NumberDuplicateRemoval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            solution2(scanner.nextInt());
        }
    }

    private static void solution1(int num) {
        int[] flags = new int[10];
        boolean needContinue = true;
        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            int index = num % 10;
            num /= 10;
            if (needContinue && index == 0) {
                continue;
            }
            if (flags[index] == 0) {
                sb.append(index);
                flags[index] = 1;
                needContinue = false;
            }
        }
        System.out.println(sb);
    }

    private static void solution2(int num) {
        int[] flags = new int[10];
        while (num > 0) {
            int index = num % 10;
            num /= 10;
            if (flags[index] == 0) {
                System.out.print(index);
                flags[index] = 1;
            }
        }
    }
}
