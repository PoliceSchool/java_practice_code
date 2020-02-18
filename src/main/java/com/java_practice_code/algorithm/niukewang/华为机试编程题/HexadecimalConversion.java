package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&tqId=21228&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 * 已通过牛客网测试
 */
public class HexadecimalConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            int sum = 0;
            int count = chars.length - 3;
            for (int i = chars.length - 1; i >= 2; i--) {
                int base;
                if ('A' == chars[i]) {
                    base = 10;
                } else if ('B' == chars[i]) {
                    base = 11;
                } else if ('C' == chars[i]) {
                    base = 12;
                } else if ('D' == chars[i]) {
                    base = 13;
                } else if ('E' == chars[i]) {
                    base = 14;
                } else if ('F' == chars[i]) {
                    base = 15;
                } else {
                    base = Integer.valueOf(String.valueOf(chars[i]));
                }
                sum += Math.pow(16, chars.length - 1 - i) * base;
            }
            System.out.println(sum);
        }
    }
}
