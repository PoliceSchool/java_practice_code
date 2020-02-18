package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2020/2/17.
 */
public class StringReverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            char[] result = new char[str.length()];
            for (int i = str.length() - 1; i >= 0; i--) {
                result[i] = chars[str.length() - i - 1];
            }
            System.out.println(String.valueOf(result));
        }
    }
}
