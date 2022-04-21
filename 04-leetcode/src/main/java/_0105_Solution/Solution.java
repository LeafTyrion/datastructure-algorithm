package _0105_Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeYaqiao
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class Solution {
    //递归
    int[] preorder;
    Map<Integer, Integer> inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        this.preorder = preorder;
        this.inorder = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            this.inorder.put(inorder[i], i);
        }
        return recur(0, 0, length - 1);
    }

    private TreeNode recur(int rootIndex, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex)
            return null;
        TreeNode node = new TreeNode(preorder[rootIndex]);
        int partition = inorder.get(node.val);
        node.left = recur(rootIndex + 1, leftIndex, partition - 1);
        node.right = recur(rootIndex + partition - leftIndex + 1, partition + 1, rightIndex);
        return node;
    }

    //迭代
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int length = preorder.length;
//        TreeNode root = new TreeNode(preorder[0]);
//        Deque<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//        int inorderIndex = 0;
//        for (int i = 1; i < length; i++) {
//            int nodeValue = preorder[i];
//            TreeNode node = stack.peek();
//            if (node != null && node.val != inorder[inorderIndex]) {
//                node.left = new TreeNode(nodeValue);
//                stack.push(node.left);
//            } else {
//                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
//                    node = stack.pop();
//                    inorderIndex++;
//                }
//                node.right = new TreeNode(nodeValue);
//                stack.push(node.right);
//            }
//        }
//        return root;
//    }


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

