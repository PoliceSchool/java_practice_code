package com.java_practice_code.algorithm.niukewang;

/**
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 已通过牛客网测试
 */
public class MergeLinkList {
    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    tmp.next = list1;
                    list1 = list1.next;
                } else {
                    tmp.next = list2;
                    list2 = list2.next;
                }
                tmp = tmp.next;
            } else if (list1 != null) {
                tmp.next = list1;
                return head.next;
            } else {
                tmp.next = list2;
                return head.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);
        ListNode four = new ListNode(5);
        head1.next = first;
        first.next = second;
        second.next = third;
        third.next = four;

        ListNode head2 = new ListNode(1);
        ListNode first2 = new ListNode(2);
        ListNode second2 = new ListNode(3);
        ListNode third2 = new ListNode(4);
        ListNode four2 = new ListNode(5);
        head2.next = first2;
        first2.next = second2;
        second2.next = third2;
        third2.next = four2;

        ListNode result = merge(head1, head2);
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
