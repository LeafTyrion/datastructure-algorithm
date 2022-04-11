package _0144_Solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author YeYaqiao
 * 144. 二叉树的前序遍历
 */
public class Solution {
    //递归
//    List<Integer> result = new ArrayList<>();
//
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if (root != null) {
//            result.add(root.val);
//            preorderTraversal(root.left);
//            preorderTraversal(root.right);
//        }
//        return result;
//    }

    //迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Deque<TreeNode> deque = new ArrayDeque<>();

        TreeNode node = root;
        while (!deque.isEmpty() || node != null) {
            while (node != null) {
                result.add(node.val);
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            node = node.right;
        }
        return result;
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