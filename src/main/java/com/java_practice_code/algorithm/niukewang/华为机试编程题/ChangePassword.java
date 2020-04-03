package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;

public class ChangePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        int length = 'a' - 'A';
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar >= 'a' && aChar <= 'c') {
                result[i] = '2';
            } else if (aChar >= 'd' && aChar <= 'f') {
                result[i] = '3';
            } else if (aChar >= 'g' && aChar <= 'i') {
                result[i] = '4';
            } else if (aChar >= 'j' && aChar <= 'l') {
                result[i] = '5';
            } else if (aChar >= 'm' && aChar <= 'o') {
                result[i] = '6';
            } else if (aChar >= 'p' && aChar <= 's') {
                result[i] = '7';
            } else if (aChar >= 't' && aChar <= 'v') {
                result[i] = '8';
            } else if (aChar >= 'w' && aChar <= 'z') {
                result[i] = '9';
            } else if (aChar >= 'A' && aChar < 'Z') {
                result[i] = (char) (aChar + length + 1);
            } else if (aChar == 'Z') {
                result[i] = 'a';
            } else {
                result[i] = aChar;
            }
        }
        System.out.println(new String(result));
    }
}
