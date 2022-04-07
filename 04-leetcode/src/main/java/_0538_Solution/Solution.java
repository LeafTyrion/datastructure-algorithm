package _0538_Solution;

/**
 * @author YeYaqiao
 * 538. 把二叉搜索树转换为累加树
 */
public class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.right);
            sum += node.val;
            node.val = sum;
            dfs(node.left);
        }
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
