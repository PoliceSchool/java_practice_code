package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&tqId=21225&tPage=1&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * 题目描述
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 * <p>
 * 输入
 * ABCDEF
 * A
 * 输出
 * 1
 *
 * 已通过牛客网测试
 */
public class NumberOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String ch = scanner.nextLine();
            char[] chars = str.toCharArray();
            char target = ch.toCharArray()[0];
            int jianju = 'a' - 'A';
            int count = 0;
            for (char aChar : chars) {
                if (aChar + jianju == target || aChar == target + jianju || aChar == target) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
