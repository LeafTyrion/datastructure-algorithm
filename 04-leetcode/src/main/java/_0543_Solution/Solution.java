package _0543_Solution;

/**
 * @author YeYaqiao
 * 543. 二叉树的直径
 */
public class Solution {
    //dfs
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        //计算左右子树的深度和，即左叶子节点到右叶子节点的路径长度，与max 相比取出最大的
        max = Math.max(left + right, max);
        //返回左右子树的最大深度，算上当前节点+1；即返回当前节点的深度
        return Math.max(left, right) + 1;
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
