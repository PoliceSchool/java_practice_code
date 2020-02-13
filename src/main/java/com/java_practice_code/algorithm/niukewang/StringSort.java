package com.java_practice_code.algorithm.niukewang;

import java.util.Scanner;

// 字符串排序:https://www.nowcoder.com/questionTerminal/5190a1db6f4f4ddb92fd9c365c944584
// 已通过所有测试用例
public class StringSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            int length = chars.length;
            char[] temp = new char[length];
            int index = 0;
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < length; j++) {
                    char ch = chars[j];
                    if (ch - 'a' == i || ch - 'A' == i) {
                        temp[index++] = ch;
                    }
                }
            }
            index = 0;
            char[] result = new char[length];
            for (int j = 0; j < length; j++) {
                char ch = chars[j];
                if (Character.isLetter(ch)) {
                    result[j] = temp[index++];
                } else {
                    result[j] = ch;
                }
            }
            System.out.println(result);
        }
    }
}
