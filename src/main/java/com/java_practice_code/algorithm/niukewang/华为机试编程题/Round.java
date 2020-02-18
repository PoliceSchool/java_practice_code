package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/3ab09737afb645cc82c35d56a5ce802a?tpId=37&tqId=21230&rp=0&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tPage=1
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * 已通过牛客网测试
 */
public class Round {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double num = scanner.nextDouble();
            System.out.println(num - (int)num >= 0.5 ? ((int)num) + 1 : (int)num);
        }
    }
}
