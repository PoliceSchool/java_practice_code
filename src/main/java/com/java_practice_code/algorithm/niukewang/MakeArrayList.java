package com.java_practice_code.algorithm.niukewang;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 剑指Offer编程题：输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 已通过牛客网测试：https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class MakeArrayList {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (null != listNode) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
