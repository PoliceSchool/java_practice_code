package com.java_practice_code.leetcode;

/**
 * description: Z字形变换：https://leetcode-cn.com/problems/zigzag-conversion/submissions/
 * date: Created in 2020/1/4.
 * 详解：按照给定的字符串画出行数为3、4、5的情况，分析字符串中每个字符位置下标数字，总结出规律即可。
 * 3行时每个字符串位置的情况：第一行间隔是4（2*3-2）；第二行间隔为2；最后一行间隔为4
 * 0   4   8
 * 1 3 5 7 9  11
 * 2   6   10
 *
 * 4行时每个字符串位置的情况：第一行间隔是6（2*4-2）；第二行间隔分别为4和2，加起来为6；第三行间隔为2和4，加起来为6；最后一个行间隔为6
 * 0     6      12
 * 1   5 7   11 13
 * 2 4   8 10   14
 * 3     9      15
 *
 * 5行时每个字符串位置的情况：第一行间隔是8（2*5-2）；第二行间隔分别为6和2，加起来为8；第三行间隔为4和4，加起来为8；第四行间隔为2和6，加起来为8；最后一个行间隔为8
 * 0       8          16
 * 1     7 9       15 17
 * 2   6   10   14    18
 * 3 5     11 13      19
 * 4       12         20
 * @author lujingxiao
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("LEETCODEISHIRING", 3));
    }

    private String convert(String s, int numRows) {
        int index = 0, length = s.length(), up = 2 * numRows - 2, down = 0;
        if (up == 0) {
            return s;
        }
        StringBuilder result = new StringBuilder("");
        while (index < numRows) {
            boolean flag = true;
            int subIndex = index;
            while (subIndex < length) {
                if (down == 0 || down == up) {
                    result.append(s.charAt(subIndex));
                    subIndex += up;
                    continue;
                }
                result.append(s.charAt(subIndex));
                if (flag) {
                    subIndex += (up - down);
                    flag = false;
                } else {
                    subIndex += down;
                    flag = true;
                }
            }
            down += 2;
            index++;
        }
        return result.toString();
    }
}
