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
    //映射中序遍历以便通过根节点获取左,右子树
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        //递归入口,传入当前根节点索引(从前序遍历获取)
        //当前树的根节点索引，左边界索引，右边界索引
        return recur(0, 0, preorder.length - 1);
    }

    //递归当前节点分别获取和构建其左节点和右节点
    private TreeNode recur(int rootIndex, int leftIndex, int rightIndex) {
        //当前树左子树的边界=右子树的边界，则表示当前节点为叶子节点，则无需为其构建左右节点
        if (leftIndex > rightIndex)
            return null;

        //构建当前节点
        TreeNode node = new TreeNode(preorder[rootIndex]);

        //在中序遍历中获取左子树和右子树的分隔点
        int partition = map.get(preorder[rootIndex]);

        //在先序遍历中，当前树的根节点索引+1，则是它左子树的根节点的索引
        //partition - leftIndex + 1 表示左子树的长度
        //先序遍历中的根节点索引+左子树的长度=右子树的根节点索引
        node.left = recur(rootIndex + 1, leftIndex, partition - 1);
        node.right = recur(rootIndex + partition - leftIndex + 1, partition + 1, rightIndex);

        return node;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
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
