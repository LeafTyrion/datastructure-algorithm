package _0617_Solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YeYaqiao
 * 617. 合并二叉树
 */
public class Solution {

    //bfs,利用队列
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        TreeNode root = new TreeNode(root1.val + root2.val);
        Queue<TreeNode> master = new LinkedList<>();
        Queue<TreeNode> t1 = new LinkedList<>();
        Queue<TreeNode> t2 = new LinkedList<>();
        master.add(root);
        t1.add(root1);
        t2.add(root2);

        while (!t1.isEmpty() && !t2.isEmpty()) {
            TreeNode node = master.poll();
            TreeNode node1 = t1.poll();
            TreeNode node2 = t2.poll();

            TreeNode left1 = node1.left;
            TreeNode left2 = node2.left;
            TreeNode right1 = node1.right;
            TreeNode right2 = node2.right;

            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    master.add(left);
                    t1.add(left1);
                    t2.add(left2);
                } else if (left1 != null)
                    node.left = left1;
                else if (left2 != null)
                    node.left = left2;
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    master.add(right);
                    t1.add(right1);
                    t2.add(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }

        }
        return root;
    }

    //dfs
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        //推出条件，边界判断
//        if (root1 == null)
//            return root2;
//        if (root2 == null)
//            return root1;
//        //构建当前节点内容
//        TreeNode node = new TreeNode(root1.val + root2.val);
//        //开启递归构建左右子节点
//        node.left = mergeTrees(root1.left, root2.left);
//        node.right = mergeTrees(root1.right, root2.right);
//        return node;
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
