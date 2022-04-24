package _0236_Solution;

/**
 * @author YeYaqiao
 * 236. 二叉树的最近公共祖先
 */
public class Solution {
    //dfs 返回 p q或者root
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q)
            return root;
        if (root == null)
            return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == p && right == q)
            return root;
        else if (left == null)
            return right;
        else if (right == null)
            return left;
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
