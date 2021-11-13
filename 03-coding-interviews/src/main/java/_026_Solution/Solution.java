package _026_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 26. 树的子结构
 * 半知不解
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //若 A树 或 B树 为空，则无子结构存在
        if (A == null || B == null)
            return false;
        //判断 A树 和 B树当前节点的值是否相等
        //分别递归比较他们的左边的子树和右边的子树是否相等
        if (A.val == B.val && (recur(A.left, B.left) && recur(A.right, B.right)))
            return true;
        //若树的同级节点不相等，则将A树的子节点与B树的根节点进行递归比较
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    //子树的递归
    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null)
            return true;

        if (A == null)
            return false;

        if (A.val == B.val)
            return recur(A.left, B.left) && recur(A.right, B.right);
        else
            return false;
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
