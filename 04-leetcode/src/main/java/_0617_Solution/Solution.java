package _0617_Solution;

/**
 * @author YeYaqiao
 * 617. 合并二叉树
 */
public class Solution {
    //dfs
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //推出条件，边界判断
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        //构建当前节点内容
        TreeNode node = new TreeNode(root1.val + root2.val);
        //开启递归构建左右子节点
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
}


class TreeNode {
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
