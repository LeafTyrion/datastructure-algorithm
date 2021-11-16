package _28_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 28. 对称的二叉树
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        //若根节点为null，则直接返回 true
        if (root == null)
            return true;
        //开始遍历子节点
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode leaf, TreeNode right) {
        //若子节点都为null，则表示对称
        if (leaf == null && right == null)
            return true;
        //若子节点有一个为null或者两个节点的值不相等，则此树是非对称的
        if (leaf == null || right == null || leaf.val != right.val)
            return false;
        //若两个节点值相等并且部位null，表示还未遍历完成，则继续递归比较对称的节点
        return recur(leaf.left, right.right) && recur(leaf.right, right.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
