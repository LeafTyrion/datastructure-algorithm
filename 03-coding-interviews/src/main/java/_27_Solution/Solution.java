package _27_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 27. 二叉树的镜像
 */
public class Solution {

    //栈解法
//    public TreeNode mirrorTree(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        stack.add(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node == null)
//                break;
//            if (node.left != null)
//                stack.add(node.left);
//            if (node.right != null)
//                stack.add(node.right);
//            TreeNode temp = node.left;
//            node.left = node.right;
//            node.right = temp;
//        }
//        return root;
//    }

    //递归法
    public TreeNode mirrorTree(TreeNode root) {

        if (root == null)
            return null;
        TreeNode leftNode = mirrorTree(root.right);
        TreeNode rightNode = mirrorTree(root.left);
        root.left = leftNode;
        root.right = rightNode;
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