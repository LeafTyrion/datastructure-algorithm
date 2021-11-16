package _32_I_Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author YeYaqiao
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class Solution {

    //辅助队列法
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[]{};
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //每次循环将上次存储的元素出队，并将同一层的元素存入队列中
            TreeNode node = queue.poll();
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
            result.add(node.val);
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
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