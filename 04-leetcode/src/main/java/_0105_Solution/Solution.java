package _0105_Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeYaqiao
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class Solution {
    int[] preorder;
    Map<Integer, Integer> inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = inorder.length;

        this.preorder = preorder;
        this.inorder = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            this.inorder.put(inorder[i], i);
        }
        return recur(0, 0, length - 1);
    }

    private TreeNode recur(int root, int left, int right) {
        //当左边界等于右边界时，表示当前节点为叶子节点
        if (left > right)
            return null;

        TreeNode node = new TreeNode(preorder[root]);

        int partition = inorder.get(preorder[root]);
        node.left = recur(root + 1, left, partition - 1);
        node.right = recur(root + partition + 1 - left, partition + 1, right);
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

