package com.java_practice_code.algorithm.niukewang;

/**
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * 已通过牛客网测试
 */
public class ReverseList {
    /**
     * 初始状态:
     * head              B
     *  0   ->   0  ->   0
     *           A
     * 第一步:a.next = head;
     * head              B
     * 0   <->   0       0
     *           A
     * 第二步:head = a;
     *          head     B
     * 0   <->   0       0
     *           A
     * 第三步:a = b;
     *          head     B
     * 0   <->   0       0
     *                   A
     * 第四步:b = b.next;
     *          head             B
     * 0   <->   0       0   ->  0
     *                   A
     * 第五步(新的一轮循环):a.next = head;
     *          head               B
     * 0   <->   0   <-    0       0
     *                     A
     */
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head.next;
        ListNode b = head.next.next;
        ListNode tail = head;
        while (b != null) {
            a.next = head;
            head = a;
            a = b;
            b = b.next;
        }
        tail.next = null;
        a.next = head;
        return a;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
//        ListNode second = new ListNode(3);
//        ListNode third = new ListNode(4);
//        ListNode four = new ListNode(5);
        head.next = first;
//        first.next = second;
//        second.next = third;
//        third.next = four;
        reverseList(head);
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
