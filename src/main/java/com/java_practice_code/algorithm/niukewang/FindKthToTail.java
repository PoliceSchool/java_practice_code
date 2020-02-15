package com.java_practice_code.algorithm.niukewang;

/**
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 已通过牛客网测试
 */
public class FindKthToTail {
    /**
     * 解题思路,先遍历整个链表,记录链表的节点个数;
     * 然后再从头遍历至第n-k个节点即可,因为倒数第k个节点就是第n-k个节点
     */
    private static ListNode findKthToTail(ListNode head, int k) {
        ListNode tmp = head;
        int n = 0, count = 0;
        while (null != tmp) {
            n++;
            tmp = tmp.next;
        }
        while (!(n - k == count++) && head != null) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);
        ListNode four = new ListNode(5);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = four;
        System.out.println(findKthToTail(head, 10));
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
