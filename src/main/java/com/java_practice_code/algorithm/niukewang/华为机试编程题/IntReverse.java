package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;

public class IntReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        while (i != 0) {
            System.out.print(i % 10);
            i /= 10;
        }
    }
}
