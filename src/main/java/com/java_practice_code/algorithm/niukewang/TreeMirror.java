package com.java_practice_code.algorithm.niukewang;

/**
 * https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 已通过牛客网测试
 */
public class TreeMirror {
    private static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
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
        Mirror(root);
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
