package com.java_practice_code.interview;

import java.util.Scanner;

/**
 * 来源于这里https://www.bilibili.com/video/av42205755?from=search&seid=1523853651607646645
 * 将阿拉伯数字表示的金额转成汉字表示的金额
 */
public class MoneyConvert {
    private static final char[] units = {'圆', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿'};
    private static final char[] data = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入金额:");
        int money = scanner.nextInt();
        System.out.println("转换结果是: " + convert(money));
    }

    private static String convert(int money) {
        StringBuffer stringBuffer = new StringBuffer("整");
        int index = 0;
        while (money != 0) {
            stringBuffer.insert(0, units[index++]);
            stringBuffer.insert(0, data[money % 10]);
            money /= 10;
        }
        return stringBuffer.toString();
    }
}
