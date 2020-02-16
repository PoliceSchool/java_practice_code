package com.java_practice_code.algorithm.niukewang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 已通过牛客网测试
 */
public class PrintFromTopToBottom {
    private static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode first = new TreeNode(8);
        TreeNode second = new TreeNode(7);
        TreeNode third = new TreeNode(9);
        TreeNode four = new TreeNode(2);
        TreeNode five = new TreeNode(4);
        TreeNode six = new TreeNode(7);
        root.left = first;
        root.right = second;
        first.left = third;
        first.right = four;
        four.left = five;
        four.right = six;
        List<Integer> list = printFromTopToBottom(root);
        System.out.println("result: ");
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
