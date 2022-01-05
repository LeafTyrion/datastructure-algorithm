package _0094_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 94. 二叉树的中序遍历
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }

    private void dfs(List<Integer> result, TreeNode root) {
        if (root == null)
            return;
        dfs(result, root.left);
        result.add(root.val);
        dfs(result, root.right);
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

