package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] result = str.split(" ");
        for (int index = result.length - 1; index >= 0; index--) {
            System.out.print(result[index] + " ");
        }
    }
}
