package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&tqId=21227&rp=0&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class PrintString {
    public static void main(String[] args) {
        solution2();
    }

    private static void solution2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            while (line.length() >= 8) {
                System.out.println(line.substring(0, 8));
                line = line.substring(8);
            }
            if (line.length() > 0) {
                line = line + "00000000";
                System.out.println(line.substring(0, 8));
            }
        }
    }

    private static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String[] str = {"", ""};
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            str[count] = line;
            if (count == 0) {
                count++;
            } else {
                for (int num = 0; num <= count; num++) {
                    char[] chars = str[num].toCharArray();
                    char[] result = new char[8];
                    int length = chars.length;
                    int loop = length / 8;
                    for (int i = 0; i <= loop; i++) {
                        if (length >= ((i + 1) * 8)) {
                            System.out.println(String.valueOf(Arrays.copyOfRange(chars, i * 8, (i + 1) * 8)));
                        } else {
                            if (i * 8 >= length) {
                                continue;
                            }
                            int index = 0;
                            char[] temp = new char[8];
                            for (int j = i * 8; j < length; j++) {
                                temp[index++] = chars[j];
                            }
                            Arrays.fill(temp, length - i * 8, 8, '0');
                            System.out.println(String.valueOf(temp));
                        }
                    }
                }
                str[0] = "";
                str[1] = "";
                count = 0;
            }
        }
    }
}
