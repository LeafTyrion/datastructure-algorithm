package _68_II_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //若当前节点为空获取是其中任意一个子节点时，返回root即可
        if(root == null || root == p || root == q) return root;
        //遍历左子节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //遍历右子节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //当左节点为空，返回右节点
        if(left == null) return right;
        if(right == null) return left;
        return root;
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