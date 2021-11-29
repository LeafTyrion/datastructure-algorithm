package _34_Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author YeYaqiao
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class Solution {
    //dfs 深度优先搜索，递归
    private final List<List<Integer>> result = new ArrayList<>();
    private final LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return result;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null)
            return;
        //将当前节点值存入 temp 中
        temp.add(node.val);
        //target 减去相应的值
        target -= node.val;
        //当遍历到叶子节点并且target已经为0，则证明这条路径符合
        if (node.left == null && node.right == null && target == 0)
            //存入 result
            result.add(new LinkedList<>(temp));
        //继续递归进行前序遍历
        dfs(node.left, target);
        dfs(node.right, target);
        //回溯时清除 temp 中的元素
        temp.removeLast();
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
