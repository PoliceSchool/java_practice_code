package com.java_practice_code.algorithm.leetcode;

import java.util.Stack;

public class IsValid {
    // 参考官网思路
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else if (!stack.isEmpty()) {
                if (aChar == ')') {
                    if (stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }

                if (aChar == ']') {
                    if (stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }

                if (aChar == '}') {
                    if (stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("()"));
        System.out.println(new IsValid().isValid("()[]{}"));
        System.out.println(new IsValid().isValid("(]"));
        System.out.println(new IsValid().isValid("([)]"));
        System.out.println(new IsValid().isValid("(])"));
    }
}
