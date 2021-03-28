package com.java_practice_code.jvm;

import java.util.ArrayList;
import java.util.List;

public class RotateRight {

    public static void main(String[] args) {
        new RotateRight().rotateRight(getTestCase3(), 1);

    }

    private static ListNode getTestCase1() {
        // k = 2
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode five = new ListNode(5);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = five;
        return first;
    }

    private static ListNode getTestCase2() {
        // k = 4
        ListNode zero = new ListNode(0);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        zero.next = first;
        first.next = second;
        return zero;
    }

    private static ListNode getTestCase3() {
        // k = 1
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        return first;
    }

    private static ListNode getTestCase4() {
        // k = 2000000000
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        first.next = second;
        second.next = third;
        return first;
    }

    public ListNode rotateRight(ListNode head, int k) {
        int size = size(head);
        if (k == size || size == 0 || k == 0) {
            return head;
        }
        k %= size;
        ListNode tail = getTail(head);
        tail.next = head;
        k = size - k;
        while (k-- > 0) {
            tail = tail.next;
        }
        ListNode ret = tail.next;
        tail.next = null;
        return ret;
    }

    private ListNode getTail(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    private int size(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    static class ListNode {
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
