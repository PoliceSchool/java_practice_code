package com.java_practice_code.algorithm.niukewang;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * 已通过牛客网测试
 */
public class ReConstructBinaryTree {
    static int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
    static int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        // 通过前序遍历数组找到根节点
        int rootVal = pre[0];
        // 找到中序遍历数组中根节点的位置,并以此来区分左子树和右子树
        int rootValIndex = 0;
        for (int i : in) {
            if (i == rootVal) {
                break;
            }
            rootValIndex++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootValIndex + 1),
                Arrays.copyOfRange(in, 0, rootValIndex));

        root.right = reConstructBinaryTree(
                Arrays.copyOfRange(pre, rootValIndex + 1, pre.length),
                Arrays.copyOfRange(in, rootValIndex + 1, pre.length));
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new ReConstructBinaryTree().reConstructBinaryTree(pre, in);
        System.out.println(node);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //    private TreeNode reConstructBinaryTree(int rootVal, int[] pre, int[] in) {
//        // 先找到根节点，然后分别找到左右子树，递归去找左右子树的根节点
//        TreeNode root = new TreeNode(rootVal);
//        if (pre.length == 1) {
//            return root;
//        }
//        if (pre.length == 2) {
//            if (rootVal == in[0]) {
//                root.right = new TreeNode(pre[1]);
//            } else {
//                root.left = new TreeNode(pre[1]);
//            }
//            return root;
//        }
////        TreeNode root = new TreeNode(rootVal);
//        for (int i = 0; i < in.length; i++) {
//            if (pre[0] == in[i]) {
//                root.left = reConstructBinaryTree(pre[0], Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
//                root.right = reConstructBinaryTree(pre[0], Arrays.copyOfRange(pre, i + 1, pre.length + 1), Arrays.copyOfRange(in, i + 1, in.length + 1));
//            }
//        }
//        return root;
//    }
}
