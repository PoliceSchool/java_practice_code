package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&tqId=21224&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 已通过牛客网测试
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();

            int length = chars.length;
            int index = length - 1;
            for (; index >= 0; index--) {
                if (' ' == chars[index]) {
                    break;
                }
            }
            System.out.println(length - index - 1);
        }
    }
}
