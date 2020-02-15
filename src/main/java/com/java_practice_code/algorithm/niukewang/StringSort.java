package com.java_practice_code.algorithm.niukewang;

import java.util.Scanner;

// 字符串排序:https://www.nowcoder.com/questionTerminal/5190a1db6f4f4ddb92fd9c365c944584
// 已通过牛客网测试
public class StringSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            String str1 = "";
            for (char ch : chars) {
                if (str1.contains(String.valueOf(ch))) {
                    continue;
                }
                str1 += ch;
            }
            System.out.println(str1);
        }
    }
}
