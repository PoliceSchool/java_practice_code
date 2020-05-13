package com.java_practice_code.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/palindrome-linked-list/
public class IsPalindrome2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(1);

        head.next = first;
        first.next = second;
        second.next = third;
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int length = list.size();
        for (int i = 0; i < length / 2; i++) {
            if (!list.get(i).equals(list.get(length - i - 1))) {
                return false;
            }
        }
        return true;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
