package com.java_practice_code.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class BSTIterator {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode one = new TreeNode(3);
        TreeNode two = new TreeNode(15);
        TreeNode three = new TreeNode(9);
        TreeNode four = new TreeNode(20);
        root.left = one;
        root.right = two;
        two.left = three;
        two.right = four;

        BSTIterator bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.next());    // 返回 3
        System.out.println(bSTIterator.next());    // 返回 7
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next());    // 返回 9
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next());    // 返回 15
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next());    // 返回 20
        System.out.println(bSTIterator.hasNext()); // 返回 False
    }


    Queue<Integer> queue = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        iterator(root);
    }

    private void iterator(TreeNode root) {
        if (root == null) {
            return;
        }
        iterator(root.left);
        queue.add(root.val);
        iterator(root.right);
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
