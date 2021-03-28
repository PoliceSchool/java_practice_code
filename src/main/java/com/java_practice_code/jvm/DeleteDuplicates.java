package com.java_practice_code.jvm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class DeleteDuplicates {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 4, 5);
        ListNode head = new ListNode();
        ListNode tmp = head;
        for (Integer item : list) {
            ListNode next = new ListNode();
            next.val = item;
            tmp.next = next;
            tmp = next;
        }
        new DeleteDuplicates().deleteDuplicates(head.next);
        System.out.println(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode preNode = new ListNode();
        preNode.next = head;
        ListNode top = head;
        ListNode tail = head.next;

        while (top != null) {
            if (top.val == tail.val) {
                while (tail != null && top.val == tail.val) {
                    tail = tail.next;
                }
                preNode.next = tail;
            } else {
                preNode = top;
                top = top.next;
                tail = tail.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
