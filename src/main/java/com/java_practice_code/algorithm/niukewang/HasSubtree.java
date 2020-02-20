package com.java_practice_code.algorithm.niukewang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * <p>
 * 已通过牛客网测试
 * 解题思路:遍历出树的前序遍历顺序并用list保存,在使用java自带的list接口的containsAll方法判断是否有子集合即可,这一点有点取巧了,如果不行用java的containsAll方法,也可以自行写一个判断是否存在子数组的方法
 * 其实这个思路是有问题的,虽然通过了测试,但是有问题,因为list接口的containsAll方法判断的是
 * 有没有包含数据,不判断顺序是否一样,所以只要两棵树中包含相同的数字,不管是不是子树,都是可以通过的.
 * 后续优化做法：将前序遍历结果转化成字符串，再用字符串的匹配处理即可
 */
public class HasSubtree {
    private static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return trans2String(preOrderTree(root1)).contains(trans2String(preOrderTree(root2)));
    }

    private static String trans2String(Collection<Integer> coll) {
        StringBuffer sb = new StringBuffer();
        coll.forEach(sb::append);
        return sb.toString();
    }

    private static List<Integer> preOrderTree(TreeNode root) {
        if (root != null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            list.addAll(preOrderTree(root.left));
            list.addAll(preOrderTree(root.right));
            return list;
        } else {
            return new ArrayList<>();
        }
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

        TreeNode root2 = new TreeNode(8);
        TreeNode first2 = new TreeNode(9);
        TreeNode second2 = new TreeNode(2);
        root2.left = first2;
        root2.right = second2;

        System.out.println("result: " + hasSubtree(root, root2));
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
