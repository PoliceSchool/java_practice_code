package com.java_practice_code.util.map.redblacktreedemo;

public class RBTree<T extends Comparable<T>> {
    /**
     * 根节点
     */
    private RBTNode<T> mRoot;

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public class RBTNode<T extends Comparable<T>> {
        boolean color;
        T key;
        RBTNode<T> left;
        RBTNode<T> right;
        RBTNode<T> parent;

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey() {
            return key;
        }

        public String toString() {
            return "" + key + (this.color == RED ? "(R)" : "(B)");
        }
    }

    public RBTree() {
        this.mRoot = null;
    }

    private RBTNode<T> parentOf(RBTNode<T> node) {
        return node != null ? node.parent : null;
    }

    private boolean colorOf(RBTNode<T> node) {
        return node != null ? node.color : BLACK;
    }

    private boolean isRed(RBTNode<T> node) {
        return (node != null) && (node.color == RED);
    }

    private boolean isBlack(RBTNode<T> node) {
        return isRed(node);
    }

    private void setBlack(RBTNode<T> node) {
        if (node != null)
            node.color = BLACK;
    }

    private void setRed(RBTNode<T> node) {
        if (node != null)
            node.color = RED;
    }

    private void setParent(RBTNode<T> node, RBTNode<T> parent) {
        if (node != null)
            node.parent = parent;
    }

    private void setColor(RBTNode<T> node, boolean color) {
        if (node != null)
            node.color = color;
    }

    /**
     * 前序遍历"红黑树"
     */
    private void preOrder(RBTNode<T> tree) {
        if (tree != null) {
            System.out.println(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    /**
     * 中序遍历红黑树
     */
    private void inOrder(RBTNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.println(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    /**
     * 后序遍历红黑树
     */
    private void postOrder(RBTNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.key + " ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    /**
     * (递归实现)查找红黑树中键值为key的节点
     */
    private RBTNode<T> search(RBTNode<T> x, T key) {
        if (x == null) {
            return x;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return search(x.left, key);
        } else if (cmp > 0) {
            return search(x.right, key);
        } else {
            return x;
        }
    }

    public RBTNode<T> search(T key) {
        return search(mRoot, key);
    }

    /**
     * (非递归实现)查找红黑树中键值为key的节点
     */
    private RBTNode<T> iterativeSearch(RBTNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x;
            }
        }
        return x;
    }

    public RBTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /**
     * 查找最小节点:返回tree为根节点的红黑树的最小节点
     */
    private RBTNode<T> minimum(RBTNode<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    public T minimum() {
        RBTNode<T> p = minimum(mRoot);
        if (p != null) {
            return p.key;
        }
        return null;
    }

    /**
     * 查找最大节点:返回tree为根节点的红黑树的最大节点
     */
    private RBTNode<T> maximum(RBTNode<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    public T maximum() {
        RBTNode<T> p = maximum(mRoot);
        if (p != null) {
            return p.key;
        }
        return null;
    }

    /**
     * 找到节点x的后继节点,即查找"红黑树中数据之大于该节点"的"最小节点"
     */
    public RBTNode<T> successor(RBTNode<T> x) {
        // 如果x存在右孩子,则"x的后继节点"为"以其后继节点为根的子树的最小节点"
        if (x.right != null) {
            return minimum(x.right);
        }

        // 如果没有右孩子.则x有以下两种可能:
        // (01) x是一个左孩子,则x的后继节点为它的父节点
        // (02) x是一个右孩子,则查找x的最低的父节点,并且该父节点要具有左孩子,找到这个最低的父节点就是x的后继节点
        RBTNode<T> y = x.parent;
        while ((y != null) && (x == y.right)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 找节点x的前驱节点,即,查找红黑树中数据值小于该节点的最大节点
     */
    public RBTNode<T> predecessor(RBTNode<T> x) {
        // 如果存在左孩子,则x的前驱节点为以其左孩子为根的子树的最大节点
        if (x.left != null) {
            return maximum(x.left);
        }
        // 如果x没有左孩子,则x有以下两种可能
        // (01) x是一个右孩子,则x的前驱节点为他的父节点
        // (02) x是一个左孩子,则查找x的最低的父节点,并且该父节点要具有右孩子,找到这个最低的父节点就是x的前驱节点
        RBTNode<T> y = x.parent;
        while ((y != null) && (x == y.left)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 对红黑树的节点x进行左旋转
     */
    private void leftRotate(RBTNode<T> x) {
        // 设置x的右孩子为y
        RBTNode<T> y = x.right;

        // 将y的左孩子设为x的右孩子
        // 如果y的左孩子非空,将x设为y的左孩子的父亲
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        // 将x的父亲设为y的父亲
        y.parent = x.parent;

        if (x.parent == null) {
            this.mRoot = y;
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        // 将"x"设为y的左孩子
        y.left = x;
        // 将x的父节点设为y
        x.parent = y;
    }

    private void rightRotate(RBTNode<T> y) {
        // 设置y是当前节点的左孩子
        RBTNode<T> x = y.left;

        // 将x的右孩子设为y的左孩子
        // 如果x的右孩子不为空的话,将y设为x的右孩子的父亲
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }

        // 将y的父亲设为x的父亲
        x.parent = y.parent;
        if (y.parent == null) {
            this.mRoot = x;
        } else {
            if (y == y.parent.right) {
                y.parent.right = x;
            } else {
                y.parent.left = x;
            }
        }
        // 将 “y” 设为 “x的右孩子”
        x.right = y;

        // 将 “y的父节点” 设为 “x”
        y.parent = x;
    }
}
