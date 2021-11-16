package _32_III_Solution;

import java.util.*;

/**
 * @author YeYaqiao
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class Solution {
    //利用 result 大小判断奇偶，LinkedList 直接从后面填充数据
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (result.size() % 2 == 0) temp.addLast(node.val);
                else temp.addFirst(node.val);
            }
            result.add(temp);
        }
        return result;
    }

    //利用 reverse() 进行逆序
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null)
//            return new ArrayList<>();
//        List<List<Integer>> result = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        boolean flag = true;//flag = true 正序 flag = false 逆序
//        while (!queue.isEmpty()) {
//            List<Integer> temp = new ArrayList<>();
//            for (int i = queue.size(); i > 0; i--) {
//                TreeNode node = queue.poll();
//                temp.add(node.val);
//                if (node.left != null) queue.add(node.left);
//                if (node.right != null) queue.add(node.right);
//            }
//            flag = !flag;
//            if (flag)
//                Collections.reverse(temp);
//            result.add(temp);
//        }
//        return result;
//    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
