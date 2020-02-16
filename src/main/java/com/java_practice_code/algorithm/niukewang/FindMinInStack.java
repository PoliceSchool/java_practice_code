package com.java_practice_code.algorithm.niukewang;

import java.util.*;

/**
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 已通过牛客网测试
 */
public class FindMinInStack {
    int minIndex = 0;
    Stack<Integer> stack = new Stack();

    public void push(int node) {
        stack.push(node);
        if (min() >= node) {
            minIndex = stack.size() - 1;
        }
    }

    public void pop() {
        int key = top();
        if (min() == key) {
            Object[] arr = stack.toArray();
            int size = arr.length;
            int min = (int) arr[size - 2];
            for (int index = size - 2; index >= 0; index--) {
                if (min > (int) arr[index]) {
                    minIndex = index;
                }
            }
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stack.elementAt(minIndex);
    }

    // ["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
    public static void main(String[] args) {
        FindMinInStack op = new FindMinInStack();
        op.push(3);
        System.out.println(op.min());
        op.push(4);
        System.out.println(op.min());
        op.push(2);
        System.out.println(op.min());
        op.push(3);
        System.out.println(op.min());
        op.pop();
        System.out.println(op.min());
        op.pop();
        System.out.println(op.min());
        op.pop();
        System.out.println(op.min());
        op.push(0);
        System.out.println(op.min());
    }
}
