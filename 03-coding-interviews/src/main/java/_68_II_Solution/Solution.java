package _68_II_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 */
public class Solution {


    //递归法
    //二叉树的最近公共祖先的条件：
    //p、q 分别在root的两侧，或者p、q在root的一侧，并且root为p或者q
    //使用前序遍历，搜索整个二叉树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //向下递归时做的操作
        //若当前节点为null，则证明以及越过叶子节点，并且没有找到目标p，q，则向上返回null
        if (root == null)
            return null;
        //若当前节点为p，则说明找到了p节点，向上返回当前节点p
        if (root == p)
            return root;
        //若当前节点为q，则说明找到了q节点，向上返回当前节点q
        if (root == q)
            return root;
        //遍历左子树操作，获取左子节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //遍历右子树操作，获取右子节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //回溯时做的操作
        //若左子节点为空，则说明左子树没有目标节点，则返回右子节点
        if (left == null)
            return right;
        //若右子节点为空，则说明右子树没有目标节点，则返回左子节点
        if (right == null)
            return left;
        //若左右节点都不为空，则当前节点为公共父节点
        return root;
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