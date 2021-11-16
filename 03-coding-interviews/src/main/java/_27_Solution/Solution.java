package _27_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 27. 二叉树的镜像
 */
public class Solution {

    //递归法
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode right = mirrorTree(root.right);
        TreeNode left = mirrorTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    //辅助容器法（栈、队列）
//    public TreeNode mirrorTree(TreeNode root) {
//        if (root == null)
//            return null;
//        Queue<TreeNode> queue = new LinkedList<>();
//        //先将根节点添加入队列
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            //获取一个节点
//            TreeNode node = queue.poll();
//            //交换节点的两个子节点位置
//            TreeNode temp = node.left;
//            node.left = node.right;
//            node.right = temp;
//            //将节点的两个子节点存入容器，继续遍历判断
//            if (node.left != null)
//                queue.add(node.left);
//            if (node.right != null)
//                queue.add(node.right);
//        }
//        //返回根节点
//        return root;
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