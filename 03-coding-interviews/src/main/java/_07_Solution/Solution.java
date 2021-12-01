package _07_Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeYaqiao
 * 剑指 Offer 07. 重建二叉树
 */
public class Solution {
    //前序遍历 3 9 2 1 7
    //中序遍历 9 3 1 2 7

    //前序遍历可以确定一棵树的根节点
    //中序遍历可以根据根节点区分去左子树和右子树
    //保存前序遍历以便确定根节点
    int[] preorder;
    //映射中序遍历以便获取左,右子树
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        //递归入口,传入当前根节点索引(从前序遍历获取)
        //左子节点索引和右子节点索引(从中序遍历获取)
        return recur(0, 0, preorder.length - 1);
    }

    //递归当前节点分别获取和构建其左节点和右节点
    private TreeNode recur(int rootIndex, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex)
            return null;

        //构建当前节点
        TreeNode node = new TreeNode(preorder[rootIndex]);

        //在中序遍历中获取左子树和右子树的分隔点
        int partition = map.get(preorder[rootIndex]);

        int nextRoot=rootIndex+1;

        //构建当前节点的左子节点和右子节点
        node.left = recur(rootIndex + 1, leftIndex, partition - 1);
        node.right = recur(rootIndex + partition - leftIndex + 1, partition + 1, rightIndex);

        return node;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree(new int[]{9, 4, 7, 8, 6}, new int[]{7, 4, 8, 9, 6});
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
