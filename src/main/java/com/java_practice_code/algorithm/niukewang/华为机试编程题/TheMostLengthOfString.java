package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.*;

/**
 * https://www.nowcoder.com/practice/5af18ba2eb45443aa91a11e848aa6723?tpId=37&tqId=21237&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 已通过牛客网测试
 */
public class TheMostLengthOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ArrayList<String> list = new ArrayList<>();
            while (n-- >= 0) {
                list.add(scanner.nextLine());
            }
            Collections.sort(list);
            list.remove("");
            list.forEach(System.out::println);
        }
    }
}
