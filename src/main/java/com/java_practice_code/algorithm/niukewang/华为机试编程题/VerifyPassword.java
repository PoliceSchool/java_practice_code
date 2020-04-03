package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;

/**
 * 密码验证合格程序
 * https://www.nowcoder.com/practice/184edec193864f0985ad2684fbc86841?tpId=37&tqId=21243&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class VerifyPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            if (chars.length <= 8) {
                System.out.println("NG");
                continue;
            }

            int count = 0;
            int[] counts = {0, 0, 0, 0};
            for (char aChar : chars) {
                if (aChar >= 'a' && aChar <= 'z') {
                    counts[0] = 1;
                } else if (aChar >= 'A' && aChar <= 'Z') {
                    counts[1] = 1;
                } else if (aChar >= '0' && aChar <= '9') {
                    counts[2] = 1;
                } else {
                    counts[3] = 1;
                }
            }
            if ((counts[0] + counts[1] + counts[2] + counts[3]) < 3 || haveSameChars(str)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    /**
     * 题目说：不能有相同长度超2的子串重复
     * 举例：021Abc9Abc1，这个字符串重复出现了Abc，并且Abc的长度超过了2.所以是NG的
     * 所以重复子串的最小长度为3，所以只需要判断其中的字符串中任意连续长度为3的子串是否重复即可。
     */
    private static boolean haveSameChars(String str) {
        int length = str.length();
        for (int i = 0; i < length - 3; i++) {
            String temp1 = str.substring(i, i + 3);
            String temp2 = str.substring(i + 3, length);
            if (temp2.contains(temp1)) {
                return true;
            }
        }
        return false;
    }
}
