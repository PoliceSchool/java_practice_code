package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/eb94f6a5b2ba49c6ac72d40b5ce95f50?tpId=37&tqId=21233&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
 * 已通过牛客网测试
 */
public class CountOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            int[] flags = new int[128];
            int count = 0;
            for (char aChar : chars) {
                if (aChar > 0 && aChar < 127 && flags[aChar] == 0) {
                    count++;
                    flags[aChar] = 1;
                }
            }
            System.out.println(count);
        }
    }
}
