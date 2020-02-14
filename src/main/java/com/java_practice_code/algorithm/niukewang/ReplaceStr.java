package com.java_practice_code.algorithm.niukewang;

/**
 * 剑指Offer编程题：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 两种解法已通过牛客网测试：https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class ReplaceStr {
    public String solutionOne(StringBuffer str) {
        String temp = String.valueOf(str);
        return temp.replaceAll(" ", "%20");
    }

    public String solutionTwo(StringBuffer str) {
        int length = str.length();
        char[] chars = str.toString().toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            if (ch == ' ') {
                stringBuffer.append('%');
                stringBuffer.append('2');
                stringBuffer.append('0');
            } else {
                stringBuffer.append(ch);
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("We Are Happy");
        System.out.println(new ReplaceStr().solutionTwo(stringBuffer));
    }
}
