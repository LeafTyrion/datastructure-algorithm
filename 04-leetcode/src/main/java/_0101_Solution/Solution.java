package _0101_Solution;

import java.util.LinkedList;

/**
 * @author YeYaqiao
 * 101. 对称二叉树
 */
public class Solution {

    //BFS
    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.removeFirst();
            TreeNode right = deque.removeFirst();

            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;

            deque.add(left.left);
            deque.add(right.right);
            deque.add(left.right);
            deque.add(right.left);
        }
        return true;


    }


    //DFS
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null)
//            return true;
//        return recur(root.left, root.right);
//    }
//
//    public boolean recur(TreeNode left, TreeNode right) {
//        if (left == null && right == null)
//            return true;
//        if (left == null || right == null || left.val != right.val)
//            return false;
//        return recur(left.right, right.left) && recur(left.left, right.right);
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
