package com.java_practice_code.leetcode;

/**
 * description: leetcode算法题，两数相加，https://leetcode-cn.com/problems/add-two-numbers/submissions/
 * date: Created in 2019/12/26.
 *
 * @author lujingxiao
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null || l2 != null || jinwei != 0) {
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + jinwei;
                temp.next = new ListNode(sum % 10);
                jinwei = sum / 10;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                int sum = l1.val + jinwei;
                temp.next = new ListNode(sum % 10);
                jinwei = sum / 10;
                l1 = l1.next;
            } else if (l2 != null) {
                int sum = l2.val + jinwei;
                temp.next = new ListNode(sum % 10);
                jinwei = sum / 10;
                l2 = l2.next;
            } else {
                temp.next = new ListNode(jinwei);
                jinwei = 0;
            }
            temp = temp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(10 / 10);
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
